package com.techdevcol.uhelper.model;

import com.google.firebase.Timestamp;

public class Curso {
    public static final String NAME_COLLECTION = "Curso";
    private Docente docente;
    private Asignatura asignatura;
    private Timestamp fecha;
    private Curso(){

    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}
