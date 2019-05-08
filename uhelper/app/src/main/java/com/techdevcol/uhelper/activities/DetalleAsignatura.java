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
import com.techdevcol.uhelper.adapters.CalificacionAdapter;
import com.techdevcol.uhelper.model.Actividad;
import com.techdevcol.uhelper.model.Calificacion;
import com.techdevcol.uhelper.model.Curso;

public class DetalleAsignatura extends AppCompatActivity {

    private TextView txtNombreAsignatura, txtCreditos, txtSemestre, txtGrupo, txtDocente, txtDefinitiva;
    private RecyclerView rvActividades, rvCalificaciones;
    private ActividadAdapter actividadAdapter;
    private CalificacionAdapter calificacionAdapter;
    private Curso curso;
    public final static String DATA_CURSO = "curso";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_asignatura);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_keyboard_backspace_black_24dp);
        curso = (Curso) getIntent().getSerializableExtra(DATA_CURSO);
        txtNombreAsignatura = findViewById(R.id.txtAsignatura);
        txtCreditos = findViewById(R.id.txtCreditos);
        txtSemestre = findViewById(R.id.txtSemestre);
        txtGrupo = findViewById(R.id.txtGrupo);
        txtDocente = findViewById(R.id.txtDocente);
        txtDefinitiva = findViewById(R.id.txtDefinitiva);
        setUpRecyclerViewActividades();
        setUpRecyclerViewCalificaciones();
        llenarDatos();
    }

    public void setUpRecyclerViewActividades(){
        rvActividades = findViewById(R.id.rvActividades);
        Query query = FirebaseFirestore.getInstance().collection(Curso.NAME_COLLECTION).document(curso.getCursoId())
                .collection(Actividad.NAME_COLLECTION);
        FirestoreRecyclerOptions<Actividad> options= new FirestoreRecyclerOptions.Builder<Actividad>()
                .setQuery(query, Actividad.class)
                .build();
        actividadAdapter = new ActividadAdapter(options);
        rvActividades.setLayoutManager(new LinearLayoutManager(this));
        rvActividades.setAdapter(actividadAdapter);
    }

    public void setUpRecyclerViewCalificaciones(){
        rvCalificaciones = findViewById(R.id.rvCalificaciones);
        String idUsuarioActual= FirebaseAuth.getInstance().getCurrentUser().getUid();
        Query query = FirebaseFirestore.getInstance().collection(Curso.NAME_COLLECTION).document(curso.getCursoId())
                .collection(Calificacion.NAME_COLLECTION).whereEqualTo("userId", idUsuarioActual);
        FirestoreRecyclerOptions<Calificacion> options= new FirestoreRecyclerOptions.Builder<Calificacion>()
                .setQuery(query, Calificacion.class)
                .build();
        calificacionAdapter = new CalificacionAdapter(options);
        rvCalificaciones.setLayoutManager(new LinearLayoutManager(this));
        rvCalificaciones.setAdapter(calificacionAdapter);
    }

    public double calcularDefinitiva()
    {
        double definitiva = calificacionAdapter.getDefinitiva();
        return definitiva;
    }

    @Override
    protected void onStart() {
        super.onStart();
        actividadAdapter.startListening();
        calificacionAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        actividadAdapter.stopListening();
        calificacionAdapter.stopListening();
    }

    private void llenarDatos()
    {
        txtNombreAsignatura.setText(curso.getAsignatura().getNombre());
        txtCreditos.setText(getString(R.string.creditos)+curso.getAsignatura().getCreditos()+"");
        txtSemestre.setText("Semestre: "+curso.getAsignatura().getSemestre()+"");
        txtGrupo.setText("Grupo: "+curso.getGrupo()+"");
        txtDocente.setText("Doc "+curso.getDocente().getNombres() + " "+curso.getDocente().getApellidos());
        txtDefinitiva.setText("Definitiva: " + calcularDefinitiva());
    }
}
