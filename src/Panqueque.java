
import java.util.ArrayList;
import java.util.Arrays;

public class Panqueque implements Estado {

    private final int TAM = 4;
    private final int[] META = { 1, 2, 3, 4 };
    private int[] panquequeActual;

    public Panqueque(int[] panqueque) {
        this.panquequeActual = panqueque;
    }

    private int[] getPanquequeActual() {
        return panquequeActual;
    }

    @Override
    public boolean esMeta() {
        if (Arrays.equals(panquequeActual, META))
            return true;
        return false;
    }

    private void intercambiarYGuardar(int cant, ArrayList<Estado> suc) {
        int aux;
        int[] resultado = Arrays.copyOf(panquequeActual, TAM); // Hace una copia del arreglo
        for (int i = 0; i < cant / 2; i++) {
            aux = resultado[i];
            resultado[i] = resultado[cant - i - 1];
            resultado[cant - i - 1] = aux;
        }
        suc.add((new Panqueque(resultado)));
    }

    @Override
    public ArrayList<Estado> generarSucesores() {
        ArrayList<Estado> sucesores = new ArrayList<Estado>();
        for (int i = 2; i <= 4; i++) {
            intercambiarYGuardar(i, sucesores);
        }
        return sucesores;
    }

    @Override
    public boolean igual(Estado e) {
        if (Arrays.equals(panquequeActual, ((Panqueque) e).getPanquequeActual()))
            return true;
        return false;
    }

    @Override
    public void mostrarEstado() {
        System.out.println("(" + panquequeActual[0] + ", " + panquequeActual[1] + ", " + panquequeActual[2] + ", "
                + panquequeActual[3] + ")");
    }
}
