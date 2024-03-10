package Model.entity;

import IO.Teclado;
import view.GUI;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    //Constructor de tarea con todos los atributos
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
    //Constructor vacio que inicializa los atributos a 0 y el estado en sin iniciar
    public Tarea() {
        this("", "", "", LocalDate.now(), LocalDate.now(), LocalDateTime.now(),"",EstadoTarea.SININICIAR);
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
//Equals de la clase
    /**
     * Equals de la clase que comprueba si dos objetos (tareas) son iguales
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
        } else if ((obj == null || getClass() != obj.getClass())){
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
     * @return devuelve todos los atributos de tarea que se imprimiran por pantalla al hacer llamamiento al toString de la clase
     */
    @Override
    public String toString() {
        return "tarea[" + nombre + personaAsignada + descripcion + fechaInicio + fechaLimite + fechaActual + comentario +"]";
    }
//Funcion de añadir tareas a un arrayList de tareas

    /**
     * Funcion de añadir tareas a un arrayList de tareas
     * @return devuelve la lista de tareas añadidas al arrayList
     *Se crea una lista vacía para almacenar las tareas.
     *Se inicia un bucle que continuará hasta que el usuario decida no añadir más tareas.
     *Dentro del bucle, se crea una nueva tarea vacía.
     *Se pide al usuario que introduzca un nombre y una descripción para la tarea.
     *Se establecen la fecha actual, la fecha de inicio y la fecha límite de la tarea. Por defecto, estas fechas están vacías.
     *Se añade la tarea a la lista.
     *Se pregunta al usuario si desea añadir otra tarea a la lista. Si el usuario responde con ‘s’ o ‘S’, se añade otra tarea.
     *Si el usuario responde con ‘n’ o ‘N’, se termina el bucle y no se añaden más tareas.
     */
    public static ArrayList<Tarea> añadirTareas() {
        ArrayList<Tarea> tarea = new ArrayList<>();
        boolean auxSN = true;
        while (auxSN) {
            Tarea tarea1 = new Tarea();
            tarea1.setNombre(Teclado.leeString("Introduce el nombre de la tarea: "));
            tarea1.setDescripcion(Teclado.leeString("Introduce una descripcion: "));
            tarea1.setFechaActual(LocalDateTime.now());
            tarea1.setFechaInicio(LocalDate.now());
            tarea1.setFechaLimite(GUI.añadirFechaFin());
            tarea.add(tarea1);
            String respuesta = Teclado.leeString("Quieres añadir otra tarea (s/n)? ");
            auxSN = respuesta.equalsIgnoreCase("s");
        }
        return tarea;
    }
}


