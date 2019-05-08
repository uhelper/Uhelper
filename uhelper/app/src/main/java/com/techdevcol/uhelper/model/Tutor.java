package com.techdevcol.uhelper.model;

import java.io.Serializable;

public class Tutor implements Serializable {
    public static final String NAME_COLLECTION="Tutores";
    private Asignatura asignatura;
    private Estudiante estudiante;
    public Tutor(){

    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
