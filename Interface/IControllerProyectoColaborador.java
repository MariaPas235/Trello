package Interface;

import Model.entity.Proyecto;
import Model.entity.Tarea;
import java.util.ArrayList;

//Funciones que se implementan en la clase controller proyectos del colaborador
public interface IControllerProyectoColaborador {
    //Funcion del controller proyectos del colaborador
    void controladorProyectosColaborador(Proyecto proyecto, ArrayList<Tarea> tareas);
}
