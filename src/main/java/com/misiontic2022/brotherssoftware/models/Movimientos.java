package com.misiontic2022.brotherssoftware.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="movimientos")
public class Movimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private double montoMovimiento;
    @Column
    private String concepto;
    @ManyToOne
    private Empresa empresa;
    @ManyToOne
    private Empleado empleado;

    public Movimientos() {
    }

    public Movimientos(int id, double montoMovimiento, String concepto, Empresa empresa, Empleado empleado) {
        this.id = id;
        this.montoMovimiento = montoMovimiento;
        this.concepto = concepto;
        this.empresa = empresa;
        this.empleado = empleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMontoMovimiento() {
        return montoMovimiento;
    }

    public void setMontoMovimiento(double montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
