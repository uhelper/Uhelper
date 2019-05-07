package com.techdevcol.uhelper.model;

import java.io.Serializable;

public class Calificaciones implements Serializable {
    private int nota;
    private double porcentaje;
    private String userId;

    public Calificaciones() {
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
