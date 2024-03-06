package Controller;

import Interface.IControllerProyectoColaborador;
import Model.entity.Colaborador;
import Model.entity.Jefe;
import Model.entity.Proyecto;
import Model.repo.RepoProyecto;
import view.GUI;

import java.security.NoSuchAlgorithmException;

public class ControllerProyectoColaborador implements IControllerProyectoColaborador {
    view.GUI GUI = new GUI();
    Jefe jefe = new Jefe();
    Colaborador colaborador= new Colaborador();
    static RepoProyecto rProyecto = RepoProyecto.get_instance();

    public ControllerProyectoColaborador() throws NoSuchAlgorithmException {
    }

    public  void controladorProyectosColaborador(Proyecto proyecto){
        int opcion= 0;
        do{
            System.out.println("Bienvenido! " + proyecto.getNombre());
            GUI.imprimeProyecto(proyecto);
            GUI.imprimirOpcionesDeTarea();
            opcion= GUI.leeNumero("Introduce opcion deseada: ");
            switch (opcion){
                case 1:
                    colaborador.actualizarEstadoTarea();
                    break;
                case 2:
                    colaborador.verComentario();
                    break;
                case 3:
                    colaborador.desasignarTarea();
                    break;
            }
        }while(!(opcion ==4));
    }
}
