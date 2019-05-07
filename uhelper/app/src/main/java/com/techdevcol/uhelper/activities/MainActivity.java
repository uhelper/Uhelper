package com.techdevcol.uhelper.activities;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;
import com.techdevcol.uhelper.R;
import com.techdevcol.uhelper.adapters.SectionsPagerAdapter;
import com.techdevcol.uhelper.model.Curso;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private NavigationView navigationView;
    private static final String TAG = "MainActivity";
    //oidor del click sobre un item de asignaura
    private OnclickAsignaturaListener onclickAsignaturaListener;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Navigation drawer
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        //Oidor de eventos der el usuario autenticado actualmente
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                updateNavigationInfo(user);
            }
        };
        setUpTabbedActivity();
    }
    public void setUpTabbedActivity()
    {
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

    private void updateNavigationInfo(FirebaseUser user)
    {
        if(user!=null)
        {
            View navigationHeader=navigationView.getHeaderView(0);
            TextView email=navigationHeader.findViewById(R.id.emailNavigationHeader);
            email.setText(user.getEmail());
            TextView nombre=navigationHeader.findViewById(R.id.nombreNavigationHeader);
            nombre.setText(user.getDisplayName());
            ImageView imageView=navigationHeader.findViewById(R.id.imageNavigationHeader);
            Picasso.get().load(user.getPhotoUrl()).into(imageView);
        }
        else
        {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.cerrarSesion) {
            FirebaseAuth.getInstance().signOut();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_notificationes) {
            Intent intent = new Intent(this, NotificacionesActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_recordatorios) {
            Intent intent = new Intent(this, RecordatorioActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_tutorias) {
            Intent intent = new Intent(this, NotificacionesActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_configuraciones) {

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(firebaseAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(firebaseAuthListener!=null)
        {
            FirebaseAuth.getInstance().removeAuthStateListener(firebaseAuthListener);
        }
    }

    public void btn(View view)
    {
        String idUsuarioActual=FirebaseAuth.getInstance().getCurrentUser().getUid();
        Query query=FirebaseFirestore.getInstance().collection(Curso.NAME_COLLECTION)
                .whereArrayContains("estudiantes",idUsuarioActual);
            query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful())
                {
                    if (task.isSuccessful()) {
                        List<Curso> cursos=task.getResult().toObjects(Curso.class);
                        Toast.makeText(MainActivity.this, ""+cursos.size(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "asas", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "Error getting documents: ", task.getException());
                    }
                }
                else {

                }
            }
        });
    }
    public interface  OnclickAsignaturaListener
    {
        public void onClickCursoItem(Curso curso);
    }
    public OnclickAsignaturaListener getOnclickAsignaturaListener()
    {
        if(onclickAsignaturaListener==null)
        {
            return new OnclickAsignaturaListener() {
                @Override
                public void onClickCursoItem(Curso curso) {
                    //lanzar intent cuando de da click sobre el item de asignaturas
                    Intent intent = new Intent(MainActivity.this, DetalleAsignatura.class);
                    intent.putExtra(DetalleAsignatura.DATA_CURSO, curso);
                    startActivity(intent);
                }
            };
        }
        return onclickAsignaturaListener;
    }
}
