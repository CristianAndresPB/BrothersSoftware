package com.misiontic2022.brotherssoftware.services;

import com.misiontic2022.brotherssoftware.models.Empleado;
import com.misiontic2022.brotherssoftware.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getEmployees() {
        return empleadoRepository.findAll();
    }

    public Empleado getEmployee(int id) throws Exception {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        if (empleadoOptional.isPresent()){
            return empleadoOptional.get();
        } else {
            throw  new Exception("Empleado No Existe");
        }
    }

    public Empleado saveEmployee(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    public Empleado putUpdateEmployee(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    public Empleado patchUpdateEmployee(Empleado empleado, int id) throws Exception{
        try {
            Empleado empleadoDB = getEmployee(id);
            if (empleado.getName() != null){
                empleadoDB.setName(empleado.getName());
            }
            if (empleado.getEmail() != null){
                empleadoDB.setEmail(empleado.getEmail());
            }
            if (empleado.getRol() != null){
                empleadoDB.setRol(empleado.getRol());
            }
            return saveEmployee(empleadoDB);
        } catch (Exception ex) {
            throw new Exception("Empleado no actualizado por que no existe");
        }
    }

    public String deleteEmployee(int id){
        empleadoRepository.deleteById(id);
        return "Empleado Eliminado Correctamente";
    }
}
