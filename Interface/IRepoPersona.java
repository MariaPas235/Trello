package Interface;

import Model.entity.Persona;

import java.util.Collection;

public interface IRepoPersona {
    Persona add(Persona data);
    Persona getByID(String id);
    Collection<Persona> getAll();
    Persona update(Persona data);
    boolean delete(String nombrePersona);
    boolean getByUserName(String username);
    boolean getByEmail(String mail);
    boolean getBypassword(String password);
    boolean save ();
}
