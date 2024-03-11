package Model.repo;

import serializator.Serializator;

import java.io.Serializable;
import java.util.Collection;

public abstract class LibraryProyect<T,K> implements Serializable {
    public static LibraryProyect load(String filename){
        return Serializator.desearize(filename);
    }
    public  boolean save(String filename){
        return Serializator.Serialize(this,filename);
    }
    public abstract T add(T data);
    public abstract T getByID(K id);

    public abstract boolean getByName(String Name);

    public abstract Collection<T> getAll();
    public abstract T update(T data);
    public abstract boolean delete(K id);

}