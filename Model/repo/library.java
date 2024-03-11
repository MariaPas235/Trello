package Model.repo;

import serializator.Serializator;

import java.io.Serializable;
import java.util.Collection;

//La clase abstracta implementa el serializador
//Funciones de la clase abstracta
public abstract class library<T, K> implements Serializable {
    // Funcion para cargar datos desde un archivo

    /**
     * Funcion para cargar objetos (personas) desde un archivo
     *
     * @param filename el archivo donde va a cargarse los datos
     * @return devuelve el archivo donde se cargan los datos
     */
    public static Object load(String filename) {
        return Serializator.desearize(filename);
    }
    // Funcion para guardar datos en un archivo

    /**
     * Funcion para guardar datos en un archivo
     *
     * @param filename archivo donde se guardan los datos
     * @return devuelve el resultado si se ha guardado correctamente los datos
     */
    public boolean save(String filename) {
        return Serializator.Serialize(this, filename);
    }

    // Funcion de agregar un objeto
    public abstract T add(T data);

    // Funcion de obtener un objeto por su ID
    public abstract T getByID(K id);

    // Funcion de obtener todos los objetos
    public abstract Collection<T> getAll();

    // Funcion de actualizar un objeto
    public abstract T update(T data);

    // Funcion de borrar un objeto por su ID
    public abstract boolean delete(K id);

    //Funcion de buscar por nombre de usuario
    public abstract boolean getByUserName(K username);

    //Funcion de buscar por email
    public abstract boolean getByEmail(K email);

    //Funcion de buscar por contraseña
    public abstract boolean getBypassword(K password);
}
