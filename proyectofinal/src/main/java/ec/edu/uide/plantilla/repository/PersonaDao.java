/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.uide.plantilla.repository;

;
import ec.edu.uide.plantilla.enums.Sexo;
import ec.edu.uide.plantilla.model.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ec.edu.uide.plantilla.model.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 
 */
public interface PersonaDao extends JpaRepository<Persona, String> {

    Persona findByCedula(String cedula);

    Persona findByNombres(String nombres);

    Boolean existsByNombres(String nombres);

    List<Persona> findBySexo(Sexo sexo);
}
