package com.techdevcol.uhelper.model;

public class Docente {
    private static final String NAME_COLLECTION = "Docentes";
    private String nombres;
    private String apellidos;

    public Docente()
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
