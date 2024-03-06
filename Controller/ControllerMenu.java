package Controller;

import Interface.IControllerMenu;
import Model.entity.Colaborador;
import Model.entity.Jefe;
import Model.entity.Proyecto;
import Model.repo.RepoProyecto;
import Model.repo.Sesion;
import view.GUI;

import java.security.NoSuchAlgorithmException;

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
            System.out.println("Hola! " + sesion.getPersona());
            option= GUI.imprimirMenuProyectos();
            switch (option){
                case 1:
                    GUI.recogerDatosProyecto();
                    //aquí quiero que cuando meta todos los datos salte al menu otra vez
                    break;
                case 2:
                    rProyecto.delete(GUI.borrarProyecto());
                    break;
                case 3:
                    //listar proyectos como colaborador
                    GUI.listarProyectos();
                    break;
                case 4:
                    Proyecto proyecto = GUI.seleccionarProyecto();
                    controladorProyectosJefe.controladorProyectosJefe(proyecto);
                    break;
            }
        }while(!(option ==5));

    }
}
