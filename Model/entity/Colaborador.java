package Model.entity;

import IO.Teclado;
import Interface.IColaborador;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//La clase colaborador obtiene los atributos de Persona e implementa los metodos de la interfaz IColaborador y el Serializable
public class Colaborador extends Persona implements IColaborador, Serializable {
    //El colaborador tiene como atributos una lista de tareas de nombre tareasAsignadas
    public List<Tarea> tareasAsignadas;
    //Contructor vacio de los atributos heredados inicializados a 0
    //Se crea un arrayList vacio con la asignacion de la variable tareasAsignadas
    public Colaborador() {
        super("", "", "", "");
        tareasAsignadas = new ArrayList<>();
    }



    //Funcion de actualizar el estado de una tarea
    /**
     * Funcion de actualizar tareas del proyecto
     * @param tareas la varibale de tareas del arrayList de tareas
     * Si la lista de tareas está vacía, se muestra un aviso.
     * Si hay tareas, se muestra la lista de tareas y sus posiciones.
     * El usuario puede seleccionar una tarea para actualizarla.
     * Se proporciona un menú de opciones para cambiar diferentes atributos de la tarea, como el nombre, la persona asignada, la descripción, las fechas de inicio y límite, el comentario y el estado de la tarea.
     * Para las fechas de inicio y límite, se valida el formato de la fecha y se pide al usuario que introduzca una nueva fecha hasta que el formato sea correcto.
     * Para el estado de la tarea, se muestran los estados disponibles y se pide al usuario que introduzca el nuevo estado.
     * Si se introduce un valor no válido, se pide al usuario que introduzca un valor válido.
     * Una vez que se ha realizado una actualización correctamente, se muestra un mensaje de confirmación.
     * El usuario puede salir de la función en cualquier momento seleccionando la opción 0.
     */
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
        int opcion;
        do {
            System.out.println("");
            System.out.println("=======================================");
            System.out.println("=            1. Nombre                =");
            System.out.println("=            2. Persona Asignada      =");
            System.out.println("=            3. Descripción           =");
            System.out.println("=            4. Fecha de Inicio       =");
            System.out.println("=            5. Fecha Límite          =");
            System.out.println("=            6. Comentario            =");
            System.out.println("=            7. Estado de la Tarea    =");
            System.out.println("=            0. Salir                 =");
            System.out.println("=======================================");

            opcion = Teclado.leeNumero("* Seleccione qué desea actualizar:");

            if (opcion < 0 || opcion > 7) {
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            } else if (opcion != 0) {
                Tarea tarea = tareas.get(opcion - 1);

                switch (opcion) {
                    case 1:
                        tarea.setNombre(Teclado.leeString("* Ingrese el nuevo nombre: "));
                        break;
                    case 2:
                        tarea.setPersonaAsignada(Teclado.leeString("* Ingrese la nueva persona asignada: "));
                        break;
                    case 3:
                        tarea.setDescripcion(Teclado.leeString("* Ingrese la nueva descripción: "));
                        break;
                    case 4:
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate fechaInicio = null;

                        while (fechaInicio == null) {
                            String fechaInicioStr = Teclado.leeString("* Introduce la fecha de Inicio (formato AAAA-MM-DD):");

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
                            String fechaFinalizacionStr2 = Teclado.leeString("* Introduce la fecha de finalización (formato AAAA-MM-DD):");

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
                        tarea.setComentario(Teclado.leeString("* Ingrese el nuevo comentario: "));
                        break;
                    case 7:
                        System.out.println("");
                        System.out.println("===============================");
                        System.out.println("=       1. Sin Iniciar        =");
                        System.out.println("=       2. Pendiente          =");
                        System.out.println("=       3. Acabada            =");
                        System.out.println("===============================");
                        int estado = Teclado.leeNumero("* Seleccione el nuevo estado de la tarea:");
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
                System.out.println("* Tarea actualizada correctamente.");
            }
        } while (opcion != 0);
    }

    //Funcion para añadir comentarios a la tarea
    /**
     * Funcion para añadir comentarios a la tarea
     * @param tarea la tarea a la que se va a añadir el comentario
     * @param proyecto el proyecto de donde esta la tarea a la que se va a añadirle el comentario
     * @param comentario el comentario de la tarea
     * @return devuelve el comentario añadido a la tarea
     * Se pide al usuario por teclado que añada un comentario a la tarea y lo guarda
     */
    @Override
    public String anadirComentario(Tarea tarea, Proyecto proyecto, String comentario) {
        comentario = Teclado.leeString("* Escriba un comentario: ");
        tarea.setComentario(comentario);
        return tarea.getComentario();
    }

//Funcion de asignar tarea
    /**
     * Funcion de asignar tarea si no estaba asignada
     * @param tarea a asignar
     * Si no hay una tarea asiganada se añade a la lista y muestra un mensaje de que ha sido asignada al colaborador
     * Si la tarea ya estaba asiganada al colaborador mostara un mensaje
     */
    @Override
    public void asignarTarea(Tarea tarea) {
        // Verificar si la tarea no ha sido asignada previamente
        if (!tareasAsignadas.contains(tarea)) {
            tareasAsignadas.add(tarea);
            System.out.println("Tarea asignada correctamente al colaborador.");
        } else {
            System.out.println("La tarea ya está asignada al colaborador.");
        }
    }

//Funcion de ver comentario de una tarea
    /**
     * Funcion de ver comentario de una tarea
     * @param proyecto proyecto donde se va a ver los comentarios
     * Muestra un aviso de que no hay tareas en la lista si esta está vacia
     * Si hay se muestra la lista de tares disponible
     * Pide por teclado al usuario el numero de la tarea en la lista
     * Si pone 0 sale de la funcion, si pone un numero invalido da error
     * Si el numero de la tarea tiene comentario se mostrará por pantalla y si no tiene mostrara un mensaje de que no tiene comentarios la tarea
     */
    @Override
    public void verComentario(Proyecto proyecto) {
        ArrayList<Tarea> tareas = proyecto.getTareas();

        if (tareas.isEmpty()) {
            System.out.println("No hay tareas disponibles en este proyecto.");

        } else {

            Scanner scanner = new Scanner(System.in);

            System.out.println("* Lista de tareas disponibles:");
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println((i + 1) + ". " + tareas.get(i).getNombre());
            }

            System.out.print("Seleccione el número de la tarea para ver su comentario (0 para cancelar): ");
            int opcion = Integer.parseInt(scanner.nextLine());

            if (opcion == 0) {
                System.out.println("Operación cancelada.");

            } else {

                if (opcion < 1 || opcion > tareas.size()) {
                    System.out.println("Número de tarea inválido.");

                }

                Tarea tareaSeleccionada = tareas.get(opcion - 1);
                String comentario = tareaSeleccionada.getComentario();

                if (comentario != null && !comentario.isEmpty()) {
                    System.out.println("Comentario de la tarea '" + tareaSeleccionada.getNombre() + "': " + comentario);
                } else {
                    System.out.println("La tarea '" + tareaSeleccionada.getNombre() + "' no tiene ningún comentario.");
                }
            }
        }
    }
}