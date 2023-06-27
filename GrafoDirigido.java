
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GrafoDirigido<T> implements Grafo<T> {
	private Map<Integer, ArrayList<Arco<T>>> nodos = new HashMap<>();
	

	@Override
	public void agregarVertice(int verticeId) {
		nodos.putIfAbsent(verticeId, new ArrayList<>());
	}

	public void print() {
		for (Integer k : nodos.keySet()) {
			System.out.println("-> KEY: " + k + " - VALUE: " + nodos.get(k).toString());
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		if (nodos.containsKey(verticeId)) {
			nodos.remove(verticeId);
			for (ArrayList<Arco<T>> adyacentes : nodos.values()) {
				adyacentes.removeIf(arco -> arco.getVerticeDestino() == verticeId);
			}
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if (nodos.containsKey(verticeId1) && nodos.containsKey(verticeId2)) {
			Arco newArco = new Arco<T>(verticeId1, verticeId2, etiqueta);
			nodos.get(verticeId1).add(newArco);
		}else{
			System.out.println("No fue posible agregar el arco");
		}

	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if (nodos.containsKey(verticeId1) && nodos.containsKey(verticeId2)) {
			ArrayList<Arco<T>> arcos = nodos.get(verticeId1);
			Iterator<Arco<T>> it = arcos.iterator();
			while (it.hasNext()) {
				Arco<T> arco = it.next();
				if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
					it.remove();
				}
			}
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return nodos.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		// if(nodos.containsKey(verticeId1) && nodos.containsKey(verticeId2))
		// 	ArrayList<Arco<T>> arcos = nodos.get(verticeId1);
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cantidadVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cantidadArcos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

}