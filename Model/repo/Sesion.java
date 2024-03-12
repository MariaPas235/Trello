package Model.repo;

import Model.entity.Persona;

public class Sesion {
    //Atributos de la clase
    private static Sesion _instance;
    private Persona persona;

    // Constructor privado para evitar la creación de instancias directamente
    private Sesion(Persona persona) {
        this.persona = persona;
    }

    // Método para iniciar sesión con una persona
    public static void iniciarSesion(Persona persona) {
        if (_instance == null) {
            _instance = new Sesion(persona);
        } else {
            System.out.println("Ya hay una sesión activa. Cierra la sesión actual antes de iniciar una nueva.");
        }
    }

    public static Sesion getInstance() {
        return _instance;
    }

    //Constructor vacio
    private Sesion() {
    }
    //Constructor con los atributos


    //Getter de persona
    public Persona getPersona() {
        return persona;
    }

    //Setter de persona
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    //Funcion que cierra la sesion del usuario
    public static void cerrarSesion() {
        _instance = null;
    }
}