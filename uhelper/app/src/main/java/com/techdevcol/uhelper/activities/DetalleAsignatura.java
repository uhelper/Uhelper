package com.techdevcol.uhelper.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.techdevcol.uhelper.R;
import com.techdevcol.uhelper.adapters.ActividadAdapter;
import com.techdevcol.uhelper.adapters.NotificacionAdapter;
import com.techdevcol.uhelper.model.Actividad;
import com.techdevcol.uhelper.model.Curso;
import com.techdevcol.uhelper.model.Notificacion;

public class DetalleAsignatura extends AppCompatActivity {

    private TextView txtNombreAsignatura, txtCreditos, txtSemestre, txtGrupo, txtDocente;
    private RecyclerView rvActividades;
    private ActividadAdapter actividadAdapter;
    private Curso curso;
    public final static String DATA_CURSO = "curso";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_asignatura);
        curso = (Curso) getIntent().getSerializableExtra(DATA_CURSO);

        txtNombreAsignatura = findViewById(R.id.txtAsignatura);
        txtCreditos = findViewById(R.id.txtCreditos);
        txtSemestre = findViewById(R.id.txtSemestre);
        txtGrupo = findViewById(R.id.txtGrupo);
        txtDocente = findViewById(R.id.txtDocente);
        rvActividades = findViewById(R.id.rvActividades);

        String idUsuarioActual= FirebaseAuth.getInstance().getCurrentUser().getUid();
        Query query = FirebaseFirestore.getInstance().collection(Actividad.NAME_COLLECTION)
                .whereArrayContains("curso",idUsuarioActual).;
        FirestoreRecyclerOptions<Actividad> options= new FirestoreRecyclerOptions.Builder<Actividad>()
                .setQuery(query, Actividad.class)
                .build();
        actividadAdapter = new ActividadAdapter(options);
        rvActividades.setLayoutManager(new LinearLayoutManager(this));
        rvActividades.setAdapter(actividadAdapter);
        llenarDatos();
    }

    @Override
    protected void onStart() {
        super.onStart();
        actividadAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        actividadAdapter.stopListening();
    }

    private void llenarDatos()
    {
        txtNombreAsignatura.setText(curso.getAsignatura().getNombre());
        txtCreditos.setText(getString(R.string.creditos)+curso.getAsignatura().getCreditos()+"");
        txtSemestre.setText("Semestre: "+curso.getAsignatura().getSemestre()+"");
        txtGrupo.setText("Grupo: "+curso.getGrupo()+"");
        txtDocente.setText("Doc "+curso.getDocente().getNombres() + " "+curso.getDocente().getApellidos());
    }
}
