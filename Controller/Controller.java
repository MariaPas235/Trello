package Controller;

import Interface.IController;
import Model.entity.Persona;
import Model.repo.RepoPersona;
import Model.repo.Sesion;
import view.GUI;
import view.GUIMENU;

//La clase controlador implementa las funciones de la interfaz IController
public class Controller implements IController {
    //Se crea una nueva instancia de la clase GUI asignada a la variable de la GUI
    GUIMENU GUIMENU =new GUIMENU();
    //Se crea una instancia de la clase RepoPersona asignada a la variable rPersona
    //static indica que rPersona es una variable de clase que es compartida por todas las instancias de la clase en la que se declara
    RepoPersona rPersona = RepoPersona.get_instance();
    //Se crea una nueva instancia de la clase ControllerMenu asignada a la variable controladorMenu
    ControllerMenu controladorMenu = new ControllerMenu();

    //Constructor vacio del Controller
    public Controller() {
    }

    //Funcion del controllerMain
    /**
     * -Funcion del controllerMain
     * @return devuelve un mensaje de despedida del usuario si escribe la opcion 3ç
     * -Primero, llama a la funcion de la GUI imprimirBienvenida
     * -Dentro de este bucle hace llamamiento a la funcion de la GUI imprimirMenuBienvenida
     * -Se le pide al usuario escribir una opcion (con la funcion del Teclado leeNumero) de este menu (1 Registrarse, 2 iniciar sesion)
     * -En la opcion 1 se crea un usuario y llama a la funcion de la GUI recogeDatosRegistro
     *  Este usuario creado se añade al repositorio de persona y se guarda el repositorio
     * -En la opcion 2 se hace un llamamiento a la funcion iniciarSesion de la clase Sesion y se crea una instancia de la clase
     *  GUI y se recogen esos datos de inicio de sesion con el llamamiento a la funcion de la GUI recogeDatosInicio
     *  Cuando ya se ha iniciado el usuario en el programa, se hace llamamiento a la funcion de la GUI bienvenidaApp
     *  Lo siguiente es hacer un llamamiento a la funcion controladorMenu de la clase controllador menu que le pasa la instancia
     *  actual de la sesion
     *  Por ultimo despues de manejar el menu, se cierra la sesion con la funcion cerrarSesion de la clase Sesion
     *  -La opcion 3 es para salir del programa y saldra del bucle
     */
    @Override
    public void controllerMain() {
        GUIMENU.imprimirBienvenida();
        int opcion;
        do {
            opcion=GUIMENU.imprimirMenuInicio();
            switch (opcion) {
                case 1:
                    Persona persona = GUIMENU.recogeDatosRegistro();
                    rPersona.add(persona);
                    break;
                case 2:
                    Persona logged=null;
                    do {
                        Persona p = GUIMENU.recogeDatosInicio();
                        logged = rPersona.login(p);
                    }while(logged==null);
                    Sesion.iniciarSesion(logged);
                    GUIMENU.bienvenidaApp();
                    controladorMenu.controladorMenu();
                    Sesion.cerrarSesion();
                    break;
                case 3:
                    GUIMENU.IntroducePersonaBorrar();
                    Persona persona1 = GUIMENU.recogeDatosInicio();
                    if(GUIMENU.EstaSeguro()) {
                        rPersona.delete(persona1.getNombre());
                    }
                    break;
            }
        } while (opcion != 4);

        System.out.println("Gracias por usar Trello. Hasta pronto （＾∀＾）ﾉｼ");


    }
}