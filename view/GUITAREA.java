package view;

import IO.Teclado;
import Interface.IGUITAREA;
import Model.entity.Colaborador;
import Model.entity.EstadoTarea;
import Model.entity.Tarea;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GUITAREA implements IGUITAREA {
    //Funcion que muestra el menu de opciones de tareas del jefe

    /**
     * Funcion que muestra el menu de opciones de tareas del jefe
     *
     * @return devuelve la opcion que ha introducido el usuario por teclado
     */
    @Override
    public int imprimirOpcionesDeTareaJefe() {
        System.out.println("");
        System.out.println("======================================================");
        System.out.println("=               1. Añadir tarea                      =");
        System.out.println("=               2. Borrar tarea                      =");
        System.out.println("=               3. Añadir colaboradores              =");
        System.out.println("=               4. Eliminar Colaboradores            =");
        System.out.println("=               5. Asignar Tarea                     =");
        System.out.println("=               6. Actualizar Tarea                  =");
        System.out.println("=               7. Salir                             =");
        System.out.println("======================================================");
        return Teclado.leeNumero("Inserte una opción");
    }

    //Funcion que muestra las opciones de tarea de colaborador

    /**
     * Funcion que muestra las opciones de tarea de colaborado
     *
     * @return devuelve la opcion introducida por el usuario por teclado
     */
    @Override
    public int imprimirOpcionesDeTareaColaborador() {
        System.out.println("========================================");
        System.out.println("=         1. Actualizar Tarea          =");
        System.out.println("=         2. Ver Comentario            =");
        System.out.println("=         3. Salir                     =");
        System.out.println("========================================");
        return Teclado.leeNumero("Inserte una opción");
    }


    //Funcion para añadir tareas a un proyecto

    /**
     * Funcion de añadir tareas a un proyecto
     * Primero se instancia de arrayList de tarea quede inicializa vacia
     * Se crea un boolean para comprobar si el usuario jefe quiere añadir mas tareas
     * El bucle while se ejecuta mientras que auxSN sea true
     * Dentro de este bucle se crea una instancia de tarea
     * Se le pide al usuario jefe introducir el nombre de la tarea a añadir por teclado con la funcion leeString
     * Se le pide al usuario jefe introducir la descripcion de la tarea por teclado con la funcion leeString
     * Se le añade la fecha de creacion con la fecha actual, la fecha de inicio de la tarea y la fecha final de esta
     * Finalmente se añade la tarea
     * A continuacion se le pide al usuario jefe si quiere seguir añadiendo tareas
     * Si la respuesta es s seguira añadiendo tareas si es n sale del bucle
     * (Se ha aplicado el caso de ignoreCase de mayusculas y minusculas por lo que s/n y S/N es lo mismo)
     *
     * @return devuelve el array de tareas añadidas
     */

    @Override
    public ArrayList<Tarea> anadirTareas() {
        ArrayList<Tarea> tarea = new ArrayList<>();
        boolean auxSN = true;
        while (auxSN) {
            Tarea tarea1 = new Tarea();
            tarea1.setNombre(Teclado.leeString("* Introduce el nombre de la tarea: "));
            tarea1.setDescripcion(Teclado.leeString("* Introduce una descripcion: "));
            tarea1.setFechaActual(LocalDateTime.now());
            tarea1.setFechaInicio(LocalDate.now());
            tarea1.setFechaLimite(anadirFechaFin());
            tarea.add(tarea1);
            String respuesta = Teclado.leeString("Pulsa (s) si queréis añadir otra tarea o cualquier tecla en caso contrario ");
            auxSN = respuesta.equalsIgnoreCase("s");
        }
        return tarea;
    }
    //Metodo estatico para poner una fecha final
    @Override
    public  LocalDate anadirFechaFin() {
        LocalDateTime ahora = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaActualStr = formatter.format(ahora);

        LocalDate fechaFinalizacion = null;

        while (fechaFinalizacion == null) {
            String fechaFinalizacionStr = Teclado.leeString("* Introduce la fecha de finalización (formato AAAA-MM-DD):");

            if (fechaFinalizacionStr.matches("\\d{4}-\\d{2}-\\d{2}") && fechaFinalizacionStr.compareTo(fechaActualStr) >= 0) {
                fechaFinalizacion = LocalDate.parse(fechaFinalizacionStr, formatter);
            } else {
                System.out.println("");
                System.out.println("Error: La fecha de finalización no puede ser anterior a la fecha actual o el formato es incorrecto. " +
                        "Por favor, inténtalo de nuevo.");
            }
        }

        return fechaFinalizacion;
    }
    //Funcion de borrar tareas del proyecto
    /**
     * Funcion de borrar tareas del proyecto
     * @param tareas la varibale de tareas del arrayList de tareas
     * Primero comprueba si la lista de tareas esta vacia y si lo esta dira un aviso de que no hay ninguna disponible para borrar
     * Si hay tareas, a continuacion se muestra la lista de tareas y sus posiciones de la lista que hay disponibles que se reccorren con un for
     * Se declara una variable opcion
     * En el bucle lee el numero de la tarea de la lista por teclado del usuario para borrar la tarea
     * Si la opcion es menor a cero o mayor a la cantidad de tareas que hay imprime un error
     * Si la opcion es distinta a 0 se borrara el numero de la tarea de la lista introducido por teclado correctamente
     * Si la opcion es 0 sale de la funcion de borrar tareas y sale del bucle
     */
    @Override
    public void borrarTarea(ArrayList<Tarea> tareas) {
        System.out.println("* Borrado de Tareas:");
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas disponibles para borrar.");
        } else {

            System.out.println("* Lista de tareas disponibles:");
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
                    System.out.println("* Tarea borrada correctamente.");
                }
            } while (opcion != 0);
        }
    }


    //Funcion de actualizar la tarea (cambiar descripcion, nombre, estado...)

    /**
     * Funcion de actualizar tareas del proyecto
     *
     * @param tareas la varibale de tareas del arrayList de tareas
     *               Si hay tareas disponibles, se muestra una lista de tareas y sus posiciones.
     *               El usuario selecciona una tarea para actualizarla ingresando su número.
     *               Se presenta un menú de opciones para cambiar diferentes atributos de la tarea, como el nombre, la persona asignada, la descripción, las fechas de inicio y límite, el comentario y el estado de la tarea.
     *               Dependiendo de la opción seleccionada, se pide al usuario que introduzca la nueva información. Para las fechas de inicio y límite, se valida el formato de la fecha y se pide al usuario que introduzca una nueva fecha hasta que el formato sea correcto.
     *               Para el estado de la tarea, se muestran los estados disponibles y se pide al usuario que introduzca el nuevo estado.
     *               Si se introduce un valor no válido, se pide al usuario que introduzca un valor válido.
     *               Una vez que se ha realizado una actualización correctamente, se muestra un mensaje de confirmación.
     *               El usuario puede salir de la función en cualquier momento seleccionando la opción 0.
     * @return
     */



    @Override
    public boolean actualizarTarea(ArrayList<Tarea> tareas) {
        boolean result = false;
        System.out.println("* Actualización de Tareas:");
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas disponibles para actualizar.");
        }else {

            System.out.println("* Lista de tareas disponibles:");
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println((i + 1) + ". " + tareas.get(i).getNombre());
            }
            int eligeTarea = Teclado.leeNumero("* Introduzca numero de la tarea: ");
            Tarea tarea = tareas.get(eligeTarea - 1); // Corregido el índice

            int opcion;
            do {
                System.out.println("");
                System.out.println("===========================================");
                System.out.println("=              1. Nombre                  =");
                System.out.println("=              2. Persona Asignada        =");
                System.out.println("=              3. Descripción             =");
                System.out.println("=              4. Fecha de Inicio         =");
                System.out.println("=              5. Fecha Límite            =");
                System.out.println("=              6. Comentario              =");
                System.out.println("=              7. Estado de la Tarea      =");
                System.out.println("=              0. Salir                   =");
                System.out.println("===========================================");

                opcion = Teclado.leeNumero("Seleccione qué desea actualizar:");

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
                        System.out.println("================================");
                        System.out.println("=       1. Sin Iniciar         =");
                        System.out.println("=       2. Pendiente           =");
                        System.out.println("=       3. Acabada             =");
                        System.out.println("================================");
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
                System.out.println("* Tarea actualizada correctamente.");
                result = true;
            } while (opcion != 0);
        }
        return result;
    }

    //Funcion para asignar tareas a los usuarios colaboradores de un proyecto
    /**
     * Funcion para asignar tareas a los colaboradores de un proyecto
     *
     * @param tareas      la variable de las tareas del arrayList
     * @param colaborador la variable de colaborador para asignarles tareas del arrayList
     *                    Primero comprueba si la lista de tareas esta vacia y si lo esta  dira un aviso de que no hay ninguna disponible para asignar
     *                    Si hay tareas, a continuacion se muestra la lista de tareas y sus posiciones de la lista que hay disponibles que se reccorren con un for
     *                    Se declara una variable opcion
     *                    En el bucle lee el numero de la tarea de la lista por teclado del usuario para asignar la tarea
     *                    Si la opcion es menor a cero o mayor a la cantidad de tareas que hay imprime un error
     *                    Si la opcion es distinta a 0 se le asignara el numero de la tarea de la lista introducido por teclado al colaborador correctamente
     *                    Si la opcion es 0 sale de la funcion de asignar tareas y sale del bucle
     * @return
     */
    @Override
    public boolean asignarTarea(ArrayList<Tarea> tareas, Colaborador colaborador) {
        boolean result = true;
        System.out.println("* Asignación de Tareas:");

        if (tareas.isEmpty()) {
            System.out.println("No hay tareas disponibles para asignar.");
            result = false;
        }

        String nombreTarea = Teclado.leeString("* Ingrese el nombre de la tarea: ");
        String nombrePersonaAsignada = Teclado.leeString("* Ingrese el nombre de la persona asignada: ");
        if (result) {
            for (Tarea tarea : tareas) {
                if (tarea.getNombre().equals(nombreTarea)) {
                    tarea.setPersonaAsignada(nombrePersonaAsignada);
                    System.out.println("Persona asignada correctamente a la tarea.");
                }
            }
        }
        return result;
    }
}
