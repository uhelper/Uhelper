package com.techdevcol.uhelper.model;

import com.google.firebase.Timestamp;

import java.io.Serializable;

public class Actividad implements Serializable
{
    public static final String NAME_COLLECTION = "Actividad";
    private String descripcion;
    private Timestamp fecha;

    public Actividad() {

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}
