package Interface;

import Model.entity.Persona;
import Model.entity.Proyecto;

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

    //Funcion que muestra todos los datos de un proyecto
    void imprimeProyecto(Proyecto proyecto);

     void imprimirCabecera();
}