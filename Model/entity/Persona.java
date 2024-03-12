package Model.entity;

import Model.repo.RepoPersona;
import serializator.Security;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//La clase persona implementa el serializable
public class Persona implements Serializable {
    //Atributos de la clase
    protected String nombre;
    protected String usuario;
    protected String contrasena;
    protected String mail;
    //Se declara la variable estatica rp de tipo RepoPersona y asigna a rp a la unica instancia de
    // la clase RepoPersona y get_instance devuelve la unica instancia de la clase RepoPersona
    static RepoPersona rp = RepoPersona.get_instance();

    //Constructor con los atributos de persona con la excepcion de la contraseña
    public Persona(String nombre, String usuario, String contrasena, String mail) {
        this.nombre = nombre;
        this.usuario = usuario;
        try {
            setContrasena(contrasena);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        this.mail = mail;
    }

    //Contructor vacio que inicializa en string vacio los atributos excepto el usuario
    public Persona(String usuario) {
        this("", usuario, "", "");
    }

    //Getters y setters de cada atributo de la clase
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) throws NoSuchAlgorithmException {
        this.contrasena = Security.hashPassword(contrasena);
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    //Funcion para comprobar el correo y validarlo con una expresion regular que contiene un requisito para hacer un correo

    /**
     * Funcion para validar el mail del usuario con ciertos requisitos
     *
     * @param mail es el mail del usuario que se va a validar
     * @return devuelve el resultado si el mail es valido y no esta en el repo o falso si cumple lo contrario
     * Se crea un Pattern con una expresion regular con el requisito para validar un mail
     * Se crea un Matcher para comparar el mail a validar con la expresion regular del Pattern
     * Si en la comprobacion el mail cumple la validacion mostrara un mensaje de que esta bien escrito
     * Si no cumple la validacion tras la comprobacion dara un mensaje de que esta mal escrito
     * Si el mail no existe en el repositorio de las personas, da un mensaje de que es correcto
     * Si existe el mail en el repo, dara un mensaje de que se escriba de nuevo el mail
     */
    public static boolean validarCorreo(String mail) {
        boolean result = false;
        Pattern mailPattern = Pattern.compile("[A-Za-z0-9]+@+(gmail|outlook|hotmail)\\.(com|es)");
        Matcher mailMatcher = mailPattern.matcher(mail);
        if (mailMatcher.matches()) {
            System.out.println("El mail esta bien escrito");
        } else {
            System.out.println("El mail está mal escrito");
        }
        if (!rp.getByEmail(mail)) {
            System.out.println("El mail es correcto ");
            result = true;
        } else {
            System.out.println("El mail es incorrecto, escribelo de nuevo");
        }
        return result;
    }

    //Funcion que valida usuarios para que al guardarse en el repo no se repitan

    /**
     * Funcion que valida usuarios
     *
     * @param usuario el usuario que se le va a hacer una validacion
     * @return devuelve el resultado de la comparacion si el usuario existe o no en el repo
     */
    public static boolean validarUsuario(String usuario) {
        boolean result = false;
        rp = RepoPersona.get_instance();
        if (!rp.getByUserName(usuario)) {
            System.out.println("El usuario es correcto ");
            result = true;
        } else {
            System.out.println("El usuario ya existe");
        }
        return result;
    }
    //Funcion para validar la contraseña del usuario con una expresion regular

    /**
     * Funcion para validar la contraseña del usuario con una expresion regular
     *
     * @param contrasena la contraseña que se va a validar con el patron
     * @return devuelve si la contraseña cumple el patron correcto
     */
    public static boolean validarContrasena(String contrasena) {
        boolean result = false;
        Pattern contrasenaPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!.#_()%*?&])[A-Za-z\\d@$!.#_()%*?&]{8,}$");
        Matcher contrasenaMatcher = contrasenaPattern.matcher(contrasena);
        if (contrasenaMatcher.matches()) {
            System.out.println("La contraseña es correcta");
            result = true;
        } else {
            System.out.println("La contraseña es incorrecta, intentelo de nuevo");
        }
        return result;
    }
    //Equals de la clase Persona

    /**
     * Equals de la clase que comprueba si dos objetos (personas) son iguales
     *
     * @param obj el objeto a analizar si es igual al objeto actual
     * @return devuelve el resultado de la comparacion
     * Si el objeto que se pasa (actual) es igual a uno anterior devuelve true
     * Si el objeto anterior es nulo o las clases del objeto actual y dell anterior no son iguales devuelve false
     * Por ultimo si no es nulo y de la misma clase que el objeto actual se hace un casting para un analisis mas detallado
     * Devolvera true o false si la comparacion entre el nombre, usuario y el mail de la persona actual y una anterior es igual o distinta
     */
    @Override
    public boolean equals(Object obj) {
        boolean isEquals;
        if (this == obj) {
            isEquals = true;
        } else if (obj == null || getClass() != obj.getClass()) {
            isEquals = false;
        } else {
            Persona persona = (Persona) obj;
            return Objects.equals(usuario, persona.usuario) || Objects.equals(mail, persona.mail);
        }
        return isEquals;
    }

    //Funcion que compara las credenciales del usuario para confirmar que son correctas
    public boolean equalsCredential(Object obj) {
        boolean isEquals;
        if (this == obj) {
            isEquals = true;
        } else if (obj == null || getClass() != obj.getClass()) {
            isEquals = false;
        } else {
            Persona persona = (Persona) obj;
            return Objects.equals(usuario, persona.usuario) && Objects.equals(contrasena, persona.contrasena);
        }
        return isEquals;
    }
    //hashCode de la clase

    /**
     * hashCode de la clase
     *
     * @return devuelve un hash al usuario y a su contraseña
     */
    @Override
    public int hashCode() {
        return Objects.hash(usuario, contrasena);
    }

    //toString de la clase

    /**
     * toString de la clase
     *
     * @return devuelve los atributos de persona y se imprimiran por pantalla al hacer el llamamiento de toString
     * en x clase
     */
    @Override
    public String toString() {
        return "Persona[" + nombre + usuario + mail + "]";
    }

}