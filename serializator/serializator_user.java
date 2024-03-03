package serializator;

import Model.entity.Persona;

import java.io.*;

public class serializator_user {
    public static boolean search_logUser(String nameUser, String passwordUser) {
        boolean result = false;
        try {
            FileInputStream fileIn = new FileInputStream("Users.bin");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileIn));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith(nameUser + " " + passwordUser)) {
                    result = true;
                }
            }
            bufferedReader.close();
            fileIn.close();

        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
        return result;
    }

    public static boolean search_mailUser(String mailUser) {
        boolean result = false;
        try {
            FileInputStream fileIn = new FileInputStream("Users.bin");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            try {
                Persona persona = (Persona) objectIn.readObject();
                if (persona.getMail().equals(mailUser)) {
                    result = true;
                }
            } catch (EOFException e) {
                System.out.println("Error al buscar el email: " + e.getMessage());
            }
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return result;
    }
    public static boolean search_nameUser(String nameUser) {
        boolean result = false;
        try {
            FileInputStream fileIn = new FileInputStream("Users.bin");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            try {
                Persona persona = (Persona) objectIn.readObject();
                if (persona.getUsuario().equals(nameUser)) {
                    result = true;
                }
            } catch (EOFException e) {
                System.out.println("Error al buscar el Usuario: " + e.getMessage());
            }
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return result;
    }
    //Editar Usuario es decir hacer el CRUD
}
