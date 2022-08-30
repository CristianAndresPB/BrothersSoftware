package Entidades;

import javax.persistence.*;
import java.util.List;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private Empresa empresa;
    private String rol;
    private Movimientos[] movimientos;

    @OneToMany(mappedBy = "empleado")

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getRol(){
        return rol;
    }
     public void setRol(String rol){
        this.rol = rol;
     }

    public Movimientos[] getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Movimientos[] movimientos) {
        this.movimientos = movimientos;
    }

    public Empleado(){


    }
}