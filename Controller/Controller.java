package Controller;

import IO.Teclado;
import Interface.IController;
import Model.entity.Colaborador;
import Model.entity.Jefe;
import Model.entity.Persona;
import Model.repo.RepoPersona;
import Model.repo.RepoProyecto;
import Model.repo.Sesion;
import view.GUI;


public class Controller implements IController {
    GUI GUI = new GUI();
    static RepoPersona rPersona = new RepoPersona();
    ControllerMenu controladorMenu = new ControllerMenu();

    //tengotrabajoquehacer
    public Controller() {
    }

    @Override
    public String controllerMain() {
        GUI.imprimirBienvenida();
        int opcion;
        do {
            GUI.imprimirMenuInicio();
            opcion = Teclado.leeNumero("Introduzca opción: ");
            switch (opcion) {
                case 1:
                    Persona persona = GUI.recogeDatosRegistro();
                    rPersona.add(persona);
                    rPersona.save();
                    break;
                case 2:
                    Sesion.iniciarSesion(new GUI(), GUI.recogeDatosInicio());
                    GUI.bienvenidaApp();
                    controladorMenu.controladorMenu(Sesion.getInstance());
                    Sesion.cerrarSesion();
                    break;
                case 3:
                    break;
            }
        } while (!(opcion == 3));

        return "Gracias por usar Trello. Hasta pronto （＾∀＾）ﾉｼ";


    }
}