package com.example.demo;

import Entidades.Empleado;
import Entidades.Empresa;
import Entidades.Movimientos;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		//SpringApplication.run(DemoApplication.class, args);
		// se instancia la clase empleado
		Empresa empresa = new Empresa();
		empresa.setNombre("TecnologyFuture");
		empresa.setDireccion("Calle 80#20-04 Centro");
		empresa.setNumeroEmpresa(315321456);
		empresa.setNitEmpresa(12345);

		Empleado empleado1 = new Empleado();
		empleado1.setName("Cristian Perez");
		empleado1.setEmail("Cristian92@.gmail.com");
		empleado1.setEmpresa(empresa);
		empleado1.setRol("Administrador");

		Movimientos movimiento1 = new Movimientos();
		movimiento1.setMontoMovimiento(258741);
		movimiento1.setMontoNegativoyPosivitos(147852);
		movimiento1.setConcepto("Concepto del movimiento");
		Movimientos movimiento2 = new Movimientos();
		movimiento2.setMontoMovimiento(258741);
		movimiento2.setMontoNegativoyPosivitos(147852);
		movimiento2.setConcepto("Concepto del movimiento");
		Movimientos[] movimientos = new Movimientos[]{movimiento1,movimiento2};
		empleado1.setMovimientos(movimientos);

		System.out.println("El nombre de la empresa 1: " + empleado1.getEmpresa().getNombre());
		System.out.println("El nombre del empleado 1: " + empleado1.getName());

		Empresa empresa2 = new Empresa();
		empresa2.setNombre("SysWorld SAS");
		empresa2.setDireccion("Calle 127 #30-36");
		empresa2.setNumeroEmpresa(321584883);
		empresa2.setNitEmpresa(1234632);

		Empleado empleado2 = new Empleado();
		empleado2.setName("Leidy Perez");
		empleado2.setEmail("leidyprz11@.hotmail.com");
		empleado2.setEmpresa(empresa2);
		empleado2.setRol("Administrador");

		Movimientos movimiento3 = new Movimientos();
		movimiento3.setMontoMovimiento(2345632);
		movimiento3.setMontoNegativoyPosivitos(-12353);
		movimiento3.setConcepto("Concepto del movimiento 3");
		Movimientos movimiento4 = new Movimientos();
		movimiento4.setMontoMovimiento(124672);
		movimiento4.setMontoNegativoyPosivitos(1223452);
		movimiento4.setConcepto("Concepto del movimiento 4");
		Movimientos[] movimientos2 = new Movimientos[]{movimiento3,movimiento4};
		empleado2.setMovimientos(movimientos2);

		System.out.println("El nombre de la empresa 2: " + empleado2.getEmpresa().getNombre());
		System.out.println("El nombre del empleado 2: " + empleado2.getName());
	}

}
