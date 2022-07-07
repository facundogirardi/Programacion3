package grafos;

import java.util.ArrayList;

import auxiliares.GrafoDinamic;
import auxiliares.NodoArista;
import auxiliares.NodoGrafo;

public class DFS {

	public static ArrayList<Integer> dfsGrafo(GrafoDinamic grafo, NodoGrafo origen) {
		ArrayList<Integer> nodos = new ArrayList<Integer>();

		visitarNodo(origen, nodos);
		return nodos;
	}

	public static void visitarNodo(NodoGrafo nodo, ArrayList<Integer> lista) {
		nodo.Visitado = true;
		NodoArista aux = nodo.lista;

		while (aux != null) {
			if (!aux.getApunta().Visitado) {
				visitarNodo(aux.getApunta(), lista);
			} else {
				aux = aux.getSig();
			}
		}

		lista.add(nodo.valor);
	}

	public static void main(String[] args) {
		GrafoDinamic grafo = new GrafoDinamic();

		// Creo aristas
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);

		// No le asigno pesos a las aristas, ya que es opcional
		grafo.agregarArista(1, 2, 0);
		grafo.agregarArista(1, 4, 0);
		grafo.agregarArista(4, 2, 0);
		grafo.agregarArista(2, 5, 0);
		grafo.agregarArista(5, 4, 0);
		grafo.agregarArista(3, 5, 0);
		grafo.agregarArista(3, 6, 0);
		grafo.agregarArista(6, 6, 0);

		// Elijo el nodo que utilizo como origen
		int nodoInicial = 1;
		NodoGrafo origenNodo = grafo.encontrarNodo(nodoInicial);
		
		System.out.println("Ejecucion del algortimo DFS");
		System.out.println("---------------------------");
		System.out.println("Nodo origen : " + origenNodo.valor);
		ArrayList<Integer> primerEjecucionResultado = dfsGrafo(grafo, origenNodo);

		for (int i = primerEjecucionResultado.size() - 1; i >= 0; i--) {
			if (i != 0) {
				System.out.print(primerEjecucionResultado.get(i) + " --> ");
			} else {
				System.out.println(primerEjecucionResultado.get(i));
			}
		}
		

	}
}