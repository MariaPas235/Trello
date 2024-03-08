package Model.repo;

import IO.Teclado;
import Model.entity.Proyecto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RepoProyecto extends Library_proyect <Proyecto,String> implements Serializable {
    private final static String FILENAME = "Proyects.bin";
    private static RepoProyecto _instance;
    private ArrayList<Proyecto> proyectos;

    private RepoProyecto() {
        proyectos = new ArrayList<>();
    }

    public static RepoProyecto get_instance() {
        if (_instance == null) {
            _instance = (RepoProyecto) load(FILENAME);
            if (_instance == null) {
                _instance = new RepoProyecto();
            }
        }
        return _instance;
    }

    @Override
    public Proyecto add(Proyecto data) {
        Proyecto result = null;
        if(proyectos.add(data)){
            result=data;
        }
        return result;
    }
    @Override
    public Proyecto getByID(String id) {
        Proyecto result = null;
        for (Proyecto proyecto:proyectos){
            if (proyecto.getNombre().equals(id)){
                result = proyecto;
                break;
            }
        }
        return result;
    }
    public static Proyecto listarProyectoporNombre(ArrayList<Proyecto> proyectos) {
        String nombreProyecto;
        Proyecto proyectoEncontrado = null;
        do {
            nombreProyecto = Teclado.leeString("Introduce el nombre del proyecto a buscar o pulse 'salir': ");
            for (Proyecto proyecto : proyectos) {
                if (proyecto.getNombre().equalsIgnoreCase(nombreProyecto)) {
                    proyectoEncontrado = proyecto; // Asigna el proyecto encontrado
                }
            }
            if (proyectoEncontrado == null) {
                System.out.println("No se encontró ningún proyecto con ese nombre.");
            }
        } while (!nombreProyecto.equalsIgnoreCase("salir") && proyectoEncontrado == null);
        return proyectoEncontrado; // Devuelve el proyecto encontrado o null si no se encontró ninguno
    }
    @Override
    public boolean getByName(String Name) {
        boolean result = false;
        for (Proyecto proyecto:proyectos){
            if (proyecto.getNombre().equals(Name)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public Collection<Proyecto> getAll() {
        return proyectos;
    }

    @Override
    public Proyecto update(Proyecto data) {
        Proyecto result = null;
        result = getByID((data.getNombre()));
        if(result!=null){
            proyectos.remove(result);
            proyectos.add(data);
            result = data;
        }
        save();
        return result;
    }

    @Override
    public boolean delete(String nombreProyecto) {
        boolean result=false;
        for (Proyecto proyecto:proyectos){
            if (proyecto.getNombre().equals(nombreProyecto)){
                proyectos.remove(proyecto);
                result = true;
            }
        }
        return result;
    }
    public boolean save () {
        return save(FILENAME);
    }
}