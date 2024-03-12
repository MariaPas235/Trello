package Model.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

//El enum implementa el serializable
public enum EstadoTarea implements Serializable {
    //Enums de estado con valor asignado
    SININICIAR(1, "Sin iniciar"),
    PENDIENTE(2, "Pendiente"),
    ACABADA(3, "Acabada");
    //Atributos del enum inicializados en final ya que siempren van a ser esos valores asginados
    private final int valor;
    private final String estado;
    //Map es un mapa estatico que asigna el nombre del estado con la instancia correcta del enum
    private static final Map<String, EstadoTarea> ESTADO_TAREA_MAP;

    //ESTADO_TAREA_MAP contiene todas las combinaciones posibles de estados con su instancia correspondiente
    EstadoTarea(int valor, String estado) {
        this.valor = valor;
        this.estado = estado;
    }

    public int getValor() {
        return valor;
    }

    /*
     * static: este metodo estatico crea un HashMap con la variable ESTADO_TAREA_MAP
     * for-each: Se recorren todos los valores del enum EstadoTarea utilizando el método values()
        estadotarea agrega una entrada al mapa creado
        En estadotarea.estado la clave es el estado
        ESTADO_TAREA_MAP.put permite insertar un mapeo al mapa HashMAp
        Permite agregar una clave específica y el valor al que está asociada esa clave en un mapa particular.
     */
    static {
        ESTADO_TAREA_MAP = new HashMap<>();
        for (EstadoTarea estadotarea : values()) {
            ESTADO_TAREA_MAP.put(estadotarea.estado, estadotarea);
        }
    }

    /**
     * El uso de este método es obtener una instancia de EstadoTarea a partir de un nombre de estado representado por la cadena estado
     *
     * @param estado es el nombre del estado
     * @return devuelve el nombre del estado escrito si es valido, si no, da un error de expcepcion
     */
    public static EstadoTarea fromEstado(String estado) {
        EstadoTarea result = ESTADO_TAREA_MAP.get(estado);
        if (result == null) {
            throw new IllegalArgumentException("No es valido" + estado);
        }
        return result;
    }
}
