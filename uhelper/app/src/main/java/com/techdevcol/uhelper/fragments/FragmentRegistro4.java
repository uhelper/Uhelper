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
import com.techdevcol.uhelper.R;
import com.techdevcol.uhelper.activities.RegistroUsuarioActivity;
import com.techdevcol.uhelper.model.Estudiante;

public class FragmentRegistro4 extends Fragment implements  IvalidFragment{

    private TextInputEditText txtContrasenia;
    private TextInputEditText txtConfirmarContrasenia;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro4, container, false);
        txtContrasenia = view.findViewById(R.id.txtContrasena);
        txtConfirmarContrasenia =view.findViewById(R.id.txtConfirmar);
        setUpInputFields();
        return view;
    }

    public void setUpInputFields(){
        txtContrasenia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validarPassword();
            }
        });
        txtConfirmarContrasenia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validarConfimacion();
            }
        });
        txtContrasenia.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    validarPassword();
                }
            }
        });
        txtConfirmarContrasenia.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    validarConfimacion();
                }
            }
        });
    }
    private void validarPassword(){
        if(TextUtils.isEmpty(txtContrasenia.getText())){
            txtContrasenia.setError(getString(R.string.input_password));
        }
        else {
            if(txtContrasenia.getText().length()<6){
                txtContrasenia.setError(getString(R.string.input_password));
            }
            else {
                txtContrasenia.setError(null);
            }
        }
    }
    private void validarConfimacion(){
        if(TextUtils.isEmpty(txtConfirmarContrasenia.getText())){
            txtConfirmarContrasenia.setError(getString(R.string.input_password));
        }
        else {
            if(txtConfirmarContrasenia.getText().toString().compareTo(txtContrasenia.getText().toString())==0){
                txtConfirmarContrasenia.setError(null);
            }
            else {
                txtConfirmarContrasenia.setError(getString(R.string.input_password_confirmacion));
            }
        }
    }
    @Override
    public boolean isValidFragment() {
        validarPassword();
        validarConfimacion();
        if(txtContrasenia.getError()!=null || txtConfirmarContrasenia.getError()!=null){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public Estudiante capturarDatosFragment(Estudiante estudiante) {
        estudiante.setPassword(txtContrasenia.getText().toString());
        return estudiante;
    }
}
