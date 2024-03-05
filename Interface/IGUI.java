package Interface;

import Model.entity.Persona;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

public interface IGUI {
void imprimirBienvenida();
int imprimirMenuInicio();
int leeNumero(String msg);
String leeString(String msg);

Persona recogeDatosInicio();
void recogeDatosRegistro() throws FileNotFoundException, NoSuchAlgorithmException;


}
