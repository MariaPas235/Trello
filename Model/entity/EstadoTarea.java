package Model.entity;

import java.util.HashMap;
import java.util.Map;

public enum EstadoTarea{
  SININICIAR(1, "Sin iniciar"),
  PENDIENTE(2,"Pendiente"),
  ACABADA(3,"Acabada");
  private final int valor;
  private final String estado;
  private static final Map<String, EstadoTarea> ESTADO_TAREA_MAP;

  EstadoTarea(int valor, String estado) {
    this.valor = valor;
    this.estado = estado;
  }

  public int getValor() {
    return valor;
  }

  static {
      ESTADO_TAREA_MAP = new HashMap<>();
      for(EstadoTarea estadotarea : values()){
        ESTADO_TAREA_MAP.put(estadotarea.estado, estadotarea);
      }
  }
  public static EstadoTarea fromEstado (String estado){
    EstadoTarea result = ESTADO_TAREA_MAP.get(estado);
    if (result == null){
      throw new IllegalArgumentException("No es valido" + estado);
    }
    return result;
  }
}
