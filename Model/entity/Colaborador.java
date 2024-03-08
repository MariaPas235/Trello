package Model.entity;

import IO.Teclado;
import Interface.IColaborador;
import view.GUI;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public void actualizarTarea(ArrayList<Tarea> tareas) {
        System.out.println("Actualización de Tareas:");
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas disponibles para actualizar.");
            return;
        }

        System.out.println("Lista de tareas disponibles:");
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println((i + 1) + ". " + tareas.get(i).getNombre());
        }
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1. Nombre");
            System.out.println("2. Persona Asignada");
            System.out.println("3. Descripción");
            System.out.println("4. Fecha de Inicio");
            System.out.println("5. Fecha Límite");
            System.out.println("6. Comentario");
            System.out.println("7. Estado de la Tarea");
            System.out.println("0. Salir");

            opcion = Teclado.leeNumero("Seleccione qué atributo desea actualizar:");

            if (opcion < 0 || opcion > 7) {
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            } else if (opcion != 0) {
                Tarea tarea = tareas.get(opcion - 1);

                switch (opcion) {
                    case 1:
                        tarea.setNombre(Teclado.leeString("Ingrese el nuevo nombre: "));
                        break;
                    case 2:
                        tarea.setPersonaAsignada(Teclado.leeString("Ingrese la nueva persona asignada: "));
                        break;
                    case 3:
                        tarea.setDescripcion(Teclado.leeString("Ingrese la nueva descripción: "));
                        break;
                    case 4:
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate fechaInicio = null;

                        while (fechaInicio == null) {
                            String fechaInicioStr = Teclado.leeString("Introduce la fecha de Inicio (formato AAAA-MM-DD):");

                            if (fechaInicioStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
                                fechaInicio = LocalDate.parse(fechaInicioStr, formatter);
                            } else {
                                System.out.println("Error: El formato es incorrecto. " +
                                        "Por favor, inténtalo de nuevo.");
                            }
                        }
                        tarea.setFechaInicio(fechaInicio);
                        break;
                    case 5:
                        LocalDateTime ahora2 = LocalDateTime.now();
                        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        String fechaActualStr2 = formatter2.format(ahora2);

                        LocalDate fechaFinalizacion2 = null;

                        while (fechaFinalizacion2 == null) {
                            String fechaFinalizacionStr2 = Teclado.leeString("Introduce la fecha de finalización (formato AAAA-MM-DD):");

                            if (fechaFinalizacionStr2.matches("\\d{4}-\\d{2}-\\d{2}") && fechaFinalizacionStr2.compareTo(fechaActualStr2) >= 0) {
                                fechaFinalizacion2 = LocalDate.parse(fechaFinalizacionStr2, formatter2);
                            } else {
                                System.out.println("Error: La fecha de finalización no puede ser anterior a la fecha actual o el formato es incorrecto. " +
                                        "Por favor, inténtalo de nuevo.");
                            }
                        }
                        tarea.setFechaLimite(fechaFinalizacion2);
                        break;
                    case 6:
                        tarea.setComentario(Teclado.leeString("Ingrese el nuevo comentario: "));
                        break;
                    case 7:
                        System.out.println("1. Sin Iniciar");
                        System.out.println("2. Pendiente");
                        System.out.println("3. Acabada");
                        int estado = Teclado.leeNumero("Seleccione el nuevo estado de la tarea:");
                        switch (estado) {
                            case 1:
                                tarea.setEstadoTarea(EstadoTarea.SININICIAR);
                                break;
                            case 2:
                                tarea.setEstadoTarea(EstadoTarea.PENDIENTE);
                                break;
                            case 3:
                                tarea.setEstadoTarea(EstadoTarea.ACABADA);
                                break;
                            default:
                                System.out.println("Opción inválida. El estado de la tarea no fue actualizado.");
                        }
                        break;
                }
                System.out.println("Tarea actualizada correctamente.");
            }
        } while (opcion != 0);
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
    public void verComentario(Proyecto proyecto) {
        ArrayList<Tarea> tareas = proyecto.getTareas();

        if (tareas.isEmpty()) {
            System.out.println("No hay tareas disponibles en este proyecto.");

        } else {

            System.out.println("Lista de tareas disponibles:");
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println((i + 1) + ". " + tareas.get(i).getNombre());
            }
        }
    }
}
