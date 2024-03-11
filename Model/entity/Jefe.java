package Model.entity;

import IO.Teclado;
import Interface.IJefe;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static view.GUI.anadirFechaFin;

//La clase jefe obiene los metodos por herencia de persona e implementa las funciones de Ijefe y el serializable
public class Jefe extends Persona implements IJefe, Serializable {
    //Constructor de la clase por efecto inicializando en string vacio con los atributos heredados de persona
    public Jefe() {
        super("", "", "", "");
    }
}







