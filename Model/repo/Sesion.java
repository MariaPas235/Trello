package Model.repo;

import Interface.IGUI;
import Model.entity.Persona;

public class Sesion {
    //Atributos de la clase
    private static Sesion _instance;
    private static IGUI GUI;
    private Persona persona;

    // Constructor privado para evitar la creación de instancias directamente
    private Sesion(IGUI gui, Persona persona) {
        GUI = gui;
        this.persona = persona;
    }

    // Método para establecer la instancia de IGUI
    public static void setGUI(IGUI gui) {
        GUI = gui;
    }

    // Método para iniciar sesión con una persona
    public static void iniciarSesion(IGUI gui, Persona persona) {
        if (_instance == null) {
            _instance = new Sesion(gui, persona);
        } else {
            System.out.println("Ya hay una sesión activa. Cierra la sesión actual antes de iniciar una nueva.");
        }
    }
    //Constructor vacio
    private Sesion(){}
    //Constructor con los atributos
    public Sesion(Persona persona){
        this.persona = persona;
    }
//Funcion que obtiene la instancia del inicio de sesion de un usuario

    /**
     * Funcion que obtiene la instancia del inicio de sesion de un usuario
     * @return la instancia de una sesion
     */
    public static Sesion getInstance() {
        if (_instance == null) {
            if (GUI == null) {
                throw new IllegalStateException("La instancia de GUI no ha sido inicializada. Llama al método setGUI primero.");
            }
            _instance = new Sesion(GUI.recogeDatosInicio());
        }
        return _instance;
    }
    //Getter de persona
    public Persona getPersona(){
        return persona;
    }
    //Setter de persona
    public void setPersona(Persona persona){
        this.persona = persona;
    }
    //Funcion que cierra la sesion del usuario
    public static void cerrarSesion() {
        _instance = null;
    }
}