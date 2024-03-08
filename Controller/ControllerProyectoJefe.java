package Controller;

import IO.Teclado;
import Interface.IControllerProyectoJefe;
import Model.entity.Colaborador;
import Model.entity.Jefe;
import Model.entity.Proyecto;
import Model.entity.Tarea;
import Model.repo.RepoProyecto;
import view.GUI;

import java.util.ArrayList;

public class ControllerProyectoJefe implements IControllerProyectoJefe {
    view.GUI GUI = new GUI();
    Jefe jefe = new Jefe();
    Colaborador colaborador = new Colaborador();
    static RepoProyecto rProyecto = RepoProyecto.get_instance();

    public ControllerProyectoJefe() {
    }

    public void controladorProyectosJefe(Proyecto proyecto, ArrayList<Tarea> tareas) {
        int opcion = 0;
        do {
            GUI.imprimeProyecto(proyecto);
            GUI.imprimirOpcionesDeTareaJefe();
            opcion = Teclado.leeNumero("Introduce opcion deseada: ");
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