/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.uide.plantilla.service;

import ec.edu.uide.plantilla.model.Equipos;
import ec.edu.uide.plantilla.model.Partido;
import ec.edu.uide.plantilla.repository.PartidoDao;
import java.sql.Time;
import java.util.Date;
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
public class PartidoService {
    
    @Autowired
    private PartidoDao partidoDao;
    
    public Partido crear(String contrincante1, String contrincante2, Date fecha, String hora) {
        return partidoDao.save(Partido.builder().contrincante1(contrincante1). contrincante2(contrincante2).fecha(fecha).hora(hora).build());
     }
    
    //Guardar un equipo
     public Partido save(Partido partidos){
        return partidoDao.save(partidos);
    }
            
    //actualizar una equipo
    public Partido update(Partido partidos){
        return partidoDao.save(partidos);
    }
   //eliminar una persona
    public void deleteById(String id) {
        partidoDao.deleteById(id);
    
}

   public List<Partido> getPartidos() {
        return partidoDao.findAll();
    }

    public void borrar(String contrincante1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }