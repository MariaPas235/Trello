package serializator;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class serializator_user {
    String name;
    String nameUser;
    String passwordUser;
    String email;

    public serializator_user(String name, String password, String email, String nameUser) throws FileNotFoundException {
        try {
            FileWriter writer = new FileWriter("DatosUsuario.txt", true);
            this.nameUser = nameUser;
            this.name = name;
            this.email = email;
            this.passwordUser=password;
            writer.write(name + "\n" + nameUser +"\n");

            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
