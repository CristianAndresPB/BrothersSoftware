package com.misiontic2022.brotherssoftware.controllers;

import com.misiontic2022.brotherssoftware.models.ObjectResponse;
import com.misiontic2022.brotherssoftware.models.Usuario;
import com.misiontic2022.brotherssoftware.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<Usuario>> getUsers() {
        return new ResponseEntity<List<Usuario>>(
                userService.getUsers(),
                HttpStatus.OK
        );
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getUser(@PathVariable String id) {
        try {
            Usuario usuario = userService.getUser(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<ObjectResponse> postUser(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(
                new ObjectResponse(userService.saveUser(usuario), "Usuario Creado Correctamente"),
                HttpStatus.OK);
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<ObjectResponse> patchUpdateUser(@RequestBody Usuario usuario, @PathVariable String id) {
        try {
            return new ResponseEntity<>(
                    new ObjectResponse(userService.patchUpdateUser(usuario, id), "Usuario Actualizado Correctamente"),
                    HttpStatus.OK
            );
        } catch (Exception ex){
            return new ResponseEntity<>(
                    new ObjectResponse(null, ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<ObjectResponse> deleteUser(@PathVariable String id){
        return new ResponseEntity<>(
                new ObjectResponse(null, userService.deleteUser(id)),
                HttpStatus.OK
        );
    }
}
