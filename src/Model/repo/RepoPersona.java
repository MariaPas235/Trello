package Model.repo;

import Model.entity.Persona;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RepoPersona extends library<Persona,String> {
    private final static String FILENAME= "DatosUsuario.txt";
    private static RepoPersona _instance;
    private Set<Persona> personas;
    private RepoPersona(){
        personas= new HashSet<>();
    }
    public static RepoPersona get_instance(){
        if(_instance==null){
            _instance = (RepoPersona)load(FILENAME);
            if(_instance==null){
                _instance=new RepoPersona();
            }
        }
        return _instance;
    }

    @Override
    public Persona add(Persona data) {
        Persona result = null;
        if(personas.add(data)){
            result=data;
        }
        return result;
    }

    @Override
    public Persona getByID(String id) {
        Persona result = null;
        for (Persona persona:personas){
            if (persona.getUsuario().equals(id)){
                result = persona;
                break;
            }
        }
        return result;
    }

    @Override
    public Collection<Persona> getAll() {
        return personas;
    }

    @Override
    public Persona update(Persona data) {
        Persona result = null;
        result = getByID((data.getUsuario()));
        if(result!=null){
            personas.remove(result);
            personas.add(data);
            result = data;
        }
        save();
        return result;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
    public boolean save(){return  save(FILENAME);}
}
