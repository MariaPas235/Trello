package Controller;

import Interface.IController;
import Interface.IGUI;
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
                    GUI.recogeDatosInicio();

                    switch (GUI.imprimirMenuProyectos()){
                        case 1:
                            GUI.recogerDatosProyecto();
                            //aquí quiero que cuando meta todos los datos salte al menu otra vez
                        case 2:
                            //borrar proyecto por nombre
                        case 3:
                            //listar proyectos creados
                        case 4:
                            //listar proyectos como colaborador
                        case 5:
                            System.out.println("Gracias por usar Trello. Hasta pronto （＾∀＾）ﾉｼ");
                            break;
                    }
                    break;
                case 3:
                    break;

            }
            return null;
        }
    }
