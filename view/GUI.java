package view;

import Interface.IGUI;
import Model.entity.Persona;
import Model.entity.Tarea;
import Model.repo.RepoPersona;
import Model.repo.RepoProyecto;
import Model.entity.Proyecto;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public String leeString(String msg) {
        String entrada = "";
        do {
            System.out.print(msg + ": ");
            try {
                entrada = teclado.nextLine();
            } catch (Exception e) {
                teclado.next();
            }
        } while (entrada.isEmpty());

        return entrada;
    }

    @Override
    public Persona recogeDatosInicio() {
        String nombreUsuario;
        String contrasena;
        do {
            nombreUsuario = leeString("Inserte su usuario");
            contrasena = leeString("Inserte su contraseña");
        } while (!rp.getByUserName(nombreUsuario) && !rp.getBypassword(contrasena));
        return rp.getByID(nombreUsuario);
    }

    @Override
    public void recogeDatosRegistro() throws FileNotFoundException, NoSuchAlgorithmException {

        String nombrePersona = leeString("Inserte su nombre completo");
        String nombreUsuario = leeString("Inserte su nombre de usuario");
        while (!Persona.validarUsuario(nombreUsuario)) {
            nombreUsuario = leeString("Introduce una nombre de usuario correcto");
        }
        String contrasena = leeString("Inserte su contraseña (Debe tener al menos 8 caracteres, incluyendo 1 mayúscula, 1 minúscula, 1 número y 1 carácter especial de los siguientes -> @$!.#_()%*?& <-)");
        while (!Persona.validarContrasena(contrasena)) {
            contrasena = leeString("Introduce una contraseña correcta");
        }

        String mail = leeString("Inserte su mail");

        while (!Persona.validarCorreo(mail)) {
            System.out.println("Mail incorrecto");
            mail = leeString("Introduce tu mail correctamente");
        }
        RepoPersona rp = RepoPersona.get_instance(); //Falla el get_instance no entiendo ;_;
        Persona persona = new Persona(nombrePersona, nombreUsuario, contrasena, mail);
        rp.add(persona);
        rp.save();

    }

    public int imprimirMenuInicio() {
        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar sesion");
        System.out.println("3. Salir");
        int opcion = leeNumero("Inserte una opción");
        return opcion;
    }

    public int leeNumero(String msg) {
        boolean aux = false;
        int numero = 0;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.print(msg + ": ");
            try {
                numero = teclado.nextInt();
                aux = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Introduce un número válido.");
                teclado.next();
            }
        } while (!aux);

        return numero;
    }

    public void bienvenidaApp(){
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
        System.out.println("3. Listar proyectos como colaborador");
        System.out.println("4. Listar proyectos");
        System.out.println("5. Seleccionar proyecto");
        System.out.println("6. Cerrar Sesión");
        int opcion = leeNumero("Inserte una opción");
        return opcion;
    }

    public void recogerDatosProyecto() {
        String nombreProyecto = leeString("Inserte el nombre de su proyecto");
        String descripcion = leeString("Inserte una descripción de su proyecto");
        LocalDate fechaCreacion = LocalDate.now();
        String colaboradores = leeString("Añade los colaboradores de su proyecto");
        //String estado = leeString("Inserte el estado del proyecto");
        RepoProyecto rProyecto = RepoProyecto.get_instance();
        Proyecto proyecto = new Proyecto(nombreProyecto, descripcion, fechaCreacion,new ArrayList<Persona>(),new ArrayList<Tarea>());
        rProyecto.add(proyecto);
        rProyecto.save();
    }



    public String borrarProyecto() {
        return leeString("Introduce el nombre del proyecto que quieras eliminar:");
    }

    public Proyecto seleccionarProyecto() {
        String nombreProyecto;
        do {
            nombreProyecto = leeString("Inserte el nombre de su proyecto");
        } while (!rProyecto.getByName(nombreProyecto));
        return rProyecto.getByID(nombreProyecto);
    }

    public void listarProyectos() {
        ArrayList<Proyecto> proyectos = (ArrayList<Proyecto>) rProyecto.getAll();
        if (proyectos.isEmpty()) {
            System.out.println("No hay proyectos creados.");
        } else {
            System.out.println("Proyectos creados:");
            for (Proyecto proyecto : proyectos) {
                System.out.println("Nombre: " + proyecto.getNombre());
                System.out.println("Descripción: " + proyecto.getDescripcion());
                System.out.println("Fecha de Creación: " + proyecto.getFechaCreacion());
                System.out.println("-----------------------------------");
            }
        }
    }

    public void imprimirOpcionesDeTarea() {
    }

    public void anadirTarea() {
    }

    public void borrarTarea() {
    }

    public void moverTarea() {
    }

    public void asignarTarea() {
    }

    public void editarTarea() {
    }

    public void desasignarTarea() {
    }

    public void imprimeProyecto(Proyecto proyecto) {
        System.out.println("Nombre: " + proyecto.getNombre());
        System.out.println("Descripción: " + proyecto.getDescripcion());
        System.out.println("Fecha de Creación: " + proyecto.getFechaCreacion());
        System.out.println("Colaboradores:");
        for (Persona colaborador : proyecto.getColaboradores()) {
            System.out.println("- " + colaborador.getNombre());
        }
        System.out.println("Tareas:");
        for (Tarea tarea : proyecto.getTareas()) {
            System.out.println("- " + tarea.getNombre() + " (" + tarea.getEstado() + ")");
        }
    }
}