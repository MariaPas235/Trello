package Interface;

import Model.entity.Colaborador;
import Model.entity.Proyecto;

import java.util.ArrayList;

public interface IGUIPROYECTO {
    int imprimirMenuProyectos();

    //Funcion que recoge los datos de un proyecto al crearlo
    Proyecto recogerDatosProyecto(String nombre);

    String borrarProyecto();

    String seleccionarProyecto();

    //Funcion que lista los datos de un proyecto
    void listarProyectos(Proyecto proyecto);

    ArrayList<Colaborador> anadirColaborador();

    void eliminarColaborador(ArrayList<Colaborador> colaboradores);
}
