package serializator;

import Model.entity.Persona;

import java.io.*;

public class serializator_user {
    String Nombre;
    String Usuario;
    String Contrasena;
    String mail;

    public void serializator_user(Persona persona) throws FileNotFoundException {
        try {
            FileWriter writer = new FileWriter("DatosUsuario.txt", true);
            Usuario = persona.getUsuario();
            Nombre = persona.getNombre();
            mail = persona.getMail();
            Contrasena = persona.getContrasena();
            writer.write(Nombre + "\n" + Usuario + "\n" + mail + "\n" + Contrasena + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar datos persona: " + e.getMessage());
        }
    }

    public void serializator_userName(Persona persona) throws FileNotFoundException {
        try {
            FileWriter writer = new FileWriter("DatosLogin.txt", true);
            Usuario = persona.getUsuario();
            Contrasena = persona.getContrasena();
            writer.write(Usuario + "\n" + Contrasena + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar login: " + e.getMessage());
        }
    }

    public boolean search_logUser(String nameUser, String passwordUser) {
        boolean result = false;
        try {
            FileInputStream fileIn = new FileInputStream("DatosLogin.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileIn));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Dividir la línea en nombre de usuario y contraseña
                String[] parts = line.split(" ");
                String userNameFromFile = parts[0];
                String passwordFromFile = parts[1];

                // Comprobar si el nombre de usuario y la contraseña coinciden
                if (userNameFromFile.equals(nameUser) && passwordFromFile.equals(passwordUser)) {
                    result = true;
                } else {
                    System.out.println("Usuario no encontrado");
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
