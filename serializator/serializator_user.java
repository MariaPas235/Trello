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

}