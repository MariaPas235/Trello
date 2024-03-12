package Controller;

import Interface.IControllerMenu;
import Model.entity.Proyecto;
import Model.repo.RepoProyecto;
import Model.repo.Sesion;
import view.GUI;

import java.util.Objects;
import java.util.Set;

//La clase implementa los metodos de la interfaz IControllerMenu
public class ControllerMenu implements IControllerMenu {
    view.GUI GUI = new GUI();
    ControllerProyectoJefe controladorProyectosJefe = new ControllerProyectoJefe();
    ControllerProyectoColaborador controllerProyectoColaborador = new ControllerProyectoColaborador();
    RepoProyecto rProyecto = RepoProyecto.get_instance();

    public ControllerMenu() {
    }

    //Funcion del controlador del menu
    /**
     * Funcion del controlador del menu
     * Primero nos muestra un mensaje de bienvenida junto al usuario tras iniciar sesion
     * Se llama a la funcion del menu de opciones dd proyecto y elige una de las opiones
     * A continuacion el proyecto dependiendo de la opcion  se guarda, se crea y añade o borra del repo de proyectos
     * Tambien muestra todos los proyectos y su informacion guardados en el repo
     */
    public void controladorMenu(){
        Sesion sesion = Sesion.getInstance();
        int option;
        do{
            System.out.println("Hola! " + sesion.getPersona().getUsuario());
            option= GUI.imprimirMenuProyectos();
            Proyecto proyectoaux;
            switch (option){
                case 1:
                    rProyecto.add( GUI.recogerDatosProyecto(sesion.getPersona().getUsuario()));
                    break;
                case 2:
                    boolean aux = false;

                    do {
                        // Obtener el proyecto por su ID
                        proyectoaux = rProyecto.getByID(GUI.seleccionarProyecto());

                        if (proyectoaux != null) {
                            // Si se encontró el proyecto, establecer aux a true y mostrar información del proyecto
                            aux = true;
                        } else {
                            // Si no se encontró el proyecto, mostrar un mensaje de error
                            System.out.println("El proyecto seleccionado no existe. Por favor, seleccione un proyecto válido.");
                        }
                    } while (!aux);
                    if (Objects.equals(proyectoaux.getJefe(), sesion.getPersona().getUsuario())) {
                        rProyecto.delete(GUI.borrarProyecto());
                    }else{
                        System.out.println("Usted No puede borrar este proyecto porque no es el jefe");
                    }
                    proyectoaux = null;
                    break;
                case 3:
                    Set<Proyecto> proyectosSet = (Set<Proyecto>) rProyecto.getAll();
                    if (proyectosSet.isEmpty()) {
                        System.out.println("No hay proyectos creados.");
                    } else {
                        System.out.println("Proyectos creados:");
                        for (Proyecto proyecto : proyectosSet) {
                            // Verificar si el usuario actual es el jefe del proyecto o si es colaborador del proyecto
                            if (Objects.equals(proyecto.getJefe(), sesion.getPersona().getUsuario()) || proyecto.esColaborador(sesion.getPersona().getUsuario())) {
                                GUI.listarProyectos(proyecto);
                            }
                        }
                    }
                    break;
                case 4:
                    aux = false;

                    do {
                        // Obtener el proyecto por su ID
                        proyectoaux = rProyecto.getByID(GUI.seleccionarProyecto());

                        if (proyectoaux != null) {
                            // Si se encontró el proyecto, establecer aux a true y mostrar información del proyecto
                            aux = true;
                        } else {
                            // Si no se encontró el proyecto, mostrar un mensaje de error
                            System.out.println("El proyecto seleccionado no existe. Por favor, seleccione un proyecto válido.");
                        }
                    } while (!aux);

                    // Verificar si el usuario actual es el jefe del proyecto
                    if (Objects.equals(proyectoaux.getJefe(), sesion.getPersona().getUsuario())) {
                        controladorProyectosJefe.controladorProyectosJefe(proyectoaux, proyectoaux.getTareas());
                    } else {
                        // Verificar si el usuario actual es colaborador del proyecto
                        if (proyectoaux.esColaborador(sesion.getPersona().getUsuario())) {
                            controllerProyectoColaborador.controladorProyectosColaborador(proyectoaux,proyectoaux.getTareas());
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
