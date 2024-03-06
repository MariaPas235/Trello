package Interface;

import Model.entity.Proyecto;
import Model.repo.Sesion;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

public interface IController {
    String controllerMain() throws FileNotFoundException, NoSuchAlgorithmException;
}
