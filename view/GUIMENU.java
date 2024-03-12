package view;

import IO.Teclado;
import Interface.IGUIMENU;
import Model.entity.Persona;

import java.security.NoSuchAlgorithmException;

public class GUIMENU implements IGUIMENU {
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

        nombreUsuario = Teclado.leeString("* Inserte su usuario:");
        contrasena = Teclado.leeString("*Inserte su contraseña:");

        Persona tryLogging = new Persona("Logging");
        tryLogging.setUsuario(nombreUsuario);
        try {
            tryLogging.setContrasena(contrasena);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return tryLogging;
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

        String nombrePersona = Teclado.leeString("*Inserte su nombre completo:");
        String nombreUsuario = Teclado.leeString("*Inserte su nombre de usuario:");
        while (!Persona.validarUsuario(nombreUsuario)) {
            nombreUsuario = Teclado.leeString("*Introduce una nombre de usuario correcto:");
        }
        String contrasena = Teclado.leeString("*Inserte su contraseña (Debe tener al menos 8 caracteres, incluyendo 1 mayúscula, 1 minúscula, 1 número y 1 carácter especial de los siguientes -> @$!.#_()%*?& <-):");
        while (!Persona.validarContrasena(contrasena)) {
            contrasena = Teclado.leeString("*Introduce una contraseña correcta:");
        }

        String mail = Teclado.leeString("*Inserte su mail:");

        while (!Persona.validarCorreo(mail)) {
            System.out.println("Su mail ya se encuentra registrado en la base de datos, por favor inserte otro:");
            mail = Teclado.leeString("Introduce tu mail:");
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
        System.out.println(" ");
        System.out.println("===============================");
        System.out.println("=     1. Registrarse          =");
        System.out.println("=     2. Iniciar sesion       =");
        System.out.println("=     3. Borrar Usuario       =");
        System.out.println("=     4. Salir                =");
        System.out.println("===============================");
        return Teclado.leeNumero("Inserte una opción");

    }

    //Funcion que lee la persona que se pasa por teclado
    @Override
    public String IntroducePersonaBorrar() {
        return "* Introduce la persona que quieres borrar: \n";
    }

    //Funcion que confirma o no la eliminacion del usuario
    @Override
    public boolean EstaSeguro() {
        String respuesta = Teclado.leeString("¿Estás seguro? (si/no)"); // Convertir la respuesta a minúsculas para compararla de forma insensible a mayúsculas
        return respuesta.equals("si");
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

}
