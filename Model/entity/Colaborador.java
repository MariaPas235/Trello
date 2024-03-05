package Model.entity;

import Interface.IColaborador;

import java.security.NoSuchAlgorithmException;

public class Colaborador extends Persona implements IColaborador {
    public Colaborador() throws NoSuchAlgorithmException {
        super("","","","");
    }
    //Metodos que tendra el colaborador
    @Override
    public void actualizarEstadoTarea() {

    }
}
