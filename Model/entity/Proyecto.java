package Model.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Proyecto {
    private String nombre;
    private String descripcion;
    private LocalDate fechaCreacion;
    private String Jefe;
    private ArrayList<Persona> colaboradores;
    private ArrayList<Tarea> tareas;

    public Proyecto(String nombre, String descripcion, LocalDate fechaCreacion,String jefe, ArrayList<Persona> colaboradores, ArrayList<Tarea> tareas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.Jefe = jefe;
        this.colaboradores = colaboradores;
        this.tareas = tareas;
    }

    public Proyecto() {
        this("","", LocalDate.now(),"",new ArrayList<>(), new ArrayList<>());
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

    public String getJefe() {
        return Jefe;
    }

    public void setJefe(String jefe) {
        Jefe = jefe;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public ArrayList<Persona> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(ArrayList<Persona> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }

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

    @Override
    public String toString() {
        return "proyecto[" + nombre + descripcion + LocalDate.now() + tareas + colaboradores +"]";
    }

    private  static final void jefeProyecto(){

    }
}
