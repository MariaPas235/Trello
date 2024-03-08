package Model.repo;

import Interface.IRepoProyecto;
import Model.entity.Proyecto;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RepoProyecto extends Library_proyect <Proyecto,String> implements IRepoProyecto,Serializable {
    private final static String FILENAME = "Proyects.bin";
    private static RepoProyecto _instance;
    private Set<Proyecto> proyectos;

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