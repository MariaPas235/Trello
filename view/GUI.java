package view;

import Interface.IGUI;
import Model.entity.Persona;
import Model.repo.RepoPersona;
import serializator.Serializator;
import Model.entity.proyecto;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class GUI implements IGUI {
    Scanner teclado = new Scanner(System.in);
    Serializator serializator = new Serializator();
    static RepoPersona rp = RepoPersona.get_instance();
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
    public void recogeDatosInicio() {
        String nombreUsuario;
        String contrasena;
        do {
            nombreUsuario = leeString("Inserte su usuario");
            contrasena = leeString("Inserte su contraseña");
        } while (!rp.getByUserName(nombreUsuario) && !rp.getBypassword(contrasena));
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
        System.out.println("3. Listar proyectos creados");
        System.out.println("4. Listar proyectos como colaborador");
        System.out.println("5. Cerrar Sesión");
        int opcion = leeNumero("Inserte una opción");
        return opcion;
    }

    public void recogerDatosProyecto(){
        String nombreProyecto=leeString("Inserte el nombre de su proyecto");
        String descripcion= leeString("Inserte una descripción de su proyecto");
        //fecha creación y fecha fin
        String colaboradores=leeString("Añade los colaboradores de su proyecto");//Aquí podemos poner para que solo añada un colaborador o que añada más de 1
        proyecto proyecto = new proyecto(nombreProyecto,descripcion,localDate,estado);//igual lo del estado deberíamos quitarlo
        //Deberíamos de poner para que devuelva un proyecto ya creado con estos datos que hemos recogido
        //meter el proyecto en un array de proyectos e identificarlo con un creado, para luego poder buscarlo en el array por el creado

        //test
    }

    public void deleteProyecto(){

    }

    public void borrarProyecto(){


    }

    public void listarProyectosCreados(){

    }


    public void listarProyectosColaborador(){

    }



}

