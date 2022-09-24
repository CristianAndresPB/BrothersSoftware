package com.misiontic2022.brotherssoftware.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="empresa")
public class Empresa {

    @Id
    private int nitEmpresa;
    @Column
    private String nombre;
    @Column
    private String direccion;
    @Column
    private int numeroEmpresa;
    @JsonIgnore
    @OneToMany(mappedBy = "empresa")
    private List<Empleado> empleado;
    @JsonIgnore
    @OneToMany(mappedBy = "empresa")
    private List<Movimientos> movimientos;
    public Empresa() {
    }

    public Empresa(int nitEmpresa, String nombre, String direccion, int numeroEmpresa, List<Empleado> empleado) {
        this.nitEmpresa = nitEmpresa;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroEmpresa = numeroEmpresa;
        this.empleado = empleado;
    }

    public int getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(int nitEmpresa) {
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

    public List<Empleado> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(List<Empleado> empleado) {
        this.empleado = empleado;
    }
}
