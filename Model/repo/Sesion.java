package Model.repo;

import Model.entity.Persona;

public class Sesion {
    private static Sesion _instance;
    private Persona persona;
    private Sesion(){}
    public static Sesion getInstance(){


        if (_instance==null){
            _instance=new Sesion();
        }
        return _instance;
    }

    public Persona setPersona(){  //entra persona view
        return persona;
    }

    public void setPersona(Persona persona){

        this.persona=persona;
    }


}
