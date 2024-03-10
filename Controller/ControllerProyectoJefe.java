package Controller;

import Interface.IControllerProyectoJefe;
import Model.entity.Colaborador;
import Model.entity.Jefe;
import Model.entity.Proyecto;
import Model.entity.Tarea;
import Model.repo.RepoProyecto;
import view.GUI;

import java.util.ArrayList;

//La clase implementa las funciones de la interfaz IControllerProyectoJefe
public class ControllerProyectoJefe implements IControllerProyectoJefe {
    view.GUI GUI = new GUI();
    Jefe jefe = new Jefe();
    Colaborador colaborador = new Colaborador();
    static RepoProyecto rProyecto = RepoProyecto.get_instance();

    public ControllerProyectoJefe() {
    }
//Funcion que controla los proyectos en los que un usuario es jefe
    /**
     * Funcion que controla los proyectos en los que un usuario es jefe
     * @param proyecto proyecto en el que el usuario es el jefe del proyecto
     * @param tareas del arrayList de tareas que el jefe puede añadir en el proyecto entre otras funciones
     * Primero llama a la funcion de mostrar el proyecto de la GUI.
     * A continuacion muestra el menu del jefe de un proyectio con sus diferentes opciones de
     * qué hacer en el proyecto y que hacer con las tareas (asignar tareas a x colaborador, borrar tareas...)
     */
    public void controladorProyectosJefe(Proyecto proyecto, ArrayList<Tarea> tareas) {
        int opcion = 0;
        do {
            GUI.imprimeProyecto(proyecto);
            opcion = GUI.imprimirOpcionesDeTareaJefe();
            switch (opcion) {
                case 1:
                    ArrayList<Tarea> tareasNuevas = jefe.anadirTarea();
                    if (tareasNuevas != null && !tareasNuevas.isEmpty()) {
                        proyecto.getTareas().addAll(tareasNuevas);
                        System.out.println("Tarea(s) añadida(s) correctamente.");
                    } else {
                        System.out.println("No se pudo añadir la(s) tarea(s).");
                    }
                    break;
                case 2:
                    jefe.borrarTarea(tareas);
                    break;
                case 3:
                    proyecto.añadirColaborador();
                    break;
                case 4:
                    proyecto.eliminarColaborador();
                    break;
                case 5:
                    jefe.asignarTarea(tareas,colaborador);
                    break;
                case 6:
                    jefe.actualizarTarea(tareas);
                    break;
            }
        } while (!(opcion == 7));
    }
}