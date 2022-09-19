package com.misiontic2022.brotherssoftware.services;

import com.misiontic2022.brotherssoftware.models.Usuario;
import com.misiontic2022.brotherssoftware.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Usuario> getUsuarios() {
        return userRepository.findAll();
    }

    public Usuario getUsuario(String id) throws Exception {
        Optional<Usuario> usuarioOptional = userRepository.findById(id);
        if (usuarioOptional.isPresent()){
            return usuarioOptional.get();
        } else {
            throw  new Exception("Usuario No Existe");
        }
    }
}
