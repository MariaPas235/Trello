package view;

import Interface.IGUI;

import java.util.Scanner;

public class GUI implements IGUI {
    Scanner teclado = new Scanner(System.in);

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
    public String recogeDatosInicio() {
        return null;
    }

    @Override
    public String recogeDatosRegistro() {
        return null;
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

