package view;

import IO.Teclado;
import Interface.IGUI;
import Model.entity.*;
import Model.repo.RepoPersona;
import Model.repo.RepoProyecto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class GUI implements IGUI {
    Scanner teclado = new Scanner(System.in);
    static RepoPersona rp = RepoPersona.get_instance();
    static RepoProyecto rProyecto = RepoProyecto.get_instance();

    //test
    public void imprimirBienvenida() {
        System.out.println(".______    __   _______ .__   __. ____    ____  _______ .__   __.  __   _______    ______           ___         .___________..______       _______  __       __        ______   \n" +
                "|   _  \\  |  | |   ____||  \\ |  | \\   \\  /   / |   ____||  \\ |  | |  | |       \\  /  __  \\         /   \\        |           ||   _  \\     |   ____||  |     |  |      /  __  \\  \n" +
                "|  |_)  | |  | |  |__   |   \\|  |  \\   \\/   /  |  |__   |   \\|  | |  | |  .--.  ||  |  |  |       /  ^  \\       `---|  |----`|  |_)  |    |  |__   |  |     |  |     |  |  |  | \n" +
                "|   _  <  |  | |   __|  |  . `  |   \\      /   |   __|  |  . `  | |  | |  |  |  ||  |  |  |      /  /_\\  \\          |  |     |      /     |   __|  |  |     |  |     |  |  |  | \n" +
                "|  |_)  | |  | |  |____ |  |\\   |    \\    /    |  |____ |  |\\   | |  | |  '--'  ||  `--'  |     /  _____  \\         |  |     |  |\\  \\----.|  |____ |  `----.|  `----.|  `--'  | \n" +
                "|______/  |__| |_______||__| \\__|     \\__/     |_______||__| \\__| |__| |_______/  \\______/     /__/     \\__\\        |__|     | _| `._____||_______||_______||_______| \\______/ ");
    }



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

    public int imprimirMenuInicio() {
        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar sesion");
        System.out.println("3. Salir");
        return Teclado.leeNumero("Inserte una opción");
    }



    public void bienvenidaApp() {
        System.out.println(" _____                                _             ____                                                _   \n" +
                " | ____|  ___   _ __     __ _    ___  (_)   ___     |  _ \\    ___   _ __   ___    ___    _ __     __ _  | |  \n" +
                " |  _|   / __| | '_ \\   / _` |  / __| | |  / _ \\    | |_) |  / _ \\ | '__| / __|  / _ \\  | '_ \\   / _` | | |  \n" +
                " | |___  \\__ \\ | |_) | | (_| | | (__  | | | (_) |   |  __/  |  __/ | |    \\__ \\ | (_) | | | | | | (_| | | |  \n" +
                " |_____| |___/ | .__/   \\__,_|  \\___| |_|  \\___/    |_|      \\___| |_|    |___/  \\___/  |_| |_|  \\__,_| |_|  \n" +
                "               |_|                                                                                           ");
    }

    public int imprimirMenuProyectos() {
        System.out.println("1. Crear proyecto");
        System.out.println("2. Borrar proyecto");
        System.out.println("3. Listar proyectos");
        System.out.println("4. Seleccionar proyecto");
        System.out.println("5. Cerrar Sesión");
        return Teclado.leeNumero("Inserte una opción");
    }

    public Proyecto recogerDatosProyecto(String nombre) {
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre(Teclado.leeString("Inserte el nombre de su proyecto"));
        proyecto.setDescripcion(Teclado.leeString("Inserte una descripción de su proyecto"));
        proyecto.setFechaCreacion(LocalDate.now());
        proyecto.setColaboradores(proyecto.añadirColaborador());
        proyecto.setTareas(Tarea.añadirTareas());
        proyecto.setJefe(nombre);
        return proyecto;
    }


    public static LocalDate añadirFechaFin() {
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
    public String borrarProyecto() {
        return Teclado.leeString("Introduce el nombre del proyecto que quieres eliminar:");
    }

    public String seleccionarProyecto() {
        return  Teclado.leeString("Inserte el nombre de su proyecto");
    }

    public void listarProyectos(Proyecto proyecto) {

                System.out.println("Nombre: " + proyecto.getNombre());
                System.out.println("Descripción: " + proyecto.getDescripcion());
                System.out.println("Fecha de Creación: " + proyecto.getFechaCreacion());
                System.out.println("-----------------------------------");

    }

    public int imprimirOpcionesDeTarea() {
        System.out.println("1. Añadir tarea");
        System.out.println("2. Borrar tarea");
        System.out.println("3. Añadir colaboradores");
        System.out.println("4. Eliminar Colaboradores");
        System.out.println("5. Asignar Tarea");
        System.out.println("6. Actualizar Tarea");
        System.out.println("7. Salir");
        return Teclado.leeNumero("Inserte una opción");
    }




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
}