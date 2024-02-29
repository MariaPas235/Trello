package Model.entity;

import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.Matcher;



public abstract class Persona {
    protected String nombre;
    protected String usuario;
    protected String contrasena;
    protected String mail;

    public Persona(String nombre, String usuario, String contrasena, String mail) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.mail = mail;
    }

    public Persona() {
        this("","","","");
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

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public boolean validarCorreo(String mail){
        boolean result = false;
        Pattern mailPattern = Pattern.compile("[A-Za-z0-9]+@+(gmail|outlook)\\.(com|es)");
        Matcher mailMatcher = mailPattern.matcher(mail);
        System.out.println("El mail es: " + mailMatcher.matches());
        if (mailMatcher.matches()) {
            System.out.println("El mail es correcto ");
        } else {
            System.out.println("El mail es incorrecto, escribelo de nuevo");
        }
        return result;
    }

    public boolean validarContrasena(String contrasena){
        boolean result = false;
        Pattern contrasenaPattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!.#_()%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        Matcher contrasenaMatcher = contrasenaPattern.matcher(contrasena);
        if (contrasenaMatcher.matches()) {
            System.out.println("La contraseña es correcta");
        } else {
            System.out.println("La contraseña es incorrecta, intentelo de nuevo");
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(nombre, persona.nombre) && Objects.equals(usuario, persona.usuario) && Objects.equals(contrasena, persona.contrasena) && Objects.equals(mail, persona.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contrasena);
    }

    @Override
    public String toString() {
        return "Persona[" + nombre + usuario + contrasena + mail + "]";
    }
}
