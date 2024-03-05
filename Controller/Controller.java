package Controller;

import Interface.IController;
import Interface.IGUI;
import Model.entity.Persona;
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
                    controladorMenu(GUI.recogeDatosInicio());
                    break;
                case 3:
                    break;

            }
            return "Gracias por usar Trello. Hasta pronto （＾∀＾）ﾉｼ";
        }
        public void controladorMenu(Persona persona){
            int option = 0;
            do{
                System.out.println("Hola! " + persona.getNombre());
                GUI.imprimirMenuProyectos();
                option= GUI.leeNumero("Introduce opcion deseada: ");
                switch (option){
                    case 1:
                        GUI.recogerDatosProyecto();
                        //aquí quiero que cuando meta todos los datos salte al menu otra vez
                    case 2:
                        //borrar proyecto por nombre
                        GUI.borrarProyecto();
                    case 3:
                        //listar proyectos creados
                        GUI.listarProyectosCreados();
                    case 4:
                        //listar proyectos como colaborador
                        GUI.listarProyectosColaborador();
                    case 5:

                        GUI.selecionarProyecto();
                        break;
                }
            }while(!(option ==6));

        }
    }
