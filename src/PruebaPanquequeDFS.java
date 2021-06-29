public class PruebaPanquequeDFS {
    public static void main(String[] args) {

        int[] estado = {3,4,2,1};
        Panqueque panqueque = new Panqueque(estado);
      
        NodoDeBusqueda inicio = new NodoDeBusqueda(panqueque);
        BusquedaDFS.buscar(inicio);
        
    }    
}
