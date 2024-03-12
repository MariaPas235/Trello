package Model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

//La clase tarea implementa el serializable
public class Tarea implements Serializable {
    //Atrubtos de la clase tarea
    private String nombre;
    private String personaAsignada;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaLimite;

    private LocalDateTime fechaActual;
    private String comentario;

    private EstadoTarea estadoTarea;

    //Constructor de tarea full equip con todos los atributos
    public Tarea(String nombre, String personaAsignada, String descripcion, LocalDate fechaInicio, LocalDate fechaLimite, LocalDateTime fechaActual, String comentario, EstadoTarea estadoTarea) {
        this.nombre = nombre;
        this.personaAsignada = personaAsignada;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaLimite = fechaLimite;
        this.fechaActual = fechaActual;
        this.comentario = comentario;
        this.estadoTarea = estadoTarea;
    }

    //Constructor que inicializa los atributos a 0 y el estado en sin iniciar
    public Tarea() {
        this("", "", "", LocalDate.now(), LocalDate.now(), LocalDateTime.now(), "", EstadoTarea.SININICIAR);
    }

    //Getters y setters de los atributos
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

    //El equals de la clase

    /**
     * Equals de la clase que comprueba si dos objetos (tareas) son iguales
     *
     * @param obj el objeto a analizar si es igual al objeto actual
     * @return devuelve el resultado de la comparacion
     * Si el objeto que se pasa (actual) es igual a uno anterior devuelve true
     * Si el objeto anterior es nulo o las clases del objeto actual y dell anterior no son iguales devuelve false
     * Por ultimo si no es nulo y de la misma clase que el objeto actual se hace un casting para un analisis mas detallado
     * Devolvera true o false si la comparacion entre el nombre de la tarea actual y una anterior es igual o distinta
     */
    @Override
    public boolean equals(Object obj) {
        boolean isEquals;
        if (this == obj) {
            isEquals = true;
        } else if ((obj == null || getClass() != obj.getClass())) {
            isEquals = false;
        } else {
            Tarea tarea = (Tarea) obj;
            isEquals = Objects.equals(nombre, tarea.nombre);
        }
        return isEquals;
    }

    //toString de la clase

    /**
     * toString de la clase
     *
     * @return devuelve todos los atributos de tarea que se imprimiran por pantalla al hacer llamamiento al toString de la clase
     */
    @Override
    public String toString() {
        return "tarea[" + nombre + personaAsignada + descripcion + fechaInicio + fechaLimite + fechaActual + comentario + "]";
    }


}


