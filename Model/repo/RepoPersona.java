package Model.repo;

import Model.entity.Persona;

import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static serializator.Security.hashPassword;

public class RepoPersona extends library<Persona,String> {
    private final static String FILENAME= "Users.bin";
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
    public boolean delete(String nombrePersona) {
        boolean result=false;
        for (Persona persona:personas){
                if (persona.getNombre().equals(nombrePersona)){
                personas.remove(persona);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean getByUserName(String username) {
        boolean result = false;
        for (Persona persona:personas){
            if (persona.getUsuario().equals(username)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean getByEmail(String mail) {
        boolean result = false;
        for (Persona persona:personas){
            if (persona.getMail().equals(mail)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean getBypassword(String password) {
        boolean result = false;
        String hashedInputPassword = null;
        try {
            hashedInputPassword = hashPassword(password);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: " + e.getMessage());
        }
        for (Persona persona : personas) {
            if (persona.getContrasena().equals(hashedInputPassword)) {
                result = true;
            }
        }
        return result;
    }

    public boolean save () {
            return save(FILENAME);
        }
    }
