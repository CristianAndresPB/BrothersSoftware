package com.misiontic2022.brotherssoftware.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="empleado")
public class Empleado {
    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String rol;
    @JsonIgnore
    @OneToOne
    private Usuario usuario;
    @JsonIgnore
    @ManyToOne
    private Empresa empresa;
    @JsonIgnore
    @OneToMany(mappedBy = "empleado")
    private List<Movimientos> movimientos;

    public Empleado() {
    }

    public Empleado(int id, String name, String email, String rol, Usuario usuario, Empresa empresa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.rol = rol;
        this.usuario = usuario;
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
