package Interface;


import Model.entity.Colaborador;
import Model.entity.Tarea;
import java.util.ArrayList;

//Metodos que se implementan en la clase jefe

public interface IJefe {
    //Funcion para añadir una tarea a un proyecto
    ArrayList<Tarea> anadirTarea();

    //Funcion para asignar tareas a los colaboradores
    void asignarTarea(ArrayList<Tarea> tareas, Colaborador colaborador);

    //Funcion para borrar una tarea del proyecto
    void borrarTarea(ArrayList<Tarea> tareas);

    //Funcion para actualizar una tarea (nombre,descripcion...)
    void actualizarTarea(ArrayList<Tarea> tareas);
}
