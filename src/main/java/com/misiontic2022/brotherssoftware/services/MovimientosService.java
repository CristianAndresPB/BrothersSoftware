package com.misiontic2022.brotherssoftware.services;

import com.misiontic2022.brotherssoftware.models.Movimientos;
import com.misiontic2022.brotherssoftware.repository.MovimientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientosService {

    @Autowired
    private MovimientosRepository movimientosRepository;

    public List<Movimientos> getMovements() {
        return movimientosRepository.findAll();
    }

    public List<Movimientos> getMovementsByEnterprise(int idEnterprise) {
        return movimientosRepository.findAllByEmpresaNitEmpresa(idEnterprise);
    }

    public Movimientos getMovement(int id) throws Exception {
        Optional<Movimientos> movimientosOptional = movimientosRepository.findById(id);
        if (movimientosOptional.isPresent()){
            return movimientosOptional.get();
        } else {
            throw  new Exception("Movimiento No Existe");
        }
    }

    public Movimientos saveMovement(Movimientos movimientos){
        return movimientosRepository.save(movimientos);
    }

    public Movimientos patchUpdateMovement(Movimientos movimientos, int id) throws Exception{
        try {
            Movimientos movimientosDB = getMovement(id);
            if (movimientos.getConcepto() != null){
                movimientosDB.setConcepto(movimientos.getConcepto());
            }
            movimientosDB.setMontoMovimiento(movimientos.getMontoMovimiento());
            return saveMovement(movimientosDB);
        } catch (Exception ex) {
            throw new Exception("Movimiento no actualizado por que no existe");
        }
    }

    public String deleteMovement(int id){
        movimientosRepository.deleteById(id);
        return "Movimiento Eliminado Correctamente";
    }
}
