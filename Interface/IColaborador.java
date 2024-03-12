package Interface;

import Model.entity.Proyecto;
import Model.entity.Tarea;
import java.util.ArrayList;

//Funciones se implementan en la clase colaborador
public interface IColaborador {

    //Funcion para ver los comentarios añadidos a una tarea
    void verComentario(Proyecto proyecto);
}
