package Interface;

import Model.entity.Colaborador;
import Model.entity.Proyecto;

import java.util.ArrayList;

public interface IGUIPROYECTO {
    //Funcion que imprime el menu de proyectos y devuelve la opcion por teclado del usuario
    int imprimirMenuProyectos();

    //Funcion que recoge los datos de un proyecto al crearlo
    Proyecto recogerDatosProyecto(String nombre);

    //Funcion de borrar un proyecto
    String borrarProyecto();

    //Funcion que selecciona el
    String seleccionarProyecto();

    //Funcion que lista los datos de un proyecto
    void listarProyectos(Proyecto proyecto);

    //Funcion de añadir colaboradores al proyecto
    ArrayList<Colaborador> anadirColaborador();

    //Funcion que elimina colaboradores de un proyecto
    void eliminarColaborador(ArrayList<Colaborador> colaboradores);
}
