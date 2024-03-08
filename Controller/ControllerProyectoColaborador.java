package Controller;


import Interface.IControllerProyectoColaborador;
import Model.entity.Colaborador;
import Model.entity.Jefe;
import Model.entity.Proyecto;
import Model.entity.Tarea;
import Model.repo.RepoProyecto;
import view.GUI;

import java.util.ArrayList;

public class ControllerProyectoColaborador implements IControllerProyectoColaborador {
    view.GUI GUI = new GUI();
    Jefe jefe = new Jefe();
    Colaborador colaborador= new Colaborador();
    static RepoProyecto rProyecto = RepoProyecto.get_instance();

    public ControllerProyectoColaborador() {
    }

    public  void controladorProyectosColaborador(Proyecto proyecto, ArrayList<Tarea> tareas){
        int opcion= 0;
        do{
            System.out.println("Bienvenido! " + proyecto.getNombre());
            GUI.imprimeProyecto(proyecto);
            opcion=GUI.imprimirOpcionesDeTareaColaborador();
            switch (opcion){
                case 1:
                    colaborador.actualizarTarea(tareas);
                    break;
                case 2:
                    colaborador.verComentario(proyecto);
                    break;
            }
        }while(!(opcion ==3));
    }
}
