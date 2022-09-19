package com.misiontic2022.brotherssoftware.repository;

import com.misiontic2022.brotherssoftware.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, String> {
}
