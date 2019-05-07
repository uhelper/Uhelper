package com.techdevcol.uhelper.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techdevcol.uhelper.R;
import com.techdevcol.uhelper.activities.RegistroUsuarioActivity;

public class FragmentRegistro1 extends Fragment implements IvalidFragment{

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
    public void openNextFragment() {
        ((RegistroUsuarioActivity) getActivity()).setViewPager(1);
    }

    @Override
    public boolean isValidFragment() {

        return !TextUtils.isEmpty(txtNombres.getText()) && !TextUtils.isEmpty(txtApellidos.getText());
    }

}



