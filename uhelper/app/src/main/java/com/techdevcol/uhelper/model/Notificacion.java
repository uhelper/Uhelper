package com.techdevcol.uhelper.model;

import com.google.firebase.Timestamp;

import java.util.Date;

public class Notificacion {

    public static final String NAME_COLLECTION = "Notificaciones";
    private String titulo;
    private String descripcion;
    private Timestamp fecha;

    public Notificacion() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
