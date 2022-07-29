/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.uide.plantilla.repository;

import ec.edu.uide.plantilla.enums.Sexo;
import ec.edu.uide.plantilla.model.Equipos;
import ec.edu.uide.plantilla.model.Partido;
import ec.edu.uide.plantilla.model.Persona;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author macbookpro
 */
public interface PartidoDao extends JpaRepository<Partido, String>{

    Partido findBycontrincante1 (String Contricante1);
    Partido findBycontrincante2 (String Contricante2);
    Partido findByfecha (Date Fecha);
    Partido findByhora (Time Hora);
    
    
    

    
}

