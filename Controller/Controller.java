package Controller;

import Interface.IController;
import Model.entity.Persona;
import Model.repo.RepoPersona;
import Model.repo.Sesion;
import view.GUI;

//La clase controlador implementa las funciones de la interfaz IController
public class Controller implements IController {
    //Se crea una nueva instancia de la clase GUI asignada a la variable de la GUI
    GUI GUI = new GUI();
    //Se crea una instancia de la clase RepoPersona asignada a la variable rPersona
    //static indica que rPersona es una variable de clase que es compartida por todas las instancias de la clase en la que se declara
    static RepoPersona rPersona = new RepoPersona();
    //Se crea una nueva instancia de la clase ControllerMenu asignada a la variable controladorMenu
    ControllerMenu controladorMenu = new ControllerMenu();

    //Constructor vacio del Controller
    public Controller() {
    }

    //Funcion del controllerMain
    /**
     * Función del controllerMain:
     * - Muestra un mensaje de bienvenida al usuario.
     * - Presenta un menú de opciones.
     * - Permite al usuario registrarse o iniciar sesión y borrar usuario.
     * - Maneja las acciones correspondientes a cada opción del menú.
     * - Cierra la sesión al salir del programa.
     */
    @Override
    public void controllerMain() {
        GUI.imprimirBienvenida();
        int opcion;
        do {
            opcion=GUI.imprimirMenuInicio();
            switch (opcion) {
                case 1:
                    Persona persona = GUI.recogeDatosRegistro();
                    rPersona.add(persona);
                    rPersona.save();
                    break;
                case 2:
                    Sesion.iniciarSesion(GUI.recogeDatosInicio());
                    GUI.bienvenidaApp();
                    controladorMenu.controladorMenu(Sesion.getInstance());
                    Sesion.cerrarSesion();
                    break;
                case 3:
                    GUI.IntroducePersonaBorrar();
                    Persona persona1 = GUI.recogeDatosInicio();
                    if(GUI.EstaSeguro()) {
                        rPersona.delete(persona1.getNombre());
                        rPersona.save();
                    }
                    break;
            }
        } while (opcion != 4);

        System.out.println("Gracias por usar Trello. Hasta pronto （＾∀＾）ﾉｼ");


    }
}