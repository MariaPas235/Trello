package Model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


public class tarea {
    private String nombre;
    private String personaAsignada;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaLimite;

    private LocalDateTime fechaActual;


    public tarea(String nombre, String personaAsignada, String descripcion, LocalDate fechaInicio, LocalDate fechaLimite, LocalDateTime fechaActual) {
        this.nombre = nombre;
        this.personaAsignada = personaAsignada;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaLimite = fechaLimite;
        this.fechaActual = fechaActual;
    }

    public tarea() {
        this("", "", "", LocalDate.now(), LocalDate.now(), LocalDateTime.now());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        tarea tarea = (tarea) o;
        return Objects.equals(nombre, tarea.nombre) && Objects.equals(descripcion, tarea.descripcion) && Objects.equals(fechaInicio, tarea.fechaInicio) && Objects.equals(fechaLimite, tarea.fechaLimite);
    }

    @Override
    public String toString() {
        return "tarea[" + nombre + personaAsignada + descripcion + fechaInicio + fechaLimite + fechaActual + "]";
    }
}


