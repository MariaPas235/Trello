package Controller;

import Interface.IController;
import Model.entity.*;
import Model.repo.RepoPersona;
import Model.repo.RepoProyecto;
import Model.repo.Sesion;
import view.GUI;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Controller implements IController {
    GUI GUI = new GUI();
    Jefe jefe = new Jefe();
    Colaborador colaborador = new Colaborador();
    static  RepoPersona rPersona = new RepoPersona();
    static RepoProyecto rProyecto = RepoProyecto.get_instance();
    ControllerMenu controladorMenu = new ControllerMenu();

    //tengotrabajoquehacer
    public Controller() {
    }

    @Override
    public String controllerMain() {
        GUI.imprimirBienvenida();
        do {
            switch (GUI.imprimirMenuInicio()) {
                case 1:
                    Persona persona = GUI.recogeDatosRegistro();
                    rPersona.add(persona);
                    rPersona.save();
                    break;
                case 2:
                    Sesion.setGUI(new GUI());
                    GUI.bienvenidaApp();
                    controladorMenu.controladorMenu(Sesion.getInstance());
                    break;
                case 3:
                    break;
            }
        } while (!(GUI.imprimirMenuInicio() == 3));

        return "Gracias por usar Trello. Hasta pronto （＾∀＾）ﾉｼ";


    }
}