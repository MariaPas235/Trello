package Model.entity;

import Interface.IJefe;

import java.security.NoSuchAlgorithmException;

public class Jefe extends Persona implements IJefe {
    public Jefe() {
        super("","","","");
    }
    //Funciones que tiene el jefe de un proyecto
    @Override
    public void anadirColaboradores() {

    }

    @Override
    public void eliminarColaboradores() {

    }

    @Override
    public void anadirTarea() {

    }

    @Override
    public void asignartarea() {

    }

    @Override
    public void borrarTarea() {

    }

    @Override
    public void actualizarTarea() {

    }
}
