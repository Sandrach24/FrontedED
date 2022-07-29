/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.uide.plantilla.repository;

import ec.edu.uide.plantilla.enums.Sexo;
import ec.edu.uide.plantilla.model.Equipos;
import ec.edu.uide.plantilla.model.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author macbookpro
 */
public interface EquipoDao extends JpaRepository<Equipos, String>{

    Equipos findByRepresentante(String representante);

    Equipos findByNombres(String nombres);

    Boolean existsByNombres(String nombres);

    List<Persona> findBySexo(Sexo sexo);
    
    
}
