package Interface;

import Model.entity.Proyecto;

import java.util.Collection;

//Funciones que se implementan en la clase de repo de proyectos
public interface IRepoProyecto {
//Funcion de añadir los datos de un proyecto

    Proyecto add(Proyecto data);
    //Funcion de obtener un proyecto por ID

    Proyecto getByID(String id);
    //Funcion que obtiene un proyecto por su nombre

    boolean getByName(String Name);
//Funcion que obtiene todos los proyectos de la coleccion de proyectos

    Collection<Proyecto> getAll();
//Funcion que actualiza un proyecto existente en una lista de proyectos con uno nuevo

    Proyecto update(Proyecto data);
//Funcion de eliminar un proyecto por su nombre

    boolean delete(String nombreProyecto);
    //Funcion que guarda los datos en el archivo del Repo

    boolean save();

}
