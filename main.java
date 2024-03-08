import Controller.Controller;
import Model.entity.Persona;
import Model.entity.Proyecto;
import Model.repo.RepoPersona;
import Model.repo.RepoProyecto;

public class main {
    public static void main(String[] args) {
         Controller controller = new Controller();
         controller.controllerMain();
        RepoPersona rp = RepoPersona.get_instance();
        for(Persona p : rp.getAll()){
            System.out.println(p);
        }
        RepoProyecto rpe = RepoProyecto.get_instance();
        for(Proyecto p : rpe.getAll()){
            System.out.println(p);
        }

    }
}
