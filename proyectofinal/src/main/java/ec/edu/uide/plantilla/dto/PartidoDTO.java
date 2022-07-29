/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.uide.plantilla.dto;

import ec.edu.uide.plantilla.model.Partido;
import ec.edu.uide.plantilla.service.PartidoService;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor

public class PartidoDTO implements Serializable {
    
    @Autowired
    PartidoService partidoService;
    
    private String contrincante1;
    private String contrincante2;
    private Date fecha;
    private String hora ;
    
  
    }

   
