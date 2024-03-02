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
        System.out.println("________                                                                  ___                                 __________                  ___ ___           \n" +
                "`MMMMMMMb. 68b                                                   68b      `MM                                 MMMMMMMMMM                  `MM `MM           \n" +
                " MM    `Mb Y89                                                   Y89       MM                                 /   MM   \\                   MM  MM           \n" +
                " MM     MM ___   ____   ___  __   ____    ___   ____   ___  __   ___   ____MM   _____            ___              MM     ___  __   ____    MM  MM   _____   \n" +
                " MM    .M9 `MM  6MMMMb  `MM 6MMb  `MM(    )M'  6MMMMb  `MM 6MMb  `MM  6MMMMMM  6MMMMMb         6MMMMb             MM     `MM 6MM  6MMMMb   MM  MM  6MMMMMb  \n" +
                " MMMMMMM(   MM 6M'  `Mb  MMM9 `Mb  `Mb    d'  6M'  `Mb  MMM9 `Mb  MM 6M'  `MM 6M'   `Mb       8M'  `Mb            MM      MM69 \" 6M'  `Mb  MM  MM 6M'   `Mb \n" +
                " MM    `Mb  MM MM    MM  MM'   MM   YM.  ,P   MM    MM  MM'   MM  MM MM    MM MM     MM           ,oMM            MM      MM'    MM    MM  MM  MM MM     MM \n" +
                " MM     MM  MM MMMMMMMM  MM    MM    MM  M    MMMMMMMM  MM    MM  MM MM    MM MM     MM       ,6MM9'MM            MM      MM     MMMMMMMM  MM  MM MM     MM \n" +
                " MM     MM  MM MM        MM    MM    `Mbd'    MM        MM    MM  MM MM    MM MM     MM       MM'   MM            MM      MM     MM        MM  MM MM     MM \n" +
                " MM    .M9  MM YM    d9  MM    MM     YMP     YM    d9  MM    MM  MM YM.  ,MM YM.   ,M9       MM.  ,MM            MM      MM     YM    d9  MM  MM YM.   ,M9 \n" +
                "_MMMMMMM9' _MM_ YMMMM9  _MM_  _MM_     M       YMMMM9  _MM_  _MM__MM_ YMMMMMM_ YMMMMM9        `YMMM9'Yb.         _MM_    _MM_     YMMMM9  _MM__MM_ YMMMMM9  \n" +
                "                                                                                                                                                            ");
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
            System.out.println("Contraseña incorrecto");
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

