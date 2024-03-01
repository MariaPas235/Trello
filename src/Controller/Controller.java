package Controller;

import Interface.IController;
import Interface.IGUI;
import view.GUI;

import java.io.FileNotFoundException;

public class Controller implements IController {
    GUI GUI = new GUI();
        @Override
        public String controllerMain() throws FileNotFoundException {
            GUI.imprimirBienvenida();
            switch (GUI.imprimirMenuInicio()){
                case 1:
                    GUI.recogeDatosRegistro();
                case 2:
                    GUI.recogeDatosInicio();
                    break;
            }
            return null;
        }
    }
