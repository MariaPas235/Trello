package view;

import IO.Teclado;
import Interface.IGUI;
import Model.entity.EstadoTarea;
import Model.entity.Persona;
import Model.entity.Proyecto;
import Model.entity.Tarea;
import Model.repo.RepoPersona;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class GUI implements IGUI {
    static RepoPersona rp = RepoPersona.get_instance();

    //Funcion que muestra el menu de bienvenida
    @Override
    public void imprimirBienvenida() {
        System.out.println(".______    __   _______ .__   __. ____    ____  _______ .__   __.  __   _______    ______           ___         .___________..______       _______  __       __        ______   \n" +
                "|   _  \\  |  | |   ____||  \\ |  | \\   \\  /   / |   ____||  \\ |  | |  | |       \\  /  __  \\         /   \\        |           ||   _  \\     |   ____||  |     |  |      /  __  \\  \n" +
                "|  |_)  | |  | |  |__   |   \\|  |  \\   \\/   /  |  |__   |   \\|  | |  | |  .--.  ||  |  |  |       /  ^  \\       `---|  |----`|  |_)  |    |  |__   |  |     |  |     |  |  |  | \n" +
                "|   _  <  |  | |   __|  |  . `  |   \\      /   |   __|  |  . `  | |  | |  |  |  ||  |  |  |      /  /_\\  \\          |  |     |      /     |   __|  |  |     |  |     |  |  |  | \n" +
                "|  |_)  | |  | |  |____ |  |\\   |    \\    /    |  |____ |  |\\   | |  | |  '--'  ||  `--'  |     /  _____  \\         |  |     |  |\\  \\----.|  |____ |  `----.|  `----.|  `--'  | \n" +
                "|______/  |__| |_______||__| \\__|     \\__/     |_______||__| \\__| |__| |_______/  \\______/     /__/     \\__\\        |__|     | _| `._____||_______||_______||_______| \\______/ ");
    }

    //Funcion que recoge los datos de incio de sesion del usuario

    /**
     * Funcion que recoge los datos de inicio de sesion del usuario
     *
     * @return devuelve la persona asiganada al usuario introducido
     * Pide por teclado al usuario su usuario y contraseña
     * Si no coinciden con los datos almacenados en el repo del usuario dará error hasta
     * que los datos de inicio sean correctos
     */
    @Override
    public Persona recogeDatosInicio() {
        String nombreUsuario;
        String contrasena;
        do {
            nombreUsuario = Teclado.leeString("Inserte su usuario");
            contrasena = Teclado.leeString("Inserte su contraseña");
        } while (!(rp.getByUserName(nombreUsuario) && rp.getBypassword(contrasena)));
        return rp.getByID(nombreUsuario);
    }

    //Funcion que recoge los datos de registro de un usuario

    /**
     * Funcion que recoge los datos de registro de un usuario
     *
     * @return devuelve el usuario creado con sus atributos correctos
     * Pide al usuario que introduzca su nombre completo y su usuario (sin coincidir con uno registrado)
     * Pide por teclado una contraseña cumpliendo el patron de validacion de esta y si no es correcta pedira que se escriba de nuevo hasta cumplirlo
     * Por ultimo, pide un mail que debe de cumplir tambien con el patron de validacion de mail y si no es correcto pedira que se escriba de nuevo hasta cumplirlo
     */
    @Override
    public Persona recogeDatosRegistro() {

        String nombrePersona = Teclado.leeString("Inserte su nombre completo");
        String nombreUsuario = Teclado.leeString("Inserte su nombre de usuario");
        while (!Persona.validarUsuario(nombreUsuario)) {
            nombreUsuario = Teclado.leeString("Introduce una nombre de usuario correcto");
        }
        String contrasena = Teclado.leeString("Inserte su contraseña (Debe tener al menos 8 caracteres, incluyendo 1 mayúscula, 1 minúscula, 1 número y 1 carácter especial de los siguientes -> @$!.#_()%*?& <-)");
        while (!Persona.validarContrasena(contrasena)) {
            contrasena = Teclado.leeString("Introduce una contraseña correcta");
        }

        String mail = Teclado.leeString("Inserte su mail");

        while (!Persona.validarCorreo(mail)) {
            System.out.println("Mail incorrecto");
            mail = Teclado.leeString("Introduce tu mail correctamente");
        }

        return new Persona(nombrePersona, nombreUsuario, contrasena, mail);

    }

    //Funcion que muestra el menu de inicio al iniciar el programa

    /**
     * Funcion que muestra el menu de inicio al iniciar el programa
     *
     * @return devuelve la opcion que ha introducido el usuario por teclado
     */
    @Override
    public int imprimirMenuInicio() {
        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar sesion");
        System.out.println("3. Salir");
        return Teclado.leeNumero("Inserte una opción");

    }

    //Funcion que muestra el menu de bienvenida tras iniciar sesion
    @Override
    public void bienvenidaApp() {
        System.out.println(" _____                                _             ____                                                _   \n" +
                " | ____|  ___   _ __     __ _    ___  (_)   ___     |  _ \\    ___   _ __   ___    ___    _ __     __ _  | |  \n" +
                " |  _|   / __| | '_ \\   / _` |  / __| | |  / _ \\    | |_) |  / _ \\ | '__| / __|  / _ \\  | '_ \\   / _` | | |  \n" +
                " | |___  \\__ \\ | |_) | | (_| | | (__  | | | (_) |   |  __/  |  __/ | |    \\__ \\ | (_) | | | | | | (_| | | |  \n" +
                " |_____| |___/ | .__/   \\__,_|  \\___| |_|  \\___/    |_|      \\___| |_|    |___/  \\___/  |_| |_|  \\__,_| |_|  \n" +
                "               |_|                                                                                           ");
    }

    //Funcion que muestra el menu de proyectos

    /**
     * Funcion que muestra el menu de proyectos
     *
     * @return devuelve la opcion que ha introducido el usuario por teclado
     */
    @Override
    public int imprimirMenuProyectos() {
        System.out.println("1. Crear proyecto");
        System.out.println("2. Borrar proyecto");
        System.out.println("3. Listar proyectos");
        System.out.println("4. Seleccionar proyecto");
        System.out.println("5. Cerrar Sesión");
        return Teclado.leeNumero("Inserte una opción");
    }

    //Funcion que recoge los datos de un proyecto al crearlo
    @Override
    public Proyecto recogerDatosProyecto(String nombre) {
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre(Teclado.leeString("Inserte el nombre de su proyecto"));
        proyecto.setDescripcion(Teclado.leeString("Inserte una descripción de su proyecto"));
        proyecto.setFechaCreacion(LocalDate.now());
        proyecto.setColaboradores(proyecto.anadirColaborador());
        proyecto.setTareas(GUI.anadirTareas());
        proyecto.setJefe(nombre);
        return proyecto;
    }

    //Metodo estatico para poner una fecha final
    public static LocalDate anadirFechaFin() {
        LocalDateTime ahora = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaActualStr = formatter.format(ahora);

        LocalDate fechaFinalizacion = null;

        while (fechaFinalizacion == null) {
            String fechaFinalizacionStr = Teclado.leeString("Introduce la fecha de finalización (formato AAAA-MM-DD):");

            if (fechaFinalizacionStr.matches("\\d{4}-\\d{2}-\\d{2}") && fechaFinalizacionStr.compareTo(fechaActualStr) >= 0) {
                fechaFinalizacion = LocalDate.parse(fechaFinalizacionStr, formatter);
            } else {
                System.out.println("Error: La fecha de finalización no puede ser anterior a la fecha actual o el formato es incorrecto. " +
                        "Por favor, inténtalo de nuevo.");
            }
        }

        return fechaFinalizacion;
    }

    //Funcion de eliminar proyetos pidiendo por teclado el nombre de este a borrar

    /**
     * Funcion de eliminar proyetos pidiendo por teclado el nombre de este a borrar
     *
     * @return devuelve el nombre del proyecto que ha introducido el usuario por teclado
     */
    @Override
    public String borrarProyecto() {
        return Teclado.leeString("Introduce el nombre del proyecto que quieres eliminar:");
    }

    //Funcion de seleccionar un proyecto pidiendo por teclado el nombre de este

    /**
     * Funcion de seleccionar un proyecto pidiendo por teclado el nombre de este
     *
     * @return devuelve el nombre del proyecto que ha introducido el usuario por teclado
     */
    @Override
    public String seleccionarProyecto() {
        return Teclado.leeString("Inserte el nombre de su proyecto");
    }

    //Funcion que lista los datos de un proyecto
    @Override
    public void listarProyectos(Proyecto proyecto) {

        System.out.println("Nombre: " + proyecto.getNombre());
        System.out.println("Descripción: " + proyecto.getDescripcion());
        System.out.println("Fecha de Creación: " + proyecto.getFechaCreacion());
        System.out.println("-----------------------------------");

    }

    //Funcion que muestra el menu de opciones de tareas del jefe
    /**
     * Funcion que muestra el menu de opciones de tareas del jefe
     * @return devuelve la opcion que ha introducido el usuario por teclado
     */
    @Override
    public int imprimirOpcionesDeTareaJefe() {
        System.out.println("1. Añadir tarea");
        System.out.println("2. Borrar tarea");
        System.out.println("3. Añadir colaboradores");
        System.out.println("4. Eliminar Colaboradores");
        System.out.println("5. Asignar Tarea");
        System.out.println("6. Actualizar Tarea");
        System.out.println("7. Salir");
        return Teclado.leeNumero("Inserte una opción");
    }

    //Funcion que muestra las opciones de tarea de colaborador
    /**
     * Funcion que muestra las opciones de tarea de colaborado
     * @return devuelve la opcion introducida por el usuario por teclado
     */
    @Override
    public int imprimirOpcionesDeTareaColaborador() {
        System.out.println("1. Actualizar Tarea");
        System.out.println("2. Ver Comentario");
        System.out.println("3. Salir");
        return Teclado.leeNumero("Inserte una opción");
    }

    //Funcion que muestra todos los datos de un proyecto
    @Override
    public void imprimeProyecto(Proyecto proyecto) {
        System.out.println("Nombre: " + proyecto.getNombre());
        System.out.println("Descripción: " + proyecto.getDescripcion());
        System.out.println("Fecha de Creación: " + proyecto.getFechaCreacion());
        System.out.println("Colaboradores:");
        for (Persona colaborador : proyecto.getColaboradores()) {
            System.out.println("- " + colaborador.getNombre());
        }
        System.out.println("========================================================================");
        System.out.println("Tareas:");
        System.out.printf("%-30s%-30s%-30s\n", "Nombre", "Persona Asignada", "Estado");
        for (Tarea tarea : proyecto.getTareas()) {
            String nombreTarea = tarea.getNombre();
            String personaAsignada = tarea.getPersonaAsignada();
            String estadoTarea = tarea.getEstadoTarea().toString();

            System.out.printf("%-30s%-30s%-30s\n", nombreTarea, personaAsignada, estadoTarea);
        }
        System.out.println("========================================================================");
    }

    public static ArrayList<Tarea> anadirTareas() {
        ArrayList<Tarea> tarea = new ArrayList<>();
        boolean auxSN = true;
        while (auxSN) {
            Tarea tarea1 = new Tarea();
            tarea1.setNombre(Teclado.leeString("Introduce el nombre de la tarea: "));
            tarea1.setDescripcion(Teclado.leeString("Introduce una descripcion: "));
            tarea1.setFechaActual(LocalDateTime.now());
            tarea1.setFechaInicio(LocalDate.now());
            tarea1.setFechaLimite(GUI.anadirFechaFin());
            tarea.add(tarea1);
            String respuesta = Teclado.leeString("Quieres añadir otra tarea (s/n)? ");
            auxSN = respuesta.equalsIgnoreCase("s");
        }
        return tarea;
    }


    public void imprimirCabecera(){
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                           SIN INICIAR                           |                            PENDIENTE                            |                            ACABADA                            |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }

    public void asignarTarea(Proyecto proyecto){

        for (Tarea tarea : proyecto.getTareas()) {
            if (tarea.getEstadoTarea().equals(EstadoTarea.SININICIAR)) {
                System.out.println("|                            " + tarea.getNombre()+" ( "+(tarea.getPersonaAsignada()) +" )                          |                                                                 |                                                               |");

            }else if (tarea.getEstadoTarea().equals(EstadoTarea.PENDIENTE)) {
                System.out.println("|                                                            |                              "+ tarea.getNombre()+" ( "+(tarea.getPersonaAsignada()) +" )                              |                                                               |");
            }else {
                System.out.println("|                                                            |                                                                 |                                  "+ tarea.getNombre()+" ( "+(tarea.getPersonaAsignada()) +" )                        |");
            }
        }

    }
}