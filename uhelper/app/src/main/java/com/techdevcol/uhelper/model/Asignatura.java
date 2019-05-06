package com.techdevcol.uhelper.model;

public class Asignatura {
    public static final String NAME_COLLECTION = "Asignaturas";
    private int creditos;
    private String nombre;
    public Asignatura(){

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
