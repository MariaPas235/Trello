package Interface;

import Model.entity.Colaborador;
import Model.entity.Persona;
import Model.entity.Proyecto;
import Model.entity.Tarea;

import java.util.ArrayList;

//Metodos que implementamos en la GUI (Vista)
public interface IGUI {
    //Funcion que muestra el menu de bienvenida
    void imprimirBienvenida();

    //Funcion que muestra el menu de inicio si quiere registrarse o iniciar sesion un usuario y salir del programa
    int imprimirMenuInicio();

    //Funcion que recoge los datos del usuario al iniciar sesion
    Persona recogeDatosInicio();

    //Funcion que recoge los datos del usuario al registrarse
    Persona recogeDatosRegistro();

    String IntroducePersonaBorrar();

    boolean EstaSeguro();

    //Funcion que muestra el menu de bienvenida al programa una vez inicias sesion
    void bienvenidaApp();

    //Funcion que muestra el menu de inicio de proyectos si quiere añadir,borrar, listar o seleccionar un proyecto y cerrar sesion
    int imprimirMenuProyectos();

    //Funcion que recoge los datos del proyecto
    Proyecto recogerDatosProyecto(String nombre);

    //Funcion que borra proyectos que el usuario desee
    String borrarProyecto();

    //Funcion que lista los proyectos creados
    void listarProyectos(Proyecto proyecto);

    //Funcion para seleccionar un proyecto especifico
    String seleccionarProyecto();

    //Funcion que muestra el menu de opciones del jefe de un proyecto (CRUD) y asignar y actualizar tareas y salir
    int imprimirOpcionesDeTareaJefe();

    //Funcion que muestra el menu de opciones del jefe para una tarea de un colaborador
    int imprimirOpcionesDeTareaColaborador();

     void imprimirCabecera();


    //Funcion para asignar tareas a los colaboradores
    boolean asignarTarea(ArrayList<Tarea> tareas, Colaborador colaborador);

    //Funcion para borrar una tarea del proyecto
    void borrarTarea(ArrayList<Tarea> tareas);

    //Funcion para actualizar una tarea (nombre,descripcion...)
    void actualizarTarea(ArrayList<Tarea> tareas);
}