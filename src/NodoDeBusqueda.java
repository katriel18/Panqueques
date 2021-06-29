public class NodoDeBusqueda {
    private Estado estadoActual;
    private NodoDeBusqueda padre;
    
    //Constructor para la raiz
    public NodoDeBusqueda(Estado e){
        estadoActual = e;
        padre = null;
    }
    
    //Constructor para los otros nodos de búsqueda
    public NodoDeBusqueda(NodoDeBusqueda padre, Estado e) {
        this.estadoActual = e;
        this.padre = padre;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public NodoDeBusqueda getPadre() {
        return padre;
    }
}
