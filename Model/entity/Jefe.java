package Model.entity;

import IO.Teclado;
import Interface.IJefe;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static view.GUI.añadirFechaFin;


public class Jefe extends Persona implements IJefe, Serializable {
    public Jefe() {
        super("", "", "", "");
    }


    //Funcion para añadir tareas a un proyecto
    @Override
    public ArrayList<Tarea> anadirTarea() {
        ArrayList<Tarea> tarea = new ArrayList<>();
        boolean auxSN = true;
        while (auxSN) {
            Tarea tarea1 = new Tarea();
            tarea1.setNombre(Teclado.leeString("Introduce el nombre de la tarea: "));
            tarea1.setDescripcion(Teclado.leeString("Introduce una descripcion: "));
            tarea1.setFechaActual(LocalDateTime.now());
            tarea1.setFechaInicio(LocalDate.now());
            tarea1.setFechaLimite(añadirFechaFin());
            tarea.add(tarea1);
            String respuesta = Teclado.leeString("Quieres añadir otra tarea (s/n)? ");
            auxSN = respuesta.equalsIgnoreCase("s");
        }
        return tarea;
    }


    @Override
    public void asignarTarea(ArrayList<Tarea> tareas, Colaborador colaborador) {
        System.out.println("Asignación de Tareas:");
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas disponibles para asignar.");
            return;
        }

        System.out.println("Lista de tareas disponibles:");
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println((i + 1) + ". " + tareas.get(i).getNombre());
        }

        int opcion;
        do {
            opcion = Teclado.leeNumero("Seleccione el número de tarea a asignar (0 para salir): ");
            if (opcion < 0 || opcion > tareas.size()) {
                System.out.println("Opción inválida. Por favor, seleccione una tarea válida.");
            } else if (opcion != 0) {
                colaborador.asignarTarea(tareas.get(opcion - 1));
                System.out.println("Tarea asignada correctamente.");
            }
        } while (opcion != 0);
    }

    @Override
    public void borrarTarea(ArrayList<Tarea> tareas) {
        System.out.println("Borrado de Tareas:");
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas disponibles para borrar.");
        } else {

            System.out.println("Lista de tareas disponibles:");
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println((i + 1) + ". " + tareas.get(i).getNombre());
            }

            int opcion;
            do {
                opcion = Teclado.leeNumero("Seleccione el número de tarea a borrar (0 para salir): ");
                if (opcion < 0 || opcion > tareas.size()) {
                    System.out.println("Opción inválida. Por favor, seleccione una tarea válida.");
                } else if (opcion != 0) {
                    tareas.remove(opcion - 1);
                    System.out.println("Tarea borrada correctamente.");
                }
            } while (opcion != 0);
        }
    }

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
        int eligeTarea = Teclado.leeNumero("Introduzca numero de la tarea: ");
        Tarea tarea = tareas.get(eligeTarea - 1); // Corregido el índice

        int opcion;
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
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
            System.out.println("Tarea actualizada correctamente.");

        } while (opcion != 0);
    }
}