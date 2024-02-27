package Model.entity;

import java.awt.*;
import java.time.LocalDate;
import java.util.Objects;

public class proyecto {
    private String nombre;
    private String descripcion;
    private LocalDate fechaCreacion;
    private String estado;

    public proyecto(String nombre, String descripcion, LocalDate fechaCreacion, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public proyecto() {
        //this("","",0,"");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        proyecto proyecto = (proyecto) o;
        return Objects.equals(nombre, proyecto.nombre) && Objects.equals(descripcion, proyecto.descripcion) && Objects.equals(fechaCreacion, proyecto.fechaCreacion) && Objects.equals(estado, proyecto.estado);
    }

    @Override
    public String toString() {
        return "proyecto[" + nombre  + descripcion + fechaCreacion + estado + "]";
    }
}
