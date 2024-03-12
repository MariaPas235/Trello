package Interface;

import Model.entity.Persona;

import java.io.Serializable;
import java.util.Collection;

//Funciones que se implementan en la clase de repo de personas
public interface IRepoPersona extends Serializable {
    //Funcion de añadir los datos de una persona (usuario)

    Persona add(Persona data);
    //Funcion de obtener una persona (usuario) por ID

    Persona getByID(String id);

    //Funcion que obtiene todas las personas de la collecion
    Collection<Persona> getAll();
    //Funcion que actualiza una persona existente en una lista de personas con uno nuevo

    Persona update(Persona data);
    //Funcion de eliminar una persona por su nombre

    boolean delete(String nombrePersona);
    //Funcion que busca una persona por su usuario

    boolean getByUserName(String username);
    //Funcion que busca el usuario por su mail

    boolean getByEmail(String mail);
    //Funcion que comprueba la contraseña del usuario

    boolean getBypassword(String password);
    //Funcion que guarda los datos en el archivo del Repo

    boolean save();
}
