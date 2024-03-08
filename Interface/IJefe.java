package Interface;


import Model.entity.Colaborador;
import Model.entity.Tarea;

import java.util.ArrayList;

public interface IJefe {
    //Metodos que se implementaran en la clase jefe
    ArrayList<Tarea> anadirTarea();
    void asignarTarea(ArrayList<Tarea> tareas, Colaborador colaborador);

    void borrarTarea(ArrayList<Tarea> tareas);

    void actualizarTarea(ArrayList<Tarea> tareas);
}
