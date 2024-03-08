package Interface;

import Model.entity.Proyecto;
import Model.entity.Tarea;
import java.util.ArrayList;

//Funciones se implementan en la clase colaborador
public interface IColaborador {
    //Funcion de añadir comentarios en una tarea
    String anadirComentario(Tarea tarea, Proyecto proyecto, String comentario);

    //Funcion que asigna una tarea a un colaborador si no estaba asiganada previamente
    void asignarTarea(Tarea tarea);

    //Funcion que permite actualizar el estado de una tarea
    void actualizarTarea(ArrayList<Tarea> tareas);

    //Funcion para ver los comentarios añadidos a una tarea
    void verComentario(Proyecto proyecto);
}
