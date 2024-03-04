package Model.entity;

import Model.repo.RepoPersona;
import serializator.Security;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Persona implements Serializable {
    protected String nombre;
    protected String usuario;
    protected String contrasena;
    protected String mail;
    static RepoPersona rp = RepoPersona.get_instance();
    public Persona(String nombre, String usuario, String contrasena, String mail) throws NoSuchAlgorithmException {
        this.nombre = nombre;
        this.usuario = usuario;
        setContrasena(contrasena);
        this.mail = mail;
    }

    public Persona(String usuario) throws NoSuchAlgorithmException {
        this("", usuario, "", "");
    }

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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Persona persona = (Persona) object;
        return Objects.equals(usuario, persona.usuario) || Objects.equals(mail, persona.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, mail);
    }

    @Override
    public String toString() {
        return "Persona[" + nombre + usuario + contrasena + mail + "]";
    }
}