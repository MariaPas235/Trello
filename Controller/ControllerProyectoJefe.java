package Controller;

import Interface.IControllerProyectoJefe;
import Model.entity.Colaborador;
import Model.entity.Proyecto;
import Model.entity.Tarea;
import Model.repo.RepoProyecto;
import view.GUI;
import view.GUIPROYECTO;
import view.GUITAREA;

import java.util.ArrayList;

//La clase implementa las funciones de la interfaz IControllerProyectoJefe
public class ControllerProyectoJefe implements IControllerProyectoJefe {
    view.GUI GUI = new GUI();
    view.GUIPROYECTO GUIPROYECTO = new GUIPROYECTO();
    view.GUITAREA GUITAREA = new GUITAREA();
    Colaborador colaborador = new Colaborador();
    RepoProyecto rProyecto = RepoProyecto.get_instance();

    public ControllerProyectoJefe() {
    }

    //Funcion que controla los proyectos en los que un usuario es jefe

    /**
     * Funcion que controla los proyectos en los que un usuario es jefe
     *
     * @param proyecto proyecto en el que el usuario es el jefe del proyecto
     * @param tareas   del arrayList de tareas que el jefe puede añadir en el proyecto entre otras funciones
     *                 Primero llama a la funcion de mostrar el proyecto de la GUI.
     *                 A continuacion muestra el menu del jefe de un proyectio con sus diferentes opciones de
     *                 qué hacer en el proyecto y que hacer con las tareas (asignar tareas a x colaborador, borrar tareas...)
     */
    public void controladorProyectosJefe(Proyecto proyecto, ArrayList<Tarea> tareas) {
        int opcion;
        do {
            GUI.imprimirCabecera();
            GUI.espacioTrabajo(proyecto);
            opcion = GUITAREA.imprimirOpcionesDeTareaJefe();
            switch (opcion) {
                case 1:
                    ArrayList<Tarea> tareasNuevas = GUITAREA.anadirTareas();
                    if (tareasNuevas != null && !tareasNuevas.isEmpty()) {
                        proyecto.getTareas().addAll(tareasNuevas);
                        rProyecto.save();
                        GUI.imprimir("Tarea(s) añadida(s) correctamente.");

                    } else {
                        GUI.imprimir("No se pudo añadir la(s) tarea(s).");

                    }
                    break;
                case 2:
                    GUITAREA.borrarTarea(tareas);
                    rProyecto.save();
                    break;
                case 3:
                    GUIPROYECTO.anadirColaborador();
                    rProyecto.save();
                    break;
                case 4:
                    GUIPROYECTO.eliminarColaborador(proyecto.getColaboradores());
                    rProyecto.save();
                    break;
                case 5:
                    GUITAREA.asignarTarea(tareas, colaborador);
                    rProyecto.save();
                    break;
                case 6:
                    GUITAREA.actualizarTarea(tareas);
                    rProyecto.save();
                    break;
            }
        } while (!(opcion == 7));
    }
}