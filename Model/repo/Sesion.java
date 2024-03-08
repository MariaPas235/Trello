package Model.repo;

import Interface.IGUI;
import Model.entity.Persona;

public class Sesion {
    private static Sesion _instance;
    private static IGUI GUI;
    private Persona persona;

    // Método para establecer la instancia de IGUI
    public static void setGUI(IGUI gui) {
        GUI = gui;
    }

    private Sesion(){}

    public Sesion(Persona persona){
        this.persona = persona;
    }

    public static Sesion getInstance(){
        if (_instance == null){
            _instance = new Sesion(GUI.recogeDatosInicio());
        }
        return _instance;
    }

    public Persona getPersona(){
        return persona;
    }

    public void setPersona(Persona persona){
        this.persona = persona;
    }
    public void cerrarSesion() {
        _instance = null;
    }
}