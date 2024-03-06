package Model.entity;

import java.util.HashMap;
import java.util.Map;

public enum RangoPersona {
    JEFE("Jefe"),
    COLABORADOR("Colaborador");
    //Atributos del enum inicializados en final ya que siempren van a ser esos valores asginados
    private final String estado;
    //Map es un mapa estatico que asigna el nombre del estado con la instancia correcta del enum
    private static final Map<String, RangoPersona> RANGO_PERSONA_MAP;

    //RANGO_PERSONA_MAP contiene todas las combinaciones posibles de estados con su instancia correspondiente
    RangoPersona(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    /**
     * static: este metodo estatico crea un HashMap con la variable RANGO_PERSONA_MAP
     * for-each: Se recorren todos los valores del enum RangoPersona utilizando el método values()
     estadotarea agrega una entrada al mapa creado
     En estadotarea.estado la clave es el estado
     ESTADO_TAREA_MAP.put permite insertar un mapeo al mapa HashMAp
     Permite agregar una clave específica y el valor al que está asociada esa clave en un mapa particular.
     */
    static {
        RANGO_PERSONA_MAP = new HashMap<>();
        for (RangoPersona rangopersona : values()) {
            RANGO_PERSONA_MAP.put(rangopersona.estado, rangopersona);
        }
    }

    /**
     * El uso de este método es obtener una instancia de EstadoTarea a partir de un nombre de estado representado por la cadena estado
     *
     * @param estado es el nombre del estado
     * @return devuelve el nombre del estado escrito si es valido, si no, da un error de expcepcion
     */
    public static RangoPersona fromEstado(String estado) {
        RangoPersona result = RANGO_PERSONA_MAP.get(estado);
        if (result == null) {
            throw new IllegalArgumentException("No es valido" + estado);
        }
        return result;
    }
}

