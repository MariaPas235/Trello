package Model.entity;
import IO.Teclado;
import Interface.IColaborador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//La clase colaborador obtiene los atributos de Persona e implementa los metodos de la interfaz IColaborador y el Serializable
public class Colaborador extends Persona implements IColaborador, Serializable {
    //El colaborador tiene como atributos una lista de tareas de nombre tareasAsignadas
    public List<Tarea> tareasAsignadas;
    //Contructor vacio de los atributos heredados inicializados a 0
    //Se crea un arrayList vacio con la asignacion de la variable tareasAsignadas
    public Colaborador() {
        super("", "", "", "");
        tareasAsignadas = new ArrayList<>();
    }


//Funcion de ver comentario de una tarea
    /**
     * Funcion de ver comentario de una tarea
     * @param proyecto proyecto donde se va a ver los comentarios
     * Muestra un aviso de que no hay tareas en la lista si esta está vacia
     * Si hay se muestra la lista de tares disponible
     * Pide por teclado al usuario el numero de la tarea en la lista
     * Si pone 0 sale de la funcion, si pone un numero invalido da error
     * Si el numero de la tarea tiene comentario se mostrará por pantalla y si no tiene mostrara un mensaje de que no tiene comentarios la tarea
     */
    @Override
    public void verComentario(Proyecto proyecto) {
        ArrayList<Tarea> tareas = proyecto.getTareas();

        if (tareas.isEmpty()) {
            System.out.println("No hay tareas disponibles en este proyecto.");

        } else {


            System.out.println("* Lista de tareas disponibles:");
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println((i + 1) + ". " + tareas.get(i).getNombre());
            }
            int opcion = Teclado.leeNumero("Seleccione el número de la tarea para ver su comentario (0 para cancelar): ");

            if (opcion == 0) {
                System.out.println("Operación cancelada.");

            } else {

                if (opcion < 1 || opcion > tareas.size()) {
                    System.out.println("Número de tarea inválido.");

                }

                Tarea tareaSeleccionada = tareas.get(opcion - 1);
                String comentario = tareaSeleccionada.getComentario();

                if (comentario != null && !comentario.isEmpty()) {
                    System.out.println("Comentario de la tarea '" + tareaSeleccionada.getNombre() + "': " + comentario);
                } else {
                    System.out.println("La tarea '" + tareaSeleccionada.getNombre() + "' no tiene ningún comentario.");
                }
            }
        }
    }
}