package com.techdevcol.uhelper.model;

import com.google.firebase.firestore.Exclude;

public class Estudiante {
    public static final String NAME_COLLECTION = "Estudiantes";
    private String nombres;
    private String apellidos;
    private String celular;
    private String carrera;
    private int semestre;
    private String email;
    @Exclude
    public String password;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", celular='" + celular + '\'' +
                ", carrera='" + carrera + '\'' +
                ", semestre=" + semestre +
                ", email='" + email + '\'' +
                '}';
    }

    @Exclude
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
