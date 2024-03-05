package Model.repo;
import Model.entity.proyecto;
import Model.entity.tarea;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RepoTarea extends Library_proyect<tarea,String>{
    private final static String FILENAME = "Tasks.bin";
    private static RepoTarea _instance;
    private Set<tarea> tareas;

    private RepoTarea() {
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
    public tarea add(tarea data) {
        tarea result = null;
        if(tareas.add(data)){
            result=data;
        }
        return result;
    }
    @Override
    public tarea getByID(String id) {
        tarea result = null;
        for (tarea tarea:tareas){
            if (tarea.getNombre().equals(id)){
                result = tarea;
                break;
            }
        }
        return result;
    }

    @Override
    public Collection<tarea> getAll() {
        return tareas;
    }

    @Override
    public tarea update(tarea data) {
        tarea result = null;
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
        for (tarea tarea:tareas){
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