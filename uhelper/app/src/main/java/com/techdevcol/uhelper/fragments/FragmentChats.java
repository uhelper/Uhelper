package com.techdevcol.uhelper.fragments;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techdevcol.uhelper.R;

public class FragmentChats extends Fragment {

    public static FragmentChats newInstance() {
        FragmentChats fragment = new FragmentChats();
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