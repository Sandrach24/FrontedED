/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.uide.plantilla.service;

import ec.edu.uide.plantilla.model.Equipos;
import ec.edu.uide.plantilla.repository.EquipoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author macbookpro
 */
@Service
@Transactional
public class EquipoService {
    
     @Autowired
    private EquipoDao equipoDao;
     
     public List<Equipos> getEquipos(){
         return equipoDao.findAll();
     }
     
     public Equipos crear(String nombres, String representante, String madrina, String disciplina ) {
        return equipoDao.save(Equipos.builder(). nombres(nombres). representante(representante). disciplina(disciplina). madrina(madrina).build());
     }
    //Guardar un equipo
     public Equipos save(Equipos equipos){
        return equipoDao.save(equipos);
    }
            
    //actualizar una equipo
    public Equipos update(Equipos equipos){
        return equipoDao.save(equipos);
    }
   //eliminar una persona
    public void deleteById(String id) {
        equipoDao.deleteById(id);
        }

   
    public void borrar(String nombres) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }
        
        