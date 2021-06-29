import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Stack;

public class BusquedaBFS {
    public static void buscar(NodoDeBusqueda raiz){
        Queue<NodoDeBusqueda> cola = 
                new LinkedList<NodoDeBusqueda>();
        cola.add(raiz);
        realizarBusqueda(cola);
    }
    
    public static void realizarBusqueda(Queue<NodoDeBusqueda> cola){
        int contadorBusqueda = 1;
        
        while(!cola.isEmpty()){
            NodoDeBusqueda nodoTemp = cola.poll();
            if(nodoTemp.getEstadoActual().esMeta()){
                Stack<NodoDeBusqueda> caminoSolucion =
                        new Stack<NodoDeBusqueda>();
                caminoSolucion.push(nodoTemp);
                nodoTemp = nodoTemp.getPadre();
                
                while(nodoTemp != null && nodoTemp.getPadre() != null){
                    caminoSolucion.push(nodoTemp);
                    nodoTemp = nodoTemp.getPadre();
                }
                
                if(nodoTemp != null && nodoTemp.getPadre() == null)
                    caminoSolucion.push(nodoTemp);                
                
                int iteraciones = caminoSolucion.size(); 
                
                System.out.print("\nSolución:\n");
                for(int i=0; i < iteraciones; i++){
                    nodoTemp = caminoSolucion.pop();
                    nodoTemp.getEstadoActual().mostrarEstado();
                    //System.out.println("\n");
                }
                System.out.println("Número de nodos examinados: " + 
                        contadorBusqueda);
                System.exit(0);
            }
            else{
                ArrayList<Estado> sucesoresTemp = 
                        nodoTemp.getEstadoActual().generarSucesores();
                for (int i = 0; i < sucesoresTemp.size();i++){
                    NodoDeBusqueda nuevoNodo = new NodoDeBusqueda(nodoTemp,
                        sucesoresTemp.get(i));
                    if( !revisarRepetidos(nuevoNodo)){
                        cola.add(nuevoNodo);
                    }
                }
            }
            contadorBusqueda++;
        }
    }
    public static boolean revisarRepetidos(NodoDeBusqueda n){
      boolean resultado = false;
      NodoDeBusqueda nodoRevisado = n;
//      System.out.println("Revisado");
//      nodoRevisado.getEstadoActual().mostrarEstado();
      while(n.getPadre() != null && !resultado){
//          System.out.println("Padre");
//          n.getPadre().getEstadoActual().mostrarEstado();
          if(n.getPadre().getEstadoActual().igual(nodoRevisado.getEstadoActual()))
          {
              resultado = true;
          }
          n = n.getPadre();
      }
      return resultado;
    }
    
}
