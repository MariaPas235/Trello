package Controller;

import Interface.IController;
import Model.entity.Colaborador;
import Model.entity.Jefe;
import Model.entity.Proyecto;
import Model.repo.Sesion;
import view.GUI;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

public class Controller implements IController {
    GUI GUI = new GUI();
    Jefe jefe = new Jefe();
    Colaborador colaborador= new Colaborador();

    public Controller() throws NoSuchAlgorithmException {
    }

    @Override
        public String controllerMain() throws FileNotFoundException, NoSuchAlgorithmException {
            GUI.imprimirBienvenida();
            switch (GUI.imprimirMenuInicio()){
                case 1:
                    GUI.recogeDatosRegistro();
                case 2:
                    GUI.bienvenidaApp();
                    Sesion sesion = new Sesion(GUI.recogeDatosInicio());
                    controladorMenu(sesion);
                    break;
                case 3:
                    break;

            }
            return "Gracias por usar Trello. Hasta pronto （＾∀＾）ﾉｼ";
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
                        //borrar proyecto por nombre
                        GUI.borrarProyecto();
                        break;
                    case 3:
                        //listar proyectos como colaborador
                        GUI.listarProyectos();
                        break;
                    case 4:
                        Proyecto proyecto = GUI.seleccionarProyecto();
                        controladorProyectosJefe(proyecto);
                        break;
                }
            }while(!(option ==5));

        }
        public  void controladorProyectosJefe(Proyecto proyecto){
            int opcion= 0;
            do{
                System.out.println("Bienvenido! " + proyecto.getNombre());
                GUI.imprimeProyecto(proyecto);
                GUI.imprimirOpcionesDeTarea();
                opcion= GUI.leeNumero("Introduce opcion deseada: ");
                switch (opcion){
                    case 1:
                        jefe.anadirTarea();
                        break;
                    case 2:
                        jefe.borrarTarea();
                        break;
                    case 3:
                        jefe.anadirColaboradores();
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
