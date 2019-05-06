package com.techdevcol.uhelper.model;

public class Estudiante {
    private static final String NAME_COLLECTION = "Estudiantes";
    private String nombres;
    private String apellidos;

    public Estudiante()
    {

    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
