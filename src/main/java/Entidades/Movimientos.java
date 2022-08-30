package Entidades;

import javax.persistence.*;

@Entity
public class Movimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer montoMovimiento;
    private Integer montoNegativoyPosivitos;
    private String concepto;

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

    public Empleado getEmpleado1() {
        return empleado1;
    }

    public void setEmpleado1(Empleado empleado1) {
        this.empleado1 = empleado1;
    }

    @ManyToOne
    @JoinColumn(name = "empleado1")
    private Empleado empleado1;

    public Movimientos(){

    }
}