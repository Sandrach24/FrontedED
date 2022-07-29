/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;

import ec.edu.uide.plantilla.Plantilla;
import ec.edu.uide.plantilla.dto.EquipoDTO;
import ec.edu.uide.plantilla.dto.PartidoDTO;
import ec.edu.uide.plantilla.dto.PersonaDTO;
import ec.edu.uide.plantilla.enums.Sexo;
import ec.edu.uide.plantilla.ws.EquipoWS;
import ec.edu.uide.plantilla.ws.PartidoWS;
import ec.edu.uide.plantilla.ws.PersonaWS;
import java.time.LocalDateTime;
import java.util.Calendar;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@SpringBootTest
@ContextConfiguration(classes = Plantilla.class)
public class Tests {

  
    
    @Autowired
    private PersonaWS personaws;
    
    @Autowired
    private EquipoWS equipoWS;
    
    @Autowired
    private PartidoWS partidoWS;

    @Test
    public void testing() throws Exception {
        Calendar fecha = Calendar.getInstance();
        fecha.set(1981, 1, 1);
        
        
       
        personaws.agregar(PersonaDTO.builder().cedula("1150231668").nombres("sandra").sexo(Sexo.OTRO).fechaNacimiento(fecha.getTime()).telefono("0982356173").email("jhulia@gmail.com").build());
        equipoWS.agregar(EquipoDTO.builder().nombres("Apolos").representante("Nelson").madrina("Sandra").disciplina("futbool").build());
        equipoWS.agregar(EquipoDTO.builder().nombres("Poseid").representante("Nelson").madrina("Sandra").disciplina("futbool").build());
        equipoWS.agregar(EquipoDTO.builder().nombres("Ares").representante("Nelson").madrina("Sandra").disciplina("futbool").build());
        partidoWS.agregar(PartidoDTO.builder().contrincante1("Apolos").contrincante2("Poseidon").fecha(fecha.getTime()).hora("2020-12-17").build());
    }

}
