package com.misiontic2022.brotherssoftware.controllers.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontEndController {

    @GetMapping("/")
    public String getIndex(){
        return  "index";
    }

    @GetMapping("/facturacion")
    public String getFacturacion(){
        return  "facturacion";
    }

    @GetMapping("/usuarios")
    public String getUsuarios(){
        return  "usuarios";
    }

    @GetMapping("/empresas")
    public String getEmpresas(){
        return  "empresas";
    }
}
