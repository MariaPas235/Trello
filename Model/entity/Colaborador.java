package Model.entity;

import Interface.IColaborador;
import view.GUI;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import static Model.entity.EstadoTarea.*;

public class Colaborador extends Persona implements IColaborador {
    public Colaborador(){
        super("","","","");
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
        comentario= GUI.leeString("Escriba un comentario: ");
        tarea.setComentario(comentario);
        return tarea.getComentario();
    }

    /*@Override
    public void editarComentario() {

    }*/

}
