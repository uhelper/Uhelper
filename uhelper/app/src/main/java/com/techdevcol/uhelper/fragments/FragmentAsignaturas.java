package com.techdevcol.uhelper.fragments;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.techdevcol.uhelper.R;
import com.techdevcol.uhelper.activities.MainActivity;
import com.techdevcol.uhelper.adapters.AsignaturasAdapter;
import com.techdevcol.uhelper.model.Curso;

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
        //Query de ejemplo se de cambiar de acuerdo la coleccion y consulta que se necesite
        Query query= FirebaseFirestore.getInstance().collection(Curso.NAME_COLLECTION);
        FirestoreRecyclerOptions<Curso> options= new FirestoreRecyclerOptions.Builder<Curso>()
                .setQuery(query,Curso.class)
                .build();
        AsignaturasAdapter asignaturasAdapter=new AsignaturasAdapter(options);
        MainActivity main= (MainActivity) this.getActivity();
        asignaturasAdapter.setOnclickAsignaturaListener(main.getOnclickAsignaturaListener());
        RecyclerView recyclerView=root.findViewById(R.id.rvAsignaturas);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager lmGrid = new GridLayoutManager(this.getActivity(), 2);
        recyclerView.setLayoutManager(lmGrid);
        recyclerView.setAdapter(asignaturasAdapter);
        return root;
    }

}