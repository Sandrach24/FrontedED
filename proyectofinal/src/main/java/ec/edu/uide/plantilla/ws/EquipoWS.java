/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.uide.plantilla.ws;

import ec.edu.uide.plantilla.dto.EquipoDTO;
import ec.edu.uide.plantilla.model.Equipos;
import ec.edu.uide.plantilla.service.EquipoService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("equipos")
public class EquipoWS {
    
    @Autowired
    EquipoService equiposService;
    
    @GetMapping(path = "equipos")
    public ResponseEntity<List<Equipos>> getEquipos() {
        return new ResponseEntity<>(equiposService.getEquipos(), HttpStatus.OK);
    }   
    @GetMapping(path = "Actualizar")
     public Equipos update(Equipos equipos){
        return equiposService.save(equipos);
    }
    
    @PostMapping(path = "agregar",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Equipos> agregar(@Valid @RequestBody EquipoDTO equipoDTO) {
        Equipos equipos = equiposService.crear(equipoDTO.getNombres(),equipoDTO.getRepresentante(),equipoDTO.getMadrina() , equipoDTO.getDisciplina());
               
        return new ResponseEntity(equipos, HttpStatus.OK);
    
}
       @PostMapping(path = "delete",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> borrar(@Valid @RequestBody EquipoDTO equipoDTO) {
        equiposService.borrar(equipoDTO.getNombres());
        return new ResponseEntity("ok", HttpStatus.OK);
    }
    
}