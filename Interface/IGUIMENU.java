package Interface;

import Model.entity.Persona;

public interface IGUIMENU {
    //Funcion que muestra el menu de bienvenida
    void imprimirBienvenida();


    Persona recogeDatosInicio();

    Persona recogeDatosRegistro();

    int imprimirMenuInicio();

    String IntroducePersonaBorrar();

    boolean EstaSeguro();

    //Funcion que muestra el menu de bienvenida tras iniciar sesion
    void bienvenidaApp();
}
