package com.misiontic2022.brotherssoftware.models;

public class Movimientos {
    private Long id;
    private Integer montoMovimiento;
    private Integer montoNegativoyPosivitos;
    private String concepto;

    public Movimientos() {
    }

    public Movimientos(Long id, Integer montoMovimiento, Integer montoNegativoyPosivitos, String concepto) {
        this.id = id;
        this.montoMovimiento = montoMovimiento;
        this.montoNegativoyPosivitos = montoNegativoyPosivitos;
        this.concepto = concepto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMontoMovimiento() {
        return montoMovimiento;
    }

    public void setMontoMovimiento(Integer montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public Integer getMontoNegativoyPosivitos() {
        return montoNegativoyPosivitos;
    }

    public void setMontoNegativoyPosivitos(Integer montoNegativoyPosivitos) {
        this.montoNegativoyPosivitos = montoNegativoyPosivitos;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
}
