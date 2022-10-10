package com.misiontic2022.brotherssoftware.services;

import com.misiontic2022.brotherssoftware.models.Empresa;
import com.misiontic2022.brotherssoftware.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    public List<Empresa> getEnterprises() {
        return enterpriseRepository.findAll();
    }

    public Empresa getEnterprise(String id) throws Exception {
        Optional<Empresa> empresa = enterpriseRepository.findById(id);
        if (empresa.isPresent()){
            return empresa.get();
        } else {
            throw  new Exception("Empresa No Existe");
        }
    }

    public Empresa saveEnterprise(Empresa empresa){
        return enterpriseRepository.save(empresa);
    }

    public Empresa patchUpdateEnterprise(Empresa empresa, String id) throws Exception{
        try {
            Empresa empresaDB = getEnterprise(id);
            if (empresa.getNombre() != null){
                empresaDB.setNombre(empresa.getNombre());
            }
            if (empresa.getNumeroEmpresa() != 0){
                empresaDB.setNumeroEmpresa(empresa.getNumeroEmpresa());
            }
            if (empresa.getDireccion() != null){
                empresaDB.setDireccion(empresa.getDireccion());
            }
            return saveEnterprise(empresaDB);
        } catch (Exception ex) {
            throw new Exception("Empresa no actualizada por que no existe");
        }
    }

    public String deleteEnterprise(String id){
        enterpriseRepository.deleteById(id);
        return "Empresa Eliminada Correctamente";
    }
}
