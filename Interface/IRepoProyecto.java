package Interface;

import Model.entity.Proyecto;

import java.util.Collection;

public interface IRepoProyecto {
    Proyecto add(Proyecto data);
    Proyecto getByID(String id);
    boolean getByName(String Name);
    Collection<Proyecto> getAll();
    Proyecto update(Proyecto data);
    boolean delete(String nombreProyecto);
    boolean save ();

}
