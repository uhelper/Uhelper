package com.techdevcol.uhelper.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techdevcol.uhelper.R;
import com.techdevcol.uhelper.activities.RegistroUsuarioActivity;
import com.techdevcol.uhelper.model.Estudiante;

public class FragmentRegistro1 extends Fragment implements IvalidFragment{

    private TextInputEditText txtNombres;
    private TextInputEditText txtApellidos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro1, container, false);
        txtNombres = view.findViewById(R.id.txtNombres);
        txtApellidos = view.findViewById(R.id.txtApellidos);
        setUpTextInputEditText();
        return view;
    }
    public void setUpTextInputEditText(){
        txtNombres.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validarNombre();
            }
        });
        txtNombres.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    validarNombre();
                }
            }
        });
        txtApellidos.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validarApellido();
            }
        });
        txtApellidos.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    validarApellido();
                }
            }
        });
    }
    public boolean isEmpty(Editable editable){
        return TextUtils.isEmpty(editable);
    }
    public void validarNombre(){

        if(isEmpty(txtNombres.getText())){
            txtNombres.setError(getString(R.string.input_registro_nombres));
        }
        else{
            txtNombres.setError(null);
        }
    }
    public void validarApellido(){

        if(isEmpty(txtApellidos.getText())){
            txtApellidos.setError(getString(R.string.input_registro_apellidos));
        }
        else{
            txtApellidos.setError(null);
        }
    }

    @Override
    public boolean isValidFragment() {
        validarApellido();
        validarNombre();
        if(txtNombres.getError()!=null || txtApellidos.getError()!= null){
            return false;
        }
        else {

            return true;
        }
    }

    @Override
    public Estudiante capturarDatosFragment(Estudiante estudiante) {
        estudiante.setNombres(txtNombres.getText().toString());
        estudiante.setApellidos(txtApellidos.getText().toString());
        return estudiante;
    }

}



