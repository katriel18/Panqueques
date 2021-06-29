
import java.util.ArrayList;

public class PruebaSucesoresPanqueques {
    public static void main(String[] args) {

        int[] estado = {3,4,2,1};
        Panqueque panqueque = new Panqueque(estado);
        System.out.println("Estado panqueque:\n");
        panqueque.mostrarEstado();
        System.out.println("");
        System.out.println("Sucesores:\n");
        ArrayList<Estado> sucesores = panqueque.generarSucesores();
        for(Estado x:sucesores){
            x.mostrarEstado();
            System.out.println("");
        }
    }

    
    
}
