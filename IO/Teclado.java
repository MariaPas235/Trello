package IO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teclado {
    //Atributos de la clase teclado (teclado estático)
    private static Scanner teclado = new Scanner(System.in);
    //Funcion estatica que lee una cadena de String que escriba el usuario por teclado
    /**
     * Funcion estatica que lee una cadena de String que escriba el usuario por teclado
     * @param cadena que lee el string que va a escribir el usuario por teclado
     * @return la cadena String que escriba el usuario
     */
    public static String leeString(String cadena) {

        String cadenaUsuario;
        System.out.println(cadena);
        cadenaUsuario = teclado.nextLine();
        if (cadenaUsuario.isEmpty() ||  cadenaUsuario.isBlank()) {
            do {
                Teclado.imprimirCadena("Por favor introduzca los datos");
                cadenaUsuario = teclado.nextLine();
            } while (cadenaUsuario.isEmpty()|| cadenaUsuario.isBlank());
        }
        return cadenaUsuario;
    }
    //Funcion estatica que lee el int que introduzca el usuario por teclado

    /**
     * Funcion estatica que lee el int que introduzca el usuario por teclado
     * @param cadena que lee el string que va a escribir el usuario por teclado
     * @return int que ha escrito el usuario por pantalla
     */
    public static int leeNumero(String cadena) {
        int numeroUsuario = 0;
        boolean entradaValida = false;
        imprimirCadena(cadena);
        do {
            try {
                numeroUsuario = teclado.nextInt();
                teclado.nextLine();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Introduce un número por favor");
                teclado.nextLine();
            }
        } while (!entradaValida);


        return numeroUsuario;
    }
    //Funcion que muestra una cadena String
    public static void imprimirCadena(String cadena) {
        System.out.println(cadena);
    }
}
