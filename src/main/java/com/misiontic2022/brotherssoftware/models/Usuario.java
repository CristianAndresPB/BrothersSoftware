package com.misiontic2022.brotherssoftware.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    private String nombreUsuario;
    @Column
    private String password;
    @Column
    private String nombrePersona;
    @JsonIgnore
    @OneToOne(mappedBy = "usuario")
    private Empleado empleado;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String password, String nombrePersona, Empleado empleado) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.nombrePersona = nombrePersona;
        this.empleado = empleado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}