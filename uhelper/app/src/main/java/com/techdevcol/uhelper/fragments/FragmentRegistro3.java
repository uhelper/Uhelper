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
import com.techdevcol.uhelper.activities.RegistroUsuarioActivity;

public class FragmentRegistro3 extends Fragment {
    private TextView txtTelefono;
    private TextView txtDireccion;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro1, container, false);

        txtTelefono = (TextView) view.findViewById(R.id.txtTelefono);
        txtDireccion = (TextView) view.findViewById(R.id.txtDireccion);

        return view;
    }

    public void openNextFragment() {
        ((RegistroUsuarioActivity) getActivity()).setViewPager(3);
    }


}
