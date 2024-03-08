package serializator;

import java.io.*;

public class Serializator {

    /**
     * Método que serializa en disco cualquier tipo de objeto serializable
     * @param obj debe ser un objeto que implemente la interfaz Serialize
     * @param filename nombre del archivo donde serializar el objeto
     * @return true si ha ido correctamente
     * @param <T> Tipo de Objeto a serializar
     */
    public static<T> boolean Serialize(T obj,String filename){
        boolean result = false;
        try(ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filename)
        )){
            oos.writeObject(obj);
            result=true;
        }catch (IOException e){

        }

        return  result;
    }
    public static <T> T desearize(String filename){
        T result = null;
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filename)
        )){
            result=(T)ois.readObject();
        }catch (IOException | ClassNotFoundException e){

        }
        return result;
    }
}