package Model.entity;

import IO.Teclado;
import Interface.IColaborador;
import view.GUI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static Model.entity.EstadoTarea.*;

public class Colaborador extends Persona implements IColaborador, Serializable {
    private List<Tarea> tareasAsignadas;
    public Colaborador(){
        super("","","","");
        tareasAsignadas = new ArrayList<>();
    }
    //Funciones que tiene un colaborador de un proyecto asignado
    view.GUI GUI = new GUI();

    //Funcion de actualizar el estado de una tarea
    @Override
    public EstadoTarea actualizarEstadoTarea(String cambiarEstado, Tarea tarea) {
        switch (EstadoTarea.fromEstado(cambiarEstado)){
            case SININICIAR:
                System.out.println("El estado de la tarea " +tarea.getNombre()+ "es: " +SININICIAR);
                break;
            case PENDIENTE:
                System.out.println("El estado de la tarea " +tarea.getNombre()+ "es: " +PENDIENTE);
                break;
            case ACABADA:
                System.out.println("El estado de la tarea " +tarea.getNombre()+ "es: " +ACABADA);
                break;
            default:
                System.out.println("Error de estado");
        }
        return EstadoTarea.fromEstado(tarea.getEstado());
    }
//Metodo para añadir comentarios a la tarea
    @Override
    public String anadirComentario(Tarea tarea, Proyecto proyecto, String comentario) {
        comentario= Teclado.leeString("Escriba un comentario: ");
        tarea.setComentario(comentario);
        return tarea.getComentario();
    }

    public void asignarTarea(Tarea tarea) {
        // Verificar si la tarea no ha sido asignada previamente
        if (!tareasAsignadas.contains(tarea)) {
            tareasAsignadas.add(tarea);
            System.out.println("Tarea asignada correctamente al colaborador.");
        } else {
            System.out.println("La tarea ya está asignada al colaborador.");
        }
    }

    /*@Override
    public void editarComentario() {

    }*/

}
