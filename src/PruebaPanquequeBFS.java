public class PruebaPanquequeBFS {
    public static void main(String[] args) {

        int[] estado = {3,4,2,1};
        Panqueque panqueque = new Panqueque(estado);
      
        NodoDeBusqueda inicio = new NodoDeBusqueda(panqueque);
        BusquedaBFS.buscar(inicio);
        
    }
    
}
