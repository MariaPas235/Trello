package Model.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Proyecto {
    private String nombre;
    private String descripcion;
    private LocalDate fechaCreacion;
    private String estado;

    public Proyecto(String nombre, String descripcion, LocalDate fechaCreacion, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public Proyecto() {
        this("", "", LocalDate.now(), "");
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
    public boolean equals(Object obj) {
        boolean isEquals;
        if (this == obj) {
            isEquals = true;
        } else if ((obj == null || getClass() != obj.getClass())){
            isEquals = false;
        } else {
            Proyecto proyecto = (Proyecto) obj;
            isEquals = Objects.equals(nombre, proyecto.nombre);
        }
        return isEquals;
    }

    @Override
    public String toString() {
        return "proyecto[" + nombre +  descripcion + fechaCreacion + estado + "]";
    }
}

