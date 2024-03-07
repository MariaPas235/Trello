package Controller;

import Interface.IControllerMenu;
import Model.entity.Colaborador;
import Model.entity.Jefe;
import Model.entity.Proyecto;
import Model.repo.RepoProyecto;
import Model.repo.Sesion;
import view.GUI;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class ControllerMenu implements IControllerMenu {
    view.GUI GUI = new GUI();
    Jefe jefe = new Jefe();
    Colaborador colaborador= new Colaborador();
    ControllerProyectoJefe controladorProyectosJefe = new ControllerProyectoJefe();
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
                    //aquí quiero que cuando meta todos los datos salte al menu otra vez
                    break;
                case 2:
                    rProyecto.delete(GUI.borrarProyecto());
                    break;
                case 3:
                    ArrayList<Proyecto> proyectos = (ArrayList<Proyecto>) rProyecto.getAll();
                    if (proyectos.isEmpty()) {
                        System.out.println("No hay proyectos creados.");
                    } else {
                        System.out.println("Proyectos creados:");
                        for (Proyecto proyecto : proyectos) {
                            GUI.listarProyectos(proyecto);
                        }
                    }
                case 4:
                    Proyecto proyecto;
                    do {
                         proyecto= rProyecto.getByID(GUI.seleccionarProyecto());

                    }while (!rProyecto.getByName(GUI.seleccionarProyecto()));

                    controladorProyectosJefe.controladorProyectosJefe(proyecto);
                    break;
            }
        }while(!(option ==5));

    }
}
