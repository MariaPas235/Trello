package Model.entity;

import Interface.IJefe;
import java.util.ArrayList;


public class Jefe extends Persona implements IJefe {
    public Jefe() {
        super("", "", "", "");
    }

    //Funciones que tiene el jefe de un proyecto
    //Funcion para añadir colaboradores en un proyecto

    @Override
    public String anadirColaboradores(ArrayList<Persona> colaboradores, String colaborador, ArrayList<Persona> persona) {
        persona.getColaboradores();
        for(Persona persona : colaboradores){
            for (Proyecto proyecto1: persona){
                if(proyecto1.equals(persona)){

                }
            }
            if (persona.getUsuario().equals(colaborador)){
                colaboradores.add(persona);
            }
        }
        do{

        }while ((colaborador == persona.getJefe()));
        return null;
    }

    //Funcion para eliminar colaboradores de un proyecto
    @Override
    public void eliminarColaboradores() {

    }

    //Funcion para añadir tareas a un proyecto
    @Override
    public void anadirTarea() {

    }

    //Funcion para asignar tareas a los colaboradores
    @Override
    public void asignartarea() {

    }

    //Funcion para borrar una tarea
    @Override
    public void borrarTarea() {

    }

    //Funcion para actualizar una tarea
    @Override
    public void actualizarTarea() {

    }
}
