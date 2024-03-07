package Interface;

import Model.entity.EstadoTarea;
import Model.entity.Proyecto;
import Model.entity.Tarea;

public interface IColaborador {
    //Metodos que se implementaran en la clase colaborador
    EstadoTarea actualizarEstadoTarea(String cambiarEstado, Tarea tarea);
    String anadirComentario(Tarea tarea, Proyecto proyecto, String comentario);
    //void editarComentario();
}
