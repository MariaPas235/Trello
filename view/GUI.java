package view;

import Interface.IGUI;
import Model.entity.*;

public class GUI implements IGUI {
    //Funcion que muestra la cabecera del proyecto

    /**
     * funcion que recibe la cabecera del proyecto standart para todos los proyectos
     */
    @Override
    public void imprimirCabecera() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                           SIN INICIAR                           |                            PENDIENTE                            |                            ACABADA                            |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }
    //Funcion que muestra los proyectos de forma ordenada

    /**
     * Funcion que muestra los proyectos de forma ordenada
     * @param proyecto recibe el proyecto
     */
    @Override
    public void espacioTrabajo(Proyecto proyecto) {

        for (Tarea tarea : proyecto.getTareas()) {

            String nombreTarea = tarea.getNombre().length() > 20 ? tarea.getNombre().substring(0, 17) + "..." : tarea.getNombre();
            String nombreColaborador = tarea.getPersonaAsignada().length() > 20 ? tarea.getPersonaAsignada().substring(0, 17) + "..." : tarea.getPersonaAsignada();

            int nCaracteres = nombreTarea.length() + nombreColaborador.length() - 1 - 1 - 1 - 1 - 1;
            int espaciosAIntroducir = 65 - nCaracteres;
            String espacios = "";
            for (int i = 0; i < espaciosAIntroducir / 2; i++) {
                espacios += " ";
            }

            if (tarea.getEstadoTarea().equals(EstadoTarea.SININICIAR)) {


                System.out.println(espacios + nombreTarea + " (" + nombreColaborador + ")" + espacios + "                                                                                                                                     ");

            } else if (tarea.getEstadoTarea().equals(EstadoTarea.PENDIENTE)) {
                System.out.println("                                                                   " + espacios + nombreTarea + " (" + nombreColaborador + ")" + espacios + "                                                                   ");
            } else {
                System.out.println("                                                                                                                                     " + espacios + nombreTarea + " (" + nombreColaborador + ")" + espacios + " ");
            }

        }
    }

}
