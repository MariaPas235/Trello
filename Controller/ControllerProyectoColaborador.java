package Controller;


import Interface.IControllerProyectoColaborador;
import Model.entity.Colaborador;
import Model.entity.Proyecto;
import Model.entity.Tarea;
import view.GUI;
import view.GUITAREA;

import java.util.ArrayList;

//La clase implementa los metodos de la interfaz de IControllerPoyectoColaborador
public class ControllerProyectoColaborador implements IControllerProyectoColaborador {
    view.GUI GUI = new GUI();
    view.GUITAREA GUITAREA = new GUITAREA();
    Colaborador colaborador= new Colaborador();

    public ControllerProyectoColaborador() {
    }

    //Funcion que controla los proyectos de un colaborador
    /**
     *Funcion que controla los proyectos de un colaborador
     * @param proyecto en donde el usuario esta añadido y es colaborador
     * @param tareas del arrayList de tareas que tiene un colaborador
     * Llama a las funciones de GUI que muestra el menu de las opciones que tiene un colaborador
     * en un proyecto
     */
    public  void controladorProyectosColaborador(Proyecto proyecto, ArrayList<Tarea> tareas){
        int opcion;
        do{
            GUI.imprimirCabecera();
            GUI.espacioTrabajo(proyecto);
            opcion=GUITAREA.imprimirOpcionesDeTareaColaborador();
            switch (opcion){
                case 1:
                    GUITAREA.actualizarTarea(tareas);
                    break;
                case 2:
                    colaborador.verComentario(proyecto);
                    break;
            }
        }while(!(opcion ==3));
    }
}
