package com.misiontic2022.brotherssoftware.controllers;

import com.misiontic2022.brotherssoftware.models.Empresa;
import com.misiontic2022.brotherssoftware.models.ObjectResponse;
import com.misiontic2022.brotherssoftware.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping("/enterprises")
    public ResponseEntity<List<Empresa>> getEnterprises() {
        return new ResponseEntity<List<Empresa>>(
                enterpriseService.getEnterprises(),
                HttpStatus.OK
        );
    }

    @GetMapping("/enterprises/{id}")
    public ResponseEntity<Object> getEnterprise(@PathVariable String id) {
        try {
            Empresa empresa = enterpriseService.getEnterprise(id);
            return new ResponseEntity<>(empresa, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/enterprise")
    public ResponseEntity<Object> getEnterprises(@RequestParam String id) {
        try {
            Empresa empresa = enterpriseService.getEnterprise(id);
            return new ResponseEntity<>(empresa, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/enterprises")
    public ResponseEntity<ObjectResponse> postEnterprise(@RequestBody Empresa empresa) {
        return new ResponseEntity<>(
                new ObjectResponse(enterpriseService.saveEnterprise(empresa), "Empresa Creada Correctamente"),
                HttpStatus.OK);
    }

    @PutMapping("/enterprises")
    public ObjectResponse putUpdateEnterprise(@RequestBody Empresa empresa) {
        return new ObjectResponse(enterpriseService.putUpdateEnterprise(empresa), "Empresa Actualizada Correctamente");
    }

    @PatchMapping("/enterprises/{id}")
    public ResponseEntity<ObjectResponse> patchUpdateEnterprise(@RequestBody Empresa empresa, @PathVariable String id) {
        try {
            return new ResponseEntity<>(
                    new ObjectResponse(enterpriseService.patchUpdateEnterprise(empresa, id), "Empresa Actualizada Correctamente"),
                    HttpStatus.OK
            );
        } catch (Exception ex) {
            return new ResponseEntity<>(
                    new ObjectResponse(null, ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @DeleteMapping("/enterprises/{id}")
    public ResponseEntity<ObjectResponse> deleteEnterprise(@PathVariable String id) {
        return new ResponseEntity<>(
                new ObjectResponse(null, enterpriseService.deleteEnterprise(id)),
                HttpStatus.OK
        );
    }
}
