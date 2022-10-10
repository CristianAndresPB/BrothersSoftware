package com.misiontic2022.brotherssoftware.controllers;

import com.misiontic2022.brotherssoftware.models.Empleado;
import com.misiontic2022.brotherssoftware.models.ObjectResponse;
import com.misiontic2022.brotherssoftware.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/employees")
    public ResponseEntity<List<Empleado>> getUsers() {
        return new ResponseEntity<List<Empleado>>(
                empleadoService.getEmployees(),
                HttpStatus.OK
        );
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Object> getUser(@PathVariable int id) {
        try {
            Empleado empleado = empleadoService.getEmployee(id);
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/employee")
    public ResponseEntity<ObjectResponse> postUser(@RequestBody Empleado empleado) {
        return new ResponseEntity<>(
                new ObjectResponse(empleadoService.saveEmployee(empleado), "Empleado Creado Correctamente"),
                HttpStatus.OK);
    }

    @PatchMapping("/employee/{id}")
    public ResponseEntity<ObjectResponse> patchUpdateUser(@RequestBody Empleado empleado, @PathVariable int id) {
        try {
            return new ResponseEntity<>(
                    new ObjectResponse(empleadoService.patchUpdateEmployee(empleado, id), "Empleado Actualizado Correctamente"),
                    HttpStatus.OK
            );
        } catch (Exception ex){
            return new ResponseEntity<>(
                    new ObjectResponse(null, ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<ObjectResponse> deleteUser(@PathVariable int id){
        return new ResponseEntity<>(
                new ObjectResponse(null, empleadoService.deleteEmployee(id)),
                HttpStatus.OK
        );
    }
}
