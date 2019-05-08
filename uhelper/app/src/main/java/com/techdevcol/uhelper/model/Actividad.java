package com.techdevcol.uhelper.model;

import com.google.firebase.Timestamp;

import java.io.Serializable;
import java.util.Date;

public class Actividad implements Serializable
{
    public static final String NAME_COLLECTION = "Actividades";
    private String descripcion;
    private Date fecha;

    public Actividad() {

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
