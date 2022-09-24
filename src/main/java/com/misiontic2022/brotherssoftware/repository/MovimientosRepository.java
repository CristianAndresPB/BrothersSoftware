package com.misiontic2022.brotherssoftware.repository;

import com.misiontic2022.brotherssoftware.models.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientosRepository extends JpaRepository<Movimientos, Integer> {

    public List<Movimientos> findAllByEmpresaNitEmpresa(int idEnterprise);
}
