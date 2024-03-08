package Interface;

import Model.entity.Persona;
import Model.entity.Proyecto;
import Model.entity.Tarea;

//Metodos que implementamos en la GUI (Vista)
public interface IGUI {
    void imprimirBienvenida();

    int imprimirMenuInicio();

    Persona recogeDatosInicio();

    Persona recogeDatosRegistro();

    void bienvenidaApp();

    int imprimirMenuProyectos();

    Proyecto recogerDatosProyecto(String nombre);

    String borrarProyecto();

    void listarProyectos(Proyecto proyecto);

    String seleccionarProyecto();

    int imprimirOpcionesDeTarea();

    Tarea anadirTarea();

    void borrarTarea();

    void moverTarea();

    void asignarTarea();

    void editarTarea();

}