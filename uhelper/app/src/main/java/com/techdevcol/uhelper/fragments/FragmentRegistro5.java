package com.techdevcol.uhelper.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.techdevcol.uhelper.R;
import com.techdevcol.uhelper.activities.RegistroUsuarioActivity;
import com.techdevcol.uhelper.model.Estudiante;

public class FragmentRegistro5 extends Fragment implements IvalidFragment{


    private Button btnEmpezar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro5, container, false);
        btnEmpezar = (Button) view.findViewById(R.id.btnEmpezar);
        btnEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistroUsuarioActivity registroUsuarioActivity= (RegistroUsuarioActivity) FragmentRegistro5.this.getActivity();
                registroUsuarioActivity.registrarEstudiante();
            }
        });
        return view;
    }
    @Override
    public boolean isValidFragment() {
        return true;
    }

    @Override
    public Estudiante capturarDatosFragment(Estudiante estudiante) {
        return estudiante;
    }


}
