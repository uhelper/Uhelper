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
import android.widget.TextView;

import com.techdevcol.uhelper.R;
import com.techdevcol.uhelper.activities.RegistroUsuarioActivity;
import com.techdevcol.uhelper.model.Estudiante;

public class FragmentRegistro2 extends Fragment implements IvalidFragment{


    private TextInputEditText txtCarrera;
    private TextInputEditText txtSemestre;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro2, container, false);

        txtCarrera =  view.findViewById(R.id.txtCarrera);
        txtSemestre = view.findViewById(R.id.txtSemestre);
        setUpTextInputEditText();
        return view;
    }
    public void setUpTextInputEditText(){
        txtCarrera.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    validarCarrera();
                }
            }
        });
        txtCarrera.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validarCarrera();
            }
        });

        txtSemestre.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    validarSemestre();
                }
            }
        });
        txtSemestre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validarSemestre();
            }
        });
    }
    public boolean isEmpty(Editable editable){
        return TextUtils.isEmpty(editable);
    }
    public void validarCarrera(){

        if(isEmpty(txtCarrera.getText())){
            txtCarrera.setError("Ingresa el nombre de la carrera que estudias");
        }
        else{
            txtCarrera.setError(null);
        }
    }
    public void validarSemestre(){

        if(isEmpty(txtSemestre.getText())){
            txtSemestre.setError("Ingresa el semestre en el que vas");
        }
        else{
            txtSemestre.setError(null);
        }
    }
    @Override
    public boolean isValidFragment() {
        validarCarrera();
        validarSemestre();
        if(txtSemestre.getError()!=null || txtCarrera.getError()!=null){
            return false;
        }
        else {
            Estudiante estudiante= ((RegistroUsuarioActivity) this.getActivity()).getEstudiantePoAgregar();
            estudiante.setCarrera(txtCarrera.getText().toString());
            estudiante.setSemestre(Integer.parseInt(txtSemestre.getText().toString()));
            return true;
        }
    }

}
