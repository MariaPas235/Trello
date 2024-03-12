package Model.repo;

import Interface.IRepoProyecto;
import Model.entity.Proyecto;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

//La clase implementa los metodos de la interfaz IRepoProyecto y el serializable
//La clase hereda atributos de la clase abstracta LibraryProyect
public class RepoProyecto extends LibraryProyect<Proyecto, String> implements IRepoProyecto, Serializable {
    //Atributos de la clase RepoProyecto
    private final static String FILENAME = "Proyects.bin";
    private static RepoProyecto _instance;
    private Set<Proyecto> proyectos;
    //Constructor que crea una instancia de proyecto y crea una coleccion para almacenar proyectos

    private RepoProyecto() {
        proyectos = new HashSet<>();
    }
//Funcion estática que coge una instancia de RepoProyecto

    /**
     * Funcion estática que coge una instancia de RepoProyecto
     *
     * @return devuelve la instancia creada o recogida del archivo
     * Se asegura si no hay una instancia previa e intenta cargar del archivo
     * Si no hay instancia, se crea una nueva
     */
    public static RepoProyecto get_instance() {
        if (_instance == null) {
            _instance = (RepoProyecto) load(FILENAME);
            if (_instance == null) {
                _instance = new RepoProyecto();
            }
        }
        return _instance;
    }
//Funcion de añadir los datos de un proyecto

    /**
     * Funcion de añadir los datos de un proyecto
     *
     * @param data los datos que se van a añadir
     * @return el resultado de que se ha añadido los datos al Repo
     */
    @Override
    public Proyecto add(Proyecto data) {
        Proyecto result = null;
        if (proyectos.add(data)) {
            result = data;
        }
        save();
        return result;
    }
    //Funcion de obtener un proyecto por ID

    /**
     * Funcion de obtener un proyecto por ID
     *
     * @param id del usuario a buscar
     * @return el proyecto buscado por su ID
     */
    @Override
    public Proyecto getByID(String id) {
        Proyecto result = null;
        for (Proyecto proyecto : proyectos) {
            if (proyecto.getNombre().equals(id)) {
                result = proyecto;
                break;
            }
        }
        return result;
    }
    //Funcion que obtiene un proyecto por su nombre

    /**
     * Funcion que obtiene un proyecto por su nombre
     *
     * @param Name del proyecto a buscar
     * @return el resultado
     */
    @Override
    public boolean getByName(String Name) {
        boolean result = false;
        for (Proyecto proyecto : proyectos) {
            if (proyecto.getNombre().equals(Name)) {
                result = true;
            }
        }
        return result;
    }
//Funcion que obtiene todos los proyectos de la coleccion de proyectos

    /**
     * Funcion que obtiene todos los proyectos de la coleccion de proyectos
     *
     * @return todos los proyectos de la coleccion de proyectos
     */
    @Override
    public Collection<Proyecto> getAll() {
        return proyectos;
    }
//Funcion que actualiza un proyecto existente en una lista de proyectos con uno nuevo

    /**
     * Funcion que actualiza un proyecto existente en una lista de proyectos con uno nuevo
     *
     * @param data los datos del proyecto a actualizar
     * @return resultado de la actualizacion de los datos
     */
    @Override
    public Proyecto update(Proyecto data) {
        Proyecto result = null;
        result = getByID((data.getNombre()));
        if (result != null) {
            proyectos.remove(result);
            proyectos.add(data);
            result = data;
        }
        save();
        return result;
    }
//Funcion de eliminar un proyecto por su nombre

    /**
     * Funcion de eliminar un proyecto por su nombre
     *
     * @param nombreProyecto que se va a borrar
     * @return el resultado al eliminar el proyecto
     */
    @Override
    public boolean delete(String nombreProyecto) {
        boolean result = false;
        for (Proyecto proyecto : proyectos) {
            if (proyecto.getNombre().equals(nombreProyecto)) {
                proyectos.remove(proyecto);
                result = true;
            }
        }
        return result;
    }

    //Funcion que guarda los datos en el archivo del Repo
    public boolean save() {
        return save(FILENAME);
    }
}