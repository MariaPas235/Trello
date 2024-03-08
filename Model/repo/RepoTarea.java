package Model.repo;
import Model.entity.Proyecto;
import Model.entity.Tarea;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RepoTarea extends Library_proyect<Tarea,String> implements Serializable {
    private final static String FILENAME = "Tasks.bin";
    private static RepoTarea _instance;
    private Set<Tarea> tareas;

    public RepoTarea() {
        tareas = new HashSet<>();
    }

    public static RepoTarea get_instance() {
        if (_instance == null) {
            _instance = (RepoTarea) load(FILENAME);
            if (_instance == null) {
                _instance = new RepoTarea();
            }
        }
        return _instance;
    }
    @Override
    public Tarea add(Tarea data) {
        Tarea result = null;
        if(tareas.add(data)){
            result=data;
        }
        return result;
    }
    @Override
    public Tarea getByID(String id) {
        Tarea result = null;
        for (Tarea tarea:tareas){
            if (tarea.getNombre().equals(id)){
                result = tarea;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean getByName(String Name) {
        boolean result = false;
        for (Tarea tarea:tareas){
            if (tarea.getNombre().equals(Name)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public Collection<Tarea> getAll() {return tareas;}

    @Override
    public Tarea update(Tarea data) {
        Tarea result = null;
        result = getByID((data.getNombre()));
        if(result!=null){
            tareas.remove(result);
            tareas.add(data);
            result = data;
        }
        save();
        return result;
    }

    @Override
    public boolean delete(String nombreTarea) {
        boolean result=false;
        for (Tarea tarea:tareas){
            if (tarea.getNombre().equals(nombreTarea)){
                tareas.remove(tarea);
                result = true;
            }
        }
        return result;
    }
    public boolean save () {
        return save(FILENAME);
    }
}