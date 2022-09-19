package com.misiontic2022.brotherssoftware.models;

public class Empresa {
    private String nombre;
    private String direccion;
    private int numeroEmpresa;
    private int nitEmpresa;

    public Empresa() {
    }

    public Empresa(String nombre, String direccion, int numeroEmpresa, int nitEmpresa) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroEmpresa = numeroEmpresa;
        this.nitEmpresa = nitEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumeroEmpresa() {
        return numeroEmpresa;
    }

    public void setNumeroEmpresa(int numeroEmpresa) {
        this.numeroEmpresa = numeroEmpresa;
    }

    public int getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(int nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }
}
