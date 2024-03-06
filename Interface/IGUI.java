package Interface;

import Model.entity.Persona;
import Model.entity.Proyecto;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

//Metodos que implementamos en la GUI (Vista)
public interface IGUI {
    void imprimirBienvenida();

    int imprimirMenuInicio();

    String leeString(String msg);

    int leeNumero(String msg);

    Persona recogeDatosInicio();

    void recogeDatosRegistro() throws FileNotFoundException, NoSuchAlgorithmException;

    void bienvenidaApp();

    int imprimirMenuProyectos();

    void recogerDatosProyecto();

    void borrarProyecto();

    void listarProyectos();

    Proyecto seleccionarProyecto();

    void imprimirOpcionesDeTarea();

    void anadirTarea();

    void borrarTarea();

    void moverTarea();

    void asignarTarea();

    void editarTarea();

    void desasignarTarea();
}