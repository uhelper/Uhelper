package com.techdevcol.uhelper.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.techdevcol.uhelper.R;
import com.techdevcol.uhelper.model.Curso;

public class DetalleAsignatura extends AppCompatActivity {

    private TextView txtNombreAsignatura, txtCreditos, txtSemestre, txtGrupo, txtDocente;
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

        llenarDatos();
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
