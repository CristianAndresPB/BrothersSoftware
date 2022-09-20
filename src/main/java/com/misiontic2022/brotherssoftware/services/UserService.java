package com.misiontic2022.brotherssoftware.services;

import com.misiontic2022.brotherssoftware.models.ObjectResponse;
import com.misiontic2022.brotherssoftware.models.Usuario;
import com.misiontic2022.brotherssoftware.repository.UserRepository;
import net.bytebuddy.implementation.bytecode.Throw;
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

    public Usuario saveUser(Usuario usuario){
        return userRepository.save(usuario);
    }

    public Usuario putUpdateUser(Usuario usuario){
        return userRepository.save(usuario);
    }

    public Usuario patchUpdateUser(Usuario usuario, String id) throws Exception{
        try {
            Usuario usuarioDB = getUsuario(id);
            if (usuario.getNombrePersona() != null){
                usuarioDB.setNombrePersona(usuario.getNombrePersona());
            }
            if (usuario.getPassword() != null){
                usuarioDB.setPassword(usuario.getPassword());
            }
            return saveUser(usuarioDB);
        } catch (Exception ex) {
            throw new Exception("Usuario no actualizado por que no existe");
        }
    }

    public String deleteUser(String id){
        userRepository.deleteById(id);
        return "Usuario Eliminado Correctamente";
    }
}
