package Interface;

import Model.entity.Proyecto;
import Model.entity.Tarea;

import java.util.ArrayList;

public interface IControllerProyectoColaborador {
    void controladorProyectosColaborador(Proyecto proyecto, ArrayList<Tarea> tareas);
}
