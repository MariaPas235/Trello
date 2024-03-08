package Interface;

import Model.entity.Proyecto;
import java.util.Collection;

//Funciones que se implementan en la clase de repo de proyectos
public interface IRepoProyecto {
    Proyecto add(Proyecto data);
    Proyecto getByID(String id);
    boolean getByName(String Name);
    Collection<Proyecto> getAll();
    Proyecto update(Proyecto data);
    boolean delete(String nombreProyecto);
    boolean save ();

}
