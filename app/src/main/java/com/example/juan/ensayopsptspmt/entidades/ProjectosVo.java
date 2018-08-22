package com.example.juan.ensayopsptspmt.entidades;

public class ProjectosVo {

    private String nombre;
    private int id;
    private int tiempo;

    public ProjectosVo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}
