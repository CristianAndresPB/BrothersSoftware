package com.misiontic2022.brotherssoftware.controllers;

import com.misiontic2022.brotherssoftware.models.Usuario;
import com.misiontic2022.brotherssoftware.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<Usuario>> getUsers() {
        return new ResponseEntity<List<Usuario>>(
                userService.getUsuarios(),
                HttpStatus.OK
        );
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getUser(@PathVariable String  id) {
        try {
            Usuario usuario = userService.getUsuario(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<Object> getUsers(@RequestParam String id) {
        try {
            Usuario usuario = userService.getUsuario(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
