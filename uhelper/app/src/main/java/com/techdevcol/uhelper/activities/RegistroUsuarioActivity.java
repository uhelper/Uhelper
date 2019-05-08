package com.techdevcol.uhelper.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.FirebaseFirestore;
import com.techdevcol.uhelper.R;
import com.techdevcol.uhelper.adapters.SectionStatePagerAdapterRegistro;
import com.techdevcol.uhelper.fragments.FragmentRegistro1;
import com.techdevcol.uhelper.fragments.FragmentRegistro2;
import com.techdevcol.uhelper.fragments.FragmentRegistro3;
import com.techdevcol.uhelper.fragments.FragmentRegistro4;
import com.techdevcol.uhelper.fragments.FragmentRegistro5;
import com.techdevcol.uhelper.fragments.IvalidFragment;
import com.techdevcol.uhelper.model.Estudiante;

import java.util.ArrayList;
import java.util.List;


public class RegistroUsuarioActivity extends AppCompatActivity {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private SectionStatePagerAdapterRegistro sectionStatePager;
    private ViewPager viewPager;
    private Estudiante estudiantePoAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario1);
        setupViewPager();
    }
    private void setupViewPager() {
        sectionStatePager = new SectionStatePagerAdapterRegistro(getSupportFragmentManager());
        viewPager = findViewById(R.id.container);
        estudiantePoAgregar=new Estudiante();
        mFragmentList.add(new FragmentRegistro1());
        mFragmentList.add(new FragmentRegistro2());
        mFragmentList.add(new FragmentRegistro3());
        mFragmentList.add(new FragmentRegistro4());
        mFragmentList.add(new FragmentRegistro5());
        sectionStatePager.addFragments(mFragmentList);
        viewPager.setAdapter(sectionStatePager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if(i>0){
                    IvalidFragment ivalidFragment= (IvalidFragment) mFragmentList.get(i-1);
                    if(ivalidFragment.isValidFragment()){
                        viewPager.setCurrentItem(i);
                        estudiantePoAgregar=ivalidFragment.capturarDatosFragment(estudiantePoAgregar);
                    }else {
                        viewPager.setCurrentItem(i-1);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    public void registrarEstudiante(){
        showProgressDialog();
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(estudiantePoAgregar.getEmail(),estudiantePoAgregar.getPassword())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                .setDisplayName(estudiantePoAgregar.getNombres() + " " +estudiantePoAgregar.getApellidos())
                                .build();

                        FirebaseAuth.getInstance().getCurrentUser().updateProfile(profileUpdates);
                        estudiantePoAgregar.setPassword(null);
                        FirebaseFirestore.getInstance().collection(Estudiante.NAME_COLLECTION)
                                .document(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .set(estudiantePoAgregar)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(RegistroUsuarioActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                                        hideProgressDialog();
                                        finish();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(RegistroUsuarioActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                        hideProgressDialog();
                                        finish();
                                    }
                                });
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegistroUsuarioActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                hideProgressDialog();
                finish();
            }
        });
    }

    public ProgressDialog mProgressDialog;

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.cargando));
            mProgressDialog.setIndeterminate(true);
        }
        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
    public Estudiante getEstudiantePoAgregar(){
        return estudiantePoAgregar;
    }
}
