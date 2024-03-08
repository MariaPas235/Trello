package Interface;

import Model.entity.Persona;

import java.util.Collection;
//Funciones que se implementan en la clase de repo de personas
public interface IRepoPersona {
    Persona add(Persona data);
    Persona getByID(String id);
    //Funcion que obtiene todas las personas de la collecion
    Collection<Persona> getAll();
    Persona update(Persona data);
    boolean delete(String nombrePersona);
    boolean getByUserName(String username);
    boolean getByEmail(String mail);
    boolean getBypassword(String password);
    boolean save ();
}
