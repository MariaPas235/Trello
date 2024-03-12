package Interface;

import Model.entity.Proyecto;
import Model.entity.Tarea;

import java.util.ArrayList;

//Funciones que se implementan en la clase controller proyecto jefe
public interface IControllerProyectoJefe {
    //Funcion del controller de los proyectos del jefe
    void controladorProyectosJefe(Proyecto proyecto, ArrayList<Tarea> tareas);
}
