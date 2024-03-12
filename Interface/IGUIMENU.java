package Interface;

import Model.entity.Persona;

public interface IGUIMENU {
    //Funcion que muestra el menu de bienvenida
    void imprimirBienvenida();

    //Funcion de recoger los datos del usuario al inicio de sesion
    Persona recogeDatosInicio();
    //Funcion de recoger los datos del usuario al registrarse

    Persona recogeDatosRegistro();

    //Funcion que imprime el menu de inicio
    int imprimirMenuInicio();

    //Funcion que lee la persona que se pasa por teclado
    String IntroducePersonaBorrar();

    //Funcion que confirma o no la eliminacion del usuario
    boolean EstaSeguro();

    //Funcion que muestra el menu de bienvenida tras iniciar sesion
    void bienvenidaApp();
}
