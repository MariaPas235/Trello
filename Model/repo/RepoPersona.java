package Model.repo;

import Interface.IRepoPersona;
import Model.entity.Persona;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import static serializator.Security.hashPassword;

//La clase implementa los metodos de la interfaz IRepoPersona
//La clase hereda atributos de la clase abstracta Library
public class RepoPersona extends library<Persona,String> implements IRepoPersona {
    private final static String FILENAME= "Users.bin";
    private static RepoPersona _instance;
    private Set<Persona> personas;
    //Constructor que crea una instancia de persona y crea una coleccion para almacenar personas
    private RepoPersona(){
        personas= new HashSet<>();
    }
    //Funcion estática que coge una instancia de RepoPersona
    /**
     * Funcion estática que coge una instancia de RepoPersona
     * @return devuelve la instancia creada o recogida del archivo
     * Se asegura si no hay una instancia previa e intenta cargar del archivo
     * Si no hay instancia, se crea una nueva
     */
    public static RepoPersona get_instance(){
        if(_instance==null){
            _instance = (RepoPersona)load(FILENAME);
            if(_instance==null){
                _instance=new RepoPersona();
            }
        }
        return _instance;
    }
//Funcion de añadir los datos de una persona (usuario)

    /**
     * Funcion de añadir los datos de una persona (usuario)
     * @param data los datos que se van a añadir
     * @return el resultado de que se ha añadido los datos al Repo
     */
    @Override
    public Persona add(Persona data) {
        Persona result = null;
        if(personas.add(data)){
            result=data;
        }
        save();
        return result;
    }
//Funcion de obtener una persona (usuario) por ID

    /**
     * Funcion de obtener una persona (usuario) por ID
     * @param id del usuario a buscar
     * @return la persona buscada por su ID
     */
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
//Funcion que obtiene todos las personas de la coleccion de las personas

    /**
     * Funcion que obtiene todos las personas de la coleccion de las personas
     * @return todas las personas de la coleccion de personas
     */
    @Override
    public Collection<Persona> getAll() {
        return personas;
    }
//Funcion que actualiza una persona existente en una lista de personas con uno nuevo

    /**
     * Funcion que actualiza una persona existente en una lista de proyectos con uno nuevo
     * @param data los datos de la persona a actualizar
     * @return resultado de la actualizacion de los datos
     */
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
//Funcion de eliminar una persona por su nombre

    /**
     * Funcion de eliminar una persona por su nombre
     * @param nombrePersona que se va a buscar para eliminarla
     * @return el resultado al eliminar a la persona
     */
    @Override
    public boolean delete(String nombrePersona) {
        boolean result = false;
        Iterator<Persona> iterator = personas.iterator();
        while (iterator.hasNext()) {
            Persona persona = iterator.next();
            if (persona.getNombre().equals(nombrePersona)) {
                iterator.remove();
                result = true;
            }
        }
        save();
        return result;
    }
    public Persona login(Persona pl) {
        Persona result=null;
        for(Persona p : personas){
            if(p.equalsCredential(pl)){
                result=p;
                break;
            }
        }
        return result;
    }

    //Funcion que busca una persona por su usuario
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
    //Funcion que busca el usuario por su mail
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
    //Funcion que comprueba la contraseña del usuario
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
    //Funcion que guarda los datos en el archivo del Repo
    public boolean save () {
            return save(FILENAME);
        }
    }
