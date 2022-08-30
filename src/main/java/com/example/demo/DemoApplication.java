package com.example.demo;

import Entidades.Empleado;
import Entidades.Empresa;
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

	}

}
