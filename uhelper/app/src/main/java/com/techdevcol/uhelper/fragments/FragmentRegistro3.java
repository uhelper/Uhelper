package com.techdevcol.uhelper.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techdevcol.uhelper.R;
import com.techdevcol.uhelper.activities.RegistroUsuarioActivity;
import com.techdevcol.uhelper.model.Estudiante;

public class FragmentRegistro3 extends Fragment implements IvalidFragment{
    private TextInputEditText txtTelefono;
    private TextInputEditText txtDireccionEmail;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro3, container, false);
        txtTelefono = view.findViewById(R.id.txtTelefono);
        txtDireccionEmail = view.findViewById(R.id.txtDireccion);
        setUpInputFields();
        return view;
    }
    public void setUpInputFields(){
        txtTelefono.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validarTelefono();
            }
        });
        txtDireccionEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validarEmail();
            }
        });
        txtTelefono.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    validarTelefono();
                }
            }
        });
        txtDireccionEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    validarEmail();
                }
            }
        });
    }
    public void validarEmail(){
        if(!Patterns.EMAIL_ADDRESS.matcher(txtDireccionEmail.getText()).matches()){
            txtDireccionEmail.setError(getString(R.string.email_invalido));
        }
        else {
            txtDireccionEmail.setError(null);
        }
    }
    public void validarTelefono(){
        if(isEmpty(txtTelefono.getText())){
            txtTelefono.setError("Ingrese su numero de telefono");
        }
        else {
            txtTelefono.setError(null);
        }
    }
    public boolean isEmpty(Editable editable){
        return TextUtils.isEmpty(editable);
    }
    @Override
    public boolean isValidFragment() {
        validarEmail();
        validarTelefono();
        if(txtDireccionEmail.getError()!=null || txtTelefono.getError()!=null){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public Estudiante capturarDatosFragment(Estudiante estudiante) {
        estudiante.setCelular(txtTelefono.getText().toString());
        estudiante.setEmail(txtDireccionEmail.getText().toString());
        return estudiante;
    }

}
