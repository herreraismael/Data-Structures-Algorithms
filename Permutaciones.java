import java.util.ArrayList;
import java.util.List;

public class Permutaciones {
    public static void main(String[] args) {
        int[] conjunto = {1, 2, 3};
        List<List<Integer>> permutaciones = generarPermutaciones(conjunto);
        
        // Mostrar las permutaciones generadas
        for (List<Integer> permutacion : permutaciones) {
            System.out.println(permutacion);
        }
    }
    
    public static List<List<Integer>> generarPermutaciones(int[] conjunto) {
        List<List<Integer>> permutaciones = new ArrayList<>();
        permutacionesHelper(conjunto, new ArrayList<>(), permutaciones);
        return permutaciones;
    }
    
    private static void permutacionesHelper(int[] conjunto, List<Integer> permutacionActual, List<List<Integer>> permutaciones) {
        if (permutacionActual.size() == conjunto.length) {
            permutaciones.add(new ArrayList<>(permutacionActual));
        } else {
            for (int i = 0; i < conjunto.length; i++) {
                if (!permutacionActual.contains(conjunto[i])) {
                    permutacionActual.add(conjunto[i]);
                    permutacionesHelper(conjunto, permutacionActual, permutaciones);
                    permutacionActual.remove(permutacionActual.size() - 1);
                }
            }
        }
    }
}
