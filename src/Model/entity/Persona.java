package Model.entity;

import java.util.Objects;

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
