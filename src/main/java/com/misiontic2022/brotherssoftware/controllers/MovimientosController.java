package com.misiontic2022.brotherssoftware.controllers;

import com.misiontic2022.brotherssoftware.models.Movimientos;
import com.misiontic2022.brotherssoftware.models.ObjectResponse;
import com.misiontic2022.brotherssoftware.services.MovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovimientosController {

    @Autowired
    private MovimientosService movimientosService;

    @GetMapping("/enterprises/movements")
    public ResponseEntity<List<Movimientos>> getMovements() {
        return new ResponseEntity<List<Movimientos>>(
                movimientosService.getMovements(),
                HttpStatus.OK
        );
    }

    @GetMapping("/enterprises/{idEnterprise}/movements")
    public ResponseEntity<List<Movimientos>> getMovementsByEnterprise(@PathVariable int idEnterprise) {
        return new ResponseEntity<List<Movimientos>>(
                movimientosService.getMovementsByEnterprise(idEnterprise),
                HttpStatus.OK
        );
    }

    @GetMapping("/enterprises/{idEnterprise}/movement/{idMovement}")
    public ResponseEntity<Object> getMovement(@PathVariable int idEnterprise, int idMovement) {
        try {
            Movimientos movimientos = movimientosService.getMovement(idMovement);
            return new ResponseEntity<>(movimientos, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/enterprises/movements")
    public ResponseEntity<ObjectResponse> postMovement(@RequestBody Movimientos movimientos) {
        return new ResponseEntity<>(
                new ObjectResponse(movimientosService.saveMovement(movimientos), "Movimiento Creado Correctamente"),
                HttpStatus.OK);
    }

    @PatchMapping("/enterprises/{idEnterprise}/movement/{idMovement}")
    public ResponseEntity<ObjectResponse> patchUpdateMovement(@RequestBody Movimientos movimientos, @PathVariable int idEnterprise, @PathVariable int idMovement) {
        try {
            return new ResponseEntity<>(
                    new ObjectResponse(movimientosService.patchUpdateMovement(movimientos, idMovement), "Movimiento Actualizado Correctamente"),
                    HttpStatus.OK
            );
        } catch (Exception ex){
            return new ResponseEntity<>(
                    new ObjectResponse(null, ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @DeleteMapping("/enterprises/{idEnterprise}/movement/{idMovement}")
    public ResponseEntity<ObjectResponse> deleteMovement(@PathVariable int idEnterprise, @PathVariable int idMovement){
        return new ResponseEntity<>(
                new ObjectResponse(null, movimientosService.deleteMovement(idMovement)),
                HttpStatus.OK
        );
    }
}
