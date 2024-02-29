package Interface;

import java.io.FileNotFoundException;

public interface IGUI {
void imprimirBienvenida();
int imprimirMenuInicio();
int leeNumero(String msg);
String leeString(String msg);

void recogeDatosInicio();
 void recogeDatosRegistro() throws FileNotFoundException;


}
