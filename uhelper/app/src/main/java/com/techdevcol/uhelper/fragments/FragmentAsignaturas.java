package com.techdevcol.uhelper.fragments;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techdevcol.uhelper.R;

public class FragmentAsignaturas extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static FragmentAsignaturas newInstance() {
        FragmentAsignaturas fragment = new FragmentAsignaturas();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_asignaturas, container, false);
        return root;
    }
}