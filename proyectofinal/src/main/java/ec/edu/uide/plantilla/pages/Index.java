/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.uide.plantilla.pages;

import ec.edu.uide.plantilla.service.EquipoService;
import ec.edu.uide.plantilla.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {
    
    @Autowired
    private EquipoService equipoService;
    
    @GetMapping (value = {"/","index.html"})
    public String inicio(Model model){
        model.addAttribute("Titulo","Venta de producto");
        model.addAttribute("pagina", "SandraChamba");
        model.addAttribute("imagen","https://www.mundoprimaria.com/lecturas-para-ninos-primaria/deporte");
        model.addAttribute("equipos", equipoService.getEquipos());
        return "index";
        
    }
    
  
    
    
}
