/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.uide.plantilla.ws;

import ec.edu.uide.plantilla.dto.EquipoDTO;
import ec.edu.uide.plantilla.dto.PartidoDTO;
import ec.edu.uide.plantilla.model.Partido;
import ec.edu.uide.plantilla.service.PartidoService;
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
@RequestMapping("partidos")
public class PartidoWS {
    
    @Autowired
    PartidoService partidoService;
    
    /**
     *
     * @return
     */
    @GetMapping(path = "partidos")
    public ResponseEntity<List<Partido>> getPartido() {
        return new ResponseEntity<>(partidoService.getPartidos(), HttpStatus.OK);

    }
    
    @GetMapping(path = "Actualizar")
     public Partido update(Partido partido){
        return partidoService.save(partido);
     }
        @PostMapping(path = "agregar",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Partido> agregar(@Valid @RequestBody PartidoDTO partidoDTO) {
        Partido partido = partidoService.crear(partidoDTO.getContrincante1(),partidoDTO.getContrincante2(),partidoDTO.getFecha(),partidoDTO.getHora());
               
        return new ResponseEntity(partido, HttpStatus.OK);
    
}
    @PostMapping(path = "delete",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> borrar(@Valid @RequestBody PartidoDTO partidoDTO) {
        partidoService.borrar(partidoDTO.getContrincante1());
        return new ResponseEntity("ok", HttpStatus.OK);
}
}
