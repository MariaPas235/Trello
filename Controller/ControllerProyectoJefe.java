package Controller;

import IO.Teclado;
import Interface.IControllerProyectoJefe;
import Model.entity.Colaborador;
import Model.entity.Jefe;
import Model.entity.Proyecto;
import Model.repo.RepoProyecto;
import view.GUI;

import java.security.NoSuchAlgorithmException;

public class ControllerProyectoJefe implements IControllerProyectoJefe {
    view.GUI GUI = new GUI();
    Jefe jefe = new Jefe();
    Colaborador colaborador= new Colaborador();
    static RepoProyecto rProyecto = RepoProyecto.get_instance();

    public ControllerProyectoJefe(){
    }

    public  void controladorProyectosJefe(Proyecto proyecto){
        int opcion= 0;
        do{
            System.out.println("Bienvenido! " + proyecto.getNombre());
            GUI.imprimeProyecto(proyecto);
            GUI.imprimirOpcionesDeTarea();
            opcion= Teclado.leeNumero("Introduce opcion deseada: ");
            switch (opcion){
                case 1:
                    jefe.anadirTarea();
                    break;
                case 2:
                    jefe.borrarTarea();
                    break;
                case 3:
                    //jefe.anadirColaboradores();
                    break;
                case 4:
                    jefe.eliminarColaboradores();
                    break;
                case 5:
                    jefe.asignartarea();
                    break;
                case 6:
                    jefe.actualizarTarea();
                    break;
            }
        }while(!(opcion ==7));
    }
}
