package Interface;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

//Funciones que se implementan en la clase controller
public interface IController {
    //Funcion del controller que contiene dentro de este llamamientos a funciones de la vista de los menus de inicio
    String controllerMain() throws FileNotFoundException, NoSuchAlgorithmException;
}
