package Model.repo;

import Interface.IGUI;
import Model.entity.Persona;

public class Sesion {
    private static Sesion _instance;
    private static IGUI GUI;
    private Persona persona;
    public Sesion(Persona persona){}
    public static Sesion getInstance(){


        if (_instance==null){
            _instance=new Sesion(GUI.recogeDatosInicio());
        }
        return _instance;
    }

    public Persona getPersona(){  //entra persona view
        return persona;
    }

    public void setPersona(Persona persona){

        this.persona=persona;
    }


}
