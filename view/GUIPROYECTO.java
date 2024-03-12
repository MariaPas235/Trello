package view;

import IO.Teclado;
import Interface.IGUIPROYECTO;
import Model.entity.Colaborador;
import Model.entity.Proyecto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class GUIPROYECTO implements IGUIPROYECTO {
    view.GUITAREA GUITAREA = new GUITAREA();
    //Funcion que muestra el menu de proyectos

    /**
     * Funcion que muestra el menu de proyectos
     *
     * @return devuelve la opcion que ha introducido el usuario por teclado
     */
@Override
    public int imprimirMenuProyectos() {
        System.out.println("");
        System.out.println("====================================");
        System.out.println("=       1. Crear proyecto          =");
        System.out.println("=       2. Borrar proyecto         =");
        System.out.println("=       3. Listar proyectos        =");
        System.out.println("=       4. Seleccionar proyecto    =");
        System.out.println("=       5. Cerrar Sesión           =");
        System.out.println("====================================");
        return Teclado.leeNumero("Inserte una opción");
    }

    //Funcion que recoge los datos de un proyecto al crearlo
@Override
    public Proyecto recogerDatosProyecto(String nombre) {
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre(Teclado.leeString("* Inserte el nombre de su proyecto:"));
        proyecto.setDescripcion(Teclado.leeString("* Inserte una descripción para su proyecto:"));
        proyecto.setFechaCreacion(LocalDate.now());
        proyecto.setColaboradores(anadirColaborador());
        proyecto.setTareas(GUITAREA.anadirTareas());
        proyecto.setJefe(nombre);
        return proyecto;
    }

    //Funcion de eliminar proyetos pidiendo por teclado el nombre de este a borrar

    /**
     * Funcion de eliminar proyetos pidiendo por teclado el nombre de este a borrar
     *
     * @return devuelve el nombre del proyecto que ha introducido el usuario por teclado
     */
@Override
    public String borrarProyecto() {
        return Teclado.leeString("* Introduce el nombre del proyecto que quieres eliminar:");
    }

    //Funcion de seleccionar un proyecto pidiendo por teclado el nombre de este

    /**
     * Funcion de seleccionar un proyecto pidiendo por teclado el nombre de este
     *
     * @return devuelve el nombre del proyecto que ha introducido el usuario por teclado
     */
@Override
    public String seleccionarProyecto() {
        return Teclado.leeString("* Inserte el nombre del proyecto al que quiere acceder:");
    }

    //Funcion que lista los datos de un proyecto
@Override
    public void listarProyectos(Proyecto proyecto) {
        System.out.println("");
        System.out.println("Nombre: " + proyecto.getNombre());
        System.out.println("Descripción: " + proyecto.getDescripcion());
        System.out.println("Fecha de Creación: " + proyecto.getFechaCreacion());
        System.out.println("-----------------------------------");

    }

    /**
     * Funcion de añadir colaboradores al proyecto
     * @return el colaborador añadido al proyecto
     */
    @Override
    public ArrayList<Colaborador> anadirColaborador() {
        ArrayList<Colaborador> colaborador = new ArrayList<>();

        boolean auxSN = true;
        while (auxSN) {
            Colaborador colaboradoraux = new Colaborador();
            colaboradoraux.setUsuario(Teclado.leeString("Introduce el nombre del colaborador: "));
            colaborador.add(colaboradoraux);
            String respuesta = Teclado.leeString("Quieres añadir otro colaborador (s/n)? ");
            auxSN = respuesta.equalsIgnoreCase("s");
        }
        return colaborador;
    }

    /**
     * Funcion de eliminar colaboradores del proyecto
     * @param colaboradores del proyecto
     */
    @Override
    public void eliminarColaborador(ArrayList<Colaborador> colaboradores) {
        Scanner scanner = new Scanner(System.in);

        if (colaboradores.isEmpty()) {
            System.out.println("No hay colaboradores en el proyecto.");

        } else {

            System.out.println("Colaboradores actuales:");
            for (int i = 0; i < colaboradores.size(); i++) {
                System.out.println((i + 1) + ". " + colaboradores.get(i).getNombre());
            }

            System.out.println("Seleccione el número del colaborador que desea eliminar (0 para cancelar):");
            int opcion = Integer.parseInt(scanner.nextLine());

            if (opcion == 0) {
                System.out.println("Operación cancelada.");

            } else {


                if (opcion < 1 || opcion > colaboradores.size()) {
                    System.out.println("Número de colaborador inválido.");
                } else {

                    Colaborador colaboradorEliminado = colaboradores.remove(opcion - 1);
                    System.out.println("Colaborador " + colaboradorEliminado.getNombre() + " eliminado correctamente.");
                }
            }
        }
    }
}
