package Interface;

import Model.entity.EstadoTarea;
import Model.entity.Proyecto;
import Model.entity.Tarea;

import java.util.ArrayList;

public interface IColaborador {
    //Metodos que se implementaran en la clase colaborador

    //Funcion de actualizar el estado de una tarea
    void actualizarTarea(ArrayList<Tarea> tareas);

    String anadirComentario(Tarea tarea, Proyecto proyecto, String comentario);
    //void editarComentario();
}
