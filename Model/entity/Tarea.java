package Model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


public class Tarea implements Serializable {
    private String nombre;
    private String personaAsignada;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaLimite;

    private LocalDateTime fechaActual;
    private String comentario;

    private EstadoTarea estadoTarea;
    public Tarea(String nombre, String personaAsignada, String descripcion, LocalDate fechaInicio, LocalDate fechaLimite, LocalDateTime fechaActual,String comentario, EstadoTarea estadoTarea) {
        this.nombre = nombre;
        this.personaAsignada = personaAsignada;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaLimite = fechaLimite;
        this.fechaActual = fechaActual;
        this.comentario= comentario;
        this.estadoTarea= estadoTarea;
    }

    public Tarea() {
        this("", "", "", LocalDate.now(), LocalDate.now(), LocalDateTime.now(),"",EstadoTarea.SININICIAR);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPersonaAsignada() {
        return personaAsignada;
    }

    public void setPersonaAsignada(String personaAsignada) {
        this.personaAsignada = personaAsignada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public LocalDateTime getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(LocalDateTime fechaActual) {
        this.fechaActual = fechaActual;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public EstadoTarea getEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(EstadoTarea estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals;
        if (this == obj) {
            isEquals = true;
        } else if ((obj == null || getClass() != obj.getClass())){
            isEquals = false;
        } else {
            Tarea tarea = (Tarea) obj;
            isEquals = Objects.equals(nombre, tarea.nombre);
        }
        return isEquals;
    }

    @Override
    public String toString() {
        return "tarea[" + nombre + personaAsignada + descripcion + fechaInicio + fechaLimite + fechaActual + comentario +"]";
    }

    public String getEstado() {
        return null;
    }
}


