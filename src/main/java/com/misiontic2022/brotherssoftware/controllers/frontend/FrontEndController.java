package com.misiontic2022.brotherssoftware.controllers.frontend;

import com.misiontic2022.brotherssoftware.models.Usuario;
import com.misiontic2022.brotherssoftware.services.EmpleadoService;
import com.misiontic2022.brotherssoftware.services.EnterpriseService;
import com.misiontic2022.brotherssoftware.services.MovimientosService;
import com.misiontic2022.brotherssoftware.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrontEndController {

    @Autowired
    UserService userService;
    @Autowired
    MovimientosService movimientosService;
    @Autowired
    EnterpriseService enterpriseService;
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/registrarse")
    public String getRegistrarse(Model model){
        model.addAttribute("registrarseForm", new Usuario());
        return  "registrarse";
    }

    @PostMapping("/registrarse")
    public String postRegistrarse(@ModelAttribute("registrarseForm") Usuario usuario){
        System.out.println(usuario);
        userService.saveUser(usuario);
        return "redirect:/dashboard";
    }

    @GetMapping("/login")
    public String getLogin(){
        return  "login";
    }

    @GetMapping("/dashboard")
    public String getDashboard(){
        return  "dashboard";
    }

    @GetMapping("/facturacion")
    public String getFacturacion(Model model){
        model.addAttribute("movimientos", movimientosService.getMovements());
        return  "facturacion";
    }

    @GetMapping("/facturacion_form")
    public String getFacturacionForm(){
        return  "facturacion_form";
    }

    @GetMapping("/empresas")
    public String getEmpresas(Model model){
        model.addAttribute("empresas", enterpriseService.getEnterprises());
        return  "empresas";
    }

    @GetMapping("/empresas_form")
    public String getEmpresasForm(){
        return  "empresas_form";
    }

    @GetMapping("/usuarios")
    public String getUsuarios(Model model){
        model.addAttribute("usuarios", userService.getUsers());
        return  "usuarios";
    }

    @GetMapping("/usuarios_form")
    public String getUsuariosForm(){
        return  "usuarios_form";
    }


}
