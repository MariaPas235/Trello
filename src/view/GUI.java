package view;

import Interface.IGUI;
import Model.entity.Persona;
import serializator.serializator_user;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class GUI implements IGUI {
    Scanner teclado = new Scanner(System.in);
    serializator_user serializator_user = new serializator_user();
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
       }while(!serializator_user.search_logUser(nombreUsuario, contrasena));
    }

    @Override
    public void recogeDatosRegistro() throws FileNotFoundException {

        String nombrePersona= leeString("Inserte su nombre completo");
        String nombreUsuario= leeString("Inserte su nombre de usuario");
        String contrasena= leeString("Inserte su contraseña (Debe tener al menos 8 caracteres, incluyendo 1 mayúscula, 1 minúscula, 1 número y 1 carácter especial de los siguientes -> @$!.#_()%*?& <-)");
        while (!Persona.validarContrasena(contrasena)){
            contrasena=leeString("Introduce una contraseña correcta");
        }

        String mail= leeString("Inserte su mail");

        while (!Persona.validarCorreo(mail)){
            System.out.println("Mail incorrecto");
            mail=leeString("Introduce tu mail correctamente");
        }
    Persona persona = new Persona(nombrePersona,nombreUsuario,contrasena,mail);
    serializator_user.serializator_user(persona);
    serializator_user.serializator_userName(persona);
    // nombrearraylist.add(persona)
    }

    public int imprimirMenuInicio() {
        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar sesion");
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

}

