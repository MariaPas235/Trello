package Model.entity;

import java.io.Serializable;

//La clase jefe obiene los metodos por herencia de persona e implementa las funciones de Ijefe y el serializable
public class Jefe extends Persona implements  Serializable {
    //Constructor de la clase por efecto inicializando en string vacio con los atributos heredados de persona
    public Jefe() {
        super("", "", "", "");
    }
}







