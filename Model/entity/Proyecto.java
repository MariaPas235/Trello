package Model.entity;

import IO.Teclado;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Proyecto implements Serializable {
    private String nombre;
    private String descripcion;
    private LocalDate fechaCreacion;
    private String Jefe;
    private ArrayList<Colaborador> colaboradores;
    private ArrayList<Tarea> tareas;

    public Proyecto(String nombre, String descripcion, LocalDate fechaCreacion, String jefe, ArrayList<Colaborador> colaboradores, ArrayList<Tarea> tareas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.Jefe = jefe;
        this.colaboradores = colaboradores;
        this.tareas = tareas;
    }

    public Proyecto() {
        this("", "", LocalDate.now(), "", new ArrayList<>(), new ArrayList<>());
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public String getJefe() {
        return Jefe;
    }

    public void setJefe(String jefe) {
        Jefe = jefe;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public ArrayList<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(ArrayList<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals;
        if (this == obj) {
            isEquals = true;
        } else if ((obj == null || getClass() != obj.getClass())) {
            isEquals = false;
        } else {
            Proyecto proyecto = (Proyecto) obj;
            isEquals = Objects.equals(nombre, proyecto.nombre);
        }
        return isEquals;
    }

    @Override
    public String toString() {
        return "proyecto[" + nombre + descripcion + LocalDate.now() + tareas + colaboradores + "]";
    }


    public boolean esColaborador(String usuario) {
        boolean result = false;
        ArrayList<Colaborador> colaboradores = this.getColaboradores();

        // Verificar si alguno de los colaboradores tiene el mismo nombre de usuario
        for (Colaborador colaborador : colaboradores) {
            if (colaborador.getUsuario().equals(usuario)) {
                result = true;
                break;
            }
        }

        return result;
    }

    public ArrayList<Colaborador> añadirColaborador() {
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

    public void eliminarColaborador() {
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