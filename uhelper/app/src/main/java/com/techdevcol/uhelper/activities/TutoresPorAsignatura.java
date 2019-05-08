package com.techdevcol.uhelper.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.techdevcol.uhelper.R;
import com.techdevcol.uhelper.adapters.TutorAdapter;
import com.techdevcol.uhelper.model.Asignatura;
import com.techdevcol.uhelper.model.Curso;
import com.techdevcol.uhelper.model.Tutor;

public class TutoresPorAsignatura extends AppCompatActivity {

    public static final String DATA_ASIGNATURA="Asignatura";
    private Asignatura asignatura;
    private RecyclerView recyclerView;
    private TutorAdapter tutorAdapter;
    private TextView textViewNombreAsignatura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutores_por_asignatura);
        asignatura= (Asignatura) getIntent().getSerializableExtra(DATA_ASIGNATURA);
        textViewNombreAsignatura=findViewById(R.id.labNombreAsignatura);
        textViewNombreAsignatura.setText(asignatura.getNombre());
        setUpRvTutores();
    }

    private void setUpRvTutores() {
        recyclerView=findViewById(R.id.rvTutores);
        Query query= FirebaseFirestore.getInstance().collection(Tutor.NAME_COLLECTION)
                .whereEqualTo("asignaturaId",asignatura.getAsignaturaId());
        FirestoreRecyclerOptions<Tutor> options= new FirestoreRecyclerOptions.Builder<Tutor>()
                .setQuery(query,Tutor.class)
                .build();
        tutorAdapter=new TutorAdapter(options);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(tutorAdapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        tutorAdapter.stopListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        tutorAdapter.startListening();
    }
}
