package Model.repo;

import serializator.Serializator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public abstract class LibraryTask <T, K>implements Serializable {
    // Funcion para cargar datos desde un archivo

    /**
     * Funcion para cargar tareas desde un archivo
     *
     * @param filename el archivo donde va a cargarse los datos
     * @return devuelve el archivo donde se cargan los datos
     */
    public static LibraryTask load(String filename) {
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

    // Funcion de actualizar un objeto
    public abstract T add(T data);

    // Funcion de borrar un objeto por su ID
    public abstract T getByID(K id);

    //Funcion de obtener una tarea por su nombre
    public abstract boolean getByName(String Name);
    // Funcion de obtener todos los objetos
    public abstract Collection<T> getAll();
    //Funcion de actualizar un objeto
    public abstract T update(T data);
    // Funcion de borrar un objeto por su ID
    public abstract boolean delete(K id);

}
