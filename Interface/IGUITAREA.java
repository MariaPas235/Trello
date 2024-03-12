package Interface;

import Model.entity.Colaborador;
import Model.entity.Tarea;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IGUITAREA {
    //Funcion que muestra el menu de opciones que posee el jefe de un proyecto
    int imprimirOpcionesDeTareaJefe();

    //Funcion que imprime las opciones de tarea del colaborador
    int imprimirOpcionesDeTareaColaborador();

    //Funcion de añadir tareas al proyecto
    ArrayList<Tarea> anadirTareas();

    //Metodo estatico para poner una fecha final
    LocalDate anadirFechaFin();

    //Funcion de borrar tarea
    void borrarTarea(ArrayList<Tarea> tareas);

    //Funcion de actualizar los atributos de una tarea
    boolean actualizarTarea(ArrayList<Tarea> tareas);

    //Funcion de asignar una tarea a un colaborador del proyecto
    boolean asignarTarea(ArrayList<Tarea> tareas, Colaborador colaborador);
}
