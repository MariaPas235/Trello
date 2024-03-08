package Controller;

import Interface.IControllerMenu;
import Model.entity.Colaborador;
import Model.entity.Jefe;
import Model.entity.Proyecto;
import Model.entity.Tarea;
import Model.repo.RepoProyecto;
import Model.repo.Sesion;
import view.GUI;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class ControllerMenu implements IControllerMenu {
    view.GUI GUI = new GUI();
    Jefe jefe = new Jefe();
    Colaborador colaborador= new Colaborador();
    ControllerProyectoJefe controladorProyectosJefe = new ControllerProyectoJefe();
    ControllerProyectoColaborador controllerProyectoColaborador = new ControllerProyectoColaborador();
    static RepoProyecto rProyecto = RepoProyecto.get_instance();

    public ControllerMenu() {
    }

    public void controladorMenu(Sesion sesion){
        int option = 0;
        do{
            System.out.println("Hola! " + sesion.getPersona().getUsuario());
            option= GUI.imprimirMenuProyectos();
            switch (option){
                case 1:
                    rProyecto.add( GUI.recogerDatosProyecto(sesion.getPersona().getUsuario()));
                    rProyecto.save();
                    break;
                case 2:
                    rProyecto.delete(GUI.borrarProyecto());
                    break;
                case 3:
                    Set<Proyecto> proyectosSet = (Set<Proyecto>) rProyecto.getAll();
                    if (proyectosSet.isEmpty()) {
                        System.out.println("No hay proyectos creados.");
                    } else {
                        System.out.println("Proyectos creados:");
                        for (Proyecto proyecto : proyectosSet) {
                            GUI.listarProyectos(proyecto);
                        }
                    }
                    break;
                case 4:
                    Proyecto proyecto;
                    boolean aux = false;

                    do {
                        // Obtener el proyecto por su ID
                        proyecto = rProyecto.getByID(GUI.seleccionarProyecto());

                        if (proyecto != null) {
                            // Si se encontró el proyecto, establecer aux a true y mostrar información del proyecto
                            aux = true;
                            System.out.println(proyecto.toString());
                        } else {
                            // Si no se encontró el proyecto, mostrar un mensaje de error
                            System.out.println("El proyecto seleccionado no existe. Por favor, seleccione un proyecto válido.");
                        }
                    } while (!aux);

// Verificar si el usuario actual es el jefe del proyecto
                    if (Objects.equals(proyecto.getJefe(), sesion.getPersona().getUsuario())) {
                        controladorProyectosJefe.controladorProyectosJefe(proyecto, proyecto.getTareas());
                    } else {
                        // Verificar si el usuario actual es colaborador del proyecto
                        if (proyecto.esColaborador(sesion.getPersona().getUsuario())) {
                            controllerProyectoColaborador.controladorProyectosColaborador(proyecto);
                        } else {
                            // Si no es colaborador del proyecto
                            System.out.println("Usted no es colaborador del proyecto seleccionado.");
                            // Aquí puedes manejar la situación de otra manera, por ejemplo, mostrar un mensaje de error o redirigir a otra página.
                        }
                    }
                    break;
            }
        }while(!(option ==5));

    }
}
