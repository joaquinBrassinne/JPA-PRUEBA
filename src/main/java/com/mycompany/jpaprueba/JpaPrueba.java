package com.mycompany.jpaprueba;

import com.mycompany.jpaprueba.logica.Alumno;
import com.mycompany.jpaprueba.logica.Carrera;
import com.mycompany.jpaprueba.logica.Controladora;
import com.mycompany.jpaprueba.logica.Materia;
import com.mycompany.jpaprueba.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class JpaPrueba {

    public static void main(String[] args) {
        
        Controladora controladora = new Controladora();
        
        //Creamos lista de materia 
        LinkedList<Materia> listaMateria = new LinkedList<Materia>();
        
        //CREACION CARRERA
        Carrera carrera = new Carrera(1,"Desarrollo de Software", listaMateria);
        
        //GUARDADO CARRERA EN BD
        controladora.crearCarrera(carrera);

       
        //Creacion Materias
        Materia mate1 = new Materia(1, "Programacion 1", "Cuatrimestral",carrera);
        Materia mate2 = new Materia(2, "Matematica", "Cuatrimestral", carrera);
        Materia mate3 = new Materia(3, "Laboratorio", "Anual", carrera);

        //Guardado materias en BD
        controladora.crearMateria(mate1);
        controladora.crearMateria(mate2);
        controladora.crearMateria(mate3);
        
        
        //Agregar las materias.
        listaMateria.add(mate1);
        listaMateria.add(mate2);
        listaMateria.add(mate3);

        carrera.setListaMaterias(listaMateria);
        controladora.editarCarrera(carrera);
       
        
        
        
        //CREACION ALUMNO CON CARRERA
        Alumno alu2 = new Alumno(4, "Joaquin", "Brassinne", new Date(), carrera);
        
        //GUARDAMOS ALUMNO EN BD
        controladora.crearAlumno(alu2);
        System.out.println("--------------------");
        System.out.println("Datos Alumno");
        System.out.println("------------------");
        System.out.println("Alumno: "+ alu2.getNombre() + " " + alu2.getApellido());
        System.out.println("Curso la carrera de: " + alu2.getCarre().getNombre());

        

    }
}
