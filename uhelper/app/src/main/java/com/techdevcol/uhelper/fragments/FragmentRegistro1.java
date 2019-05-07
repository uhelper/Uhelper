package com.techdevcol.uhelper.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techdevcol.uhelper.R;

public class FragmentRegistro1 extends Fragment {

    private TextView txtNombres;
    private TextView txtApellidos;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro1, container, false);

        txtNombres = (TextView) view.findViewById(R.id.txtNombres);
        txtApellidos = (TextView) view.findViewById(R.id.txtApellidos);

        return view;
    }
}



