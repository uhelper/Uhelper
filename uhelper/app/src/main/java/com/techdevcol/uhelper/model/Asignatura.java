package com.techdevcol.uhelper.model;

import java.io.Serializable;

public class Asignatura implements Serializable
{
    public static final String NAME_COLLECTION = "Asignaturas";
    private int creditos;
    private String nombre;
    private int semestre;
    public Asignatura(){

    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
