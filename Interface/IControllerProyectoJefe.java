package Interface;

import Model.entity.Proyecto;
import Model.entity.Tarea;

import java.util.ArrayList;

public interface IControllerProyectoJefe {
    void controladorProyectosJefe(Proyecto proyecto, ArrayList<Tarea> tareas);
}
