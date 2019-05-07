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

public class FragmentRegistro4 extends Fragment {


    private Button btnEmpezar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro1, container, false);

        btnEmpezar = (Button) view.findViewById(R.id.btnEmpezar);
        return view;
    }


    public void register() {

        //TODO Registrar.

    }

}
