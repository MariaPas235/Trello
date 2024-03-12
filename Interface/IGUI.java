package Interface;

import Model.entity.Proyecto;

//Metodos que implementamos en la GUI
public interface IGUI {
//Funcion que muestra por pantalla la cabecera de los estados de tarea
     void imprimirCabecera();
//Funcion que muestra el menu de proyectos al iniciar sesion el usuario
    void espacioTrabajo(Proyecto proyecto);
}