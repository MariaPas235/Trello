import Controller.Controller;
import Model.entity.Persona;
import Model.repo.RepoPersona;
import view.GUI;

import javax.swing.text.View;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

public class main {

    public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException {
         Controller controller = new Controller();
         controller.controllerMain();
        RepoPersona rp = RepoPersona.get_instance();
        for(Persona p : rp.getAll()){
            System.out.println(p);
        }

    }
}
