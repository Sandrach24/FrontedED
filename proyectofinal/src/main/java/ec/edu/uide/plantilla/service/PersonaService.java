/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.uide.plantilla.service;


import ec.edu.uide.plantilla.enums.Sexo;
import ec.edu.uide.plantilla.model.Persona;
import ec.edu.uide.plantilla.repository.PersonaDao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 
 */
@Service
@Transactional
public class PersonaService {

    @Autowired
    private PersonaDao personaDao;

    public Persona buscarPersona(String cedula) {
        return personaDao.findByCedula(cedula);
    }

    public boolean verficaSiExiste(String cedula) {
        return personaDao.existsById(cedula);
    }

    public boolean verficaSiExistenNombres(String nombres) {
        return personaDao.existsByNombres(nombres);
    }

    public Persona crear(String cedula, String nombres, Sexo sexo,
            Date fechaNacimiento, String telefono, String email) {
        return personaDao.save(Persona.builder().cedula(cedula)
                .nombres(nombres).sexo(sexo).fechaNacimiento(fechaNacimiento)
                .telefono(telefono).email(email).build());
    }

    public Persona crear(String cedula, String nombres, Sexo sexo,
            Date fechaNacimiento, String telefono, String email, String foto) {
        return personaDao.save(Persona.builder().cedula(cedula)
                .nombres(nombres).sexo(sexo).fechaNacimiento(fechaNacimiento)
                .telefono(telefono).email(email).urlFoto(foto).build());
    }

    public void borrar(Persona persona) {
        personaDao.delete(persona);
    }
    
    public void borrar(String cedula){
        Persona personaABorrar = buscarPersona(cedula);
        borrar(personaABorrar);
    }

    public List<Persona> getPersonas() {
        return personaDao.findAll();
    }
    
    public Persona save(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
