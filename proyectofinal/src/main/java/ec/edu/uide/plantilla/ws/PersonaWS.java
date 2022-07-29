/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.uide.plantilla.ws;

import ec.edu.uide.plantilla.dto.PersonaDTO;
import ec.edu.uide.plantilla.model.Equipos;
import ec.edu.uide.plantilla.model.Persona;
import ec.edu.uide.plantilla.service.EquipoService;
import ec.edu.uide.plantilla.service.PersonaService;
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
@RequestMapping("personas")
public class PersonaWS {
    
    @Autowired 
    PersonaService personaService;
    
    @GetMapping(path = "personas")
    public ResponseEntity<List<Persona>> getPersona() {
        return new ResponseEntity<>(personaService.getPersonas(), HttpStatus.OK);
    
    }
    
    @GetMapping(path = "Actualizar")
     public Persona update(Persona persona){
        return personaService.save(persona);
     }
    @PostMapping(path = "agregar",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> agregar(@Valid @RequestBody PersonaDTO personaDTO) {
        Persona persona = personaService.crear(personaDTO.getCedula(), personaDTO.getNombres(),personaDTO.getSexo(),personaDTO.getFechaNacimiento(), personaDTO.getTelefono(),personaDTO.getEmail());
               
        return new ResponseEntity(persona, HttpStatus.OK);
        
    }
    @PostMapping(path = "delete",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> borrar(@Valid @RequestBody PersonaDTO personaDTO) {
        personaService.borrar(personaDTO.getNombres());
        return new ResponseEntity("ok", HttpStatus.OK);
    
    
    
}
}
