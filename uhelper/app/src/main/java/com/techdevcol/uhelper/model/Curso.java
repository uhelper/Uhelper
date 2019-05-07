package com.techdevcol.uhelper.model;

import com.google.firebase.Timestamp;

import java.io.Serializable;
import java.util.Date;

public class Curso implements Serializable
{
    public static final String NAME_COLLECTION = "Curso";
    private Docente docente;
    private Asignatura asignatura;
    private Date fecha;
    private int grupo;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }
}
