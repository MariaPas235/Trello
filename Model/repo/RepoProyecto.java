package Model.repo;

import Model.entity.proyecto;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RepoProyecto extends Library_proyect <proyecto,String> {
    private final static String FILENAME = "Proyects.bin";
    private static RepoProyecto _instance;
    private Set<proyecto> proyectos;

    private RepoProyecto() {
        proyectos = new HashSet<>();
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
    public proyecto add(proyecto data) {
        proyecto result = null;
        if(proyectos.add(data)){
            result=data;
        }
        return result;
    }
    @Override
    public proyecto getByID(String id) {
        proyecto result = null;
        for (proyecto proyecto:proyectos){
            if (proyecto.getNombre().equals(id)){
                result = proyecto;
                break;
            }
        }
        return result;
    }

    @Override
    public Collection<proyecto> getAll() {
        return proyectos;
    }

    @Override
    public proyecto update(proyecto data) {
        proyecto result = null;
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
        for (proyecto proyecto:proyectos){
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