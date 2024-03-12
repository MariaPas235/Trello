package Model.entity;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

//La clase proyecto implementa el serializable
public class Proyecto implements Serializable {
    //Atributos de la clase
    private String nombre;
    private String descripcion;
    private LocalDate fechaCreacion;
    private String Jefe;
    private ArrayList<Colaborador> colaboradores;
    private ArrayList<Tarea> tareas;

    //Constructor full equip de la clase
    public Proyecto(String nombre, String descripcion, LocalDate fechaCreacion, String jefe, ArrayList<Colaborador> colaboradores, ArrayList<Tarea> tareas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.Jefe = jefe;
        this.colaboradores = colaboradores;
        this.tareas = tareas;
    }

    //Constructor vacio que inicializa los atributos a 0
    public Proyecto() {
        this("", "", LocalDate.now(), "", new ArrayList<>(), new ArrayList<>());
    }

    //Getters y setters de los atributos
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

    public String getJefe() {
        return Jefe;
    }

    public void setJefe(String jefe) {
        Jefe = jefe;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public ArrayList<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(ArrayList<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }

//Equals de la clase Proyecto

    /**
     * Equals de la clase que comprueba si dos objetos (proyectos) son iguales
     *
     * @param obj el objeto a analizar si es igual al objeto actual
     * @return devuelve el resultado de la comparacion
     * Si el objeto que se pasa (actual) es igual a uno anterior devuelve true
     * Si el objeto anterior es nulo o las clases del objeto actual y dell anterior no son iguales devuelve false
     * Por ultimo si no es nulo y de la misma clase que el objeto actual se hace un casting para un analisis mas detallado
     * Devolvera true o false si la comparacion del nombre del proyecto actual y uno anterior es igual o distinto
     */
    @Override
    public boolean equals(Object obj) {
        boolean isEquals;
        if (this == obj) {
            isEquals = true;
        } else if ((obj == null || getClass() != obj.getClass())) {
            isEquals = false;
        } else {
            Proyecto proyecto = (Proyecto) obj;
            isEquals = Objects.equals(nombre, proyecto.nombre);
        }
        return isEquals;
    }

    //toString de la clase

    /**
     * toString de la clase
     *
     * @return devuelve los atributos de persona y se imprimiran por pantalla al hacer el llamamiento de toString
     * en x clase
     */
    @Override
    public String toString() {
        return "proyecto[" + nombre + descripcion + LocalDate.now() + tareas + colaboradores + "]";
    }

    //Funcion que verifica los colaboradores de un proyecto
    public boolean esColaborador(String usuario) {
        boolean result = false;
        ArrayList<Colaborador> colaboradores = this.getColaboradores();

        // Verificar si alguno de los colaboradores tiene el mismo nombre de usuario
        for (Colaborador colaborador : colaboradores) {
            if (colaborador.getUsuario().equals(usuario)) {
                result = true;
            }
        }

        return result;
    }
}