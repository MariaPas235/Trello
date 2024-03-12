package Interface;

import Model.entity.Colaborador;
import Model.entity.Tarea;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IGUITAREA {
    int imprimirOpcionesDeTareaJefe();

    int imprimirOpcionesDeTareaColaborador();

    ArrayList<Tarea> anadirTareas();

    //Metodo estatico para poner una fecha final
    LocalDate anadirFechaFin();

    void borrarTarea(ArrayList<Tarea> tareas);


    boolean actualizarTarea(ArrayList<Tarea> tareas);

    boolean asignarTarea(ArrayList<Tarea> tareas, Colaborador colaborador);
}
