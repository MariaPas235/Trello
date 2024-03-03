package Model.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class proyecto {
    private String nombre;
    private String descripcion;
    private LocalDate fechaCreacion;
    private String estado;
    private String creador;
    private List<Colaborador> Colaboradores= new ArrayList<>();
    public proyecto(String nombre, String descripcion, LocalDate fechaCreacion, String estado, String creador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.creador=creador;
    }

    public proyecto() {
        this("", "", LocalDate.now(), "","");
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

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        proyecto proyecto = (proyecto) o;
        return Objects.equals(nombre, proyecto.nombre);
    }

    @Override
    public String toString() {
        return "proyecto{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", estado='" + estado + '\'' +
                ", creador='" + creador + '\'' +
                '}';
    }
}

