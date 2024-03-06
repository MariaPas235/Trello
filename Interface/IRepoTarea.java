package Interface;

import Model.entity.Tarea;

import java.util.Collection;

public interface IRepoTarea {
    Tarea add(Tarea data);
    Tarea getByID(String id);
    boolean getByName(String Name);
    Collection<Tarea> getAll();
    Tarea update(Tarea data);
    boolean delete(String nombreTarea);
    boolean save ();
}
