package Controller;

import Interface.IController;
import Model.entity.Proyecto;
import Model.repo.Sesion;
import view.GUI;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

public class Controller implements IController {
    GUI GUI = new GUI();
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
                GUI.imprimirMenuProyectos();
                option= GUI.leeNumero("Introduce opcion deseada: ");
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
                        //listar proyectos creados
                        GUI.listarProyectosCreados();
                        break;
                    case 4:
                        //listar proyectos como colaborador
                        GUI.listarProyectos();
                        break;
                    case 5:
                        controladorProyectosJefe(GUI.seleccionarProyecto());
                        break;
                }
            }while(!(option ==6));

        }
        public  void controladorProyectosJefe(Proyecto proyecto){
            int opcion= 0;
            do{
                System.out.println("Bienvenido! " + proyecto.getNombre());
                GUI.imprimeProyecto();
                GUI.imprimirOpcionesDeTarea();
                opcion= GUI.leeNumero("Introduce opcion deseada: ");
                switch (opcion){
                    case 1:
                        GUI.anadirTarea();
                        break;
                    case 2:
                        GUI.borrarTarea();
                        break;
                    case 3:
                        GUI.moverTarea();
                        break;
                    case 4:
                        GUI.asignarTarea();
                        break;
                    case 5:
                        GUI.editarTarea();
                        break;
                }
            }while(!(opcion ==6));
        }
    public  void controladorProyectosColaborador(Proyecto proyecto){
        int opcion= 0;
        do{
            System.out.println("Bienvenido! " + proyecto.getNombre());
            GUI.imprimeProyecto();
            GUI.imprimirOpcionesDeTarea();
            opcion= GUI.leeNumero("Introduce opcion deseada: ");
            switch (opcion){
                case 1:
                    GUI.editarTarea();
                    break;
                case 2:
                    GUI.moverTarea();
                    break;
                case 3:
                    GUI.desasignarTarea();
                    break;
            }
        }while(!(opcion ==4));
    }
    }
