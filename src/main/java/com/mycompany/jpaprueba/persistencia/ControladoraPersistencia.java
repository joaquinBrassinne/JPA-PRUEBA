
package com.mycompany.jpaprueba.persistencia;

import com.mycompany.jpaprueba.logica.Alumno;
import com.mycompany.jpaprueba.logica.Carrera;
import com.mycompany.jpaprueba.logica.Materia;
import com.mycompany.jpaprueba.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    AlumnoJpaController aluJpa = new AlumnoJpaController();
    CarreraJpaController carreJpa = new CarreraJpaController();
    MateriaJpaController materiaJpa = new MateriaJpaController();

    public void crearAlumno(Alumno alu) {
        aluJpa.create(alu);
    }

    public void eliminarAlumno(int id) {
        try {
            aluJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    public void editarAlumno(Alumno alu) {
        try {
            aluJpa.edit(alu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Alumno traerAlumno(int id) {
        
        return aluJpa.findAlumno(id);       
    }

    public ArrayList<Alumno> traerListaAlumnos() {
        //Se hace esto porque no se puede hacer un casteo directo!
        List<Alumno> listita = aluJpa.findAlumnoEntities();
        
        ArrayList<Alumno> listaAlumno = new ArrayList<Alumno>(listita);
        return listaAlumno;
    }

    public void crearCarrera(Carrera carr) {
        carreJpa.create(carr);
    }

    public void eliminarCarrera(int id) {
        try {
            carreJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarCarrera(Carrera carr) {
        try {
            carreJpa.edit(carr);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Carrera traerCarrera(int id) {
        return carreJpa.findCarrera(id);
    }

    public ArrayList<Carrera> traerListaCarrera() {
        //Se hace esto porque no se puede hacer un casteo directo!
        List<Carrera> lista = carreJpa.findCarreraEntities();
        ArrayList<Carrera> listaCarrera = new ArrayList<>(lista);
        return listaCarrera;
    }

    public void crearMateria(Materia mate) {
        materiaJpa.create(mate);
    }

    public void eliminarMateria(int id) {
        try {
            materiaJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarMateria(Materia mate) {
        try {
            materiaJpa.edit(mate);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Materia traerMateria(int id) {
        return materiaJpa.findMateria(id);
    }

    public LinkedList<Materia> traerListaMateria() {
        
        //Se hace esto porque no se puede hacer un casteo directo!
        List<Materia> lista = materiaJpa.findMateriaEntities();
        LinkedList<Materia> listaMateria = new LinkedList(lista);
        return listaMateria;
    }
}
