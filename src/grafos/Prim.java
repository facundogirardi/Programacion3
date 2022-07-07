package grafos;

import java.util.ArrayList;

import auxiliares.GrafoDinamic;
import auxiliares.NodoArista;
import auxiliares.NodoGrafo;

public class Prim {
	
	public static int menorArista(ArrayList<NodoArista> array ) {
		// Tope de peso
		int menor = 10000;
		int posicion = -1;
		for(int i = 0; i < array.size(); i++) {
			if(array.get(i).getPeso() < menor && !array.get(i).getApunta().Visitado) {
				menor = array.get(i).getPeso() ; 
				posicion = i;
			}
		}
		return posicion;	
	}
	
	public static GrafoDinamic prim(NodoGrafo nodo) {
		ArrayList<NodoArista> aristas = new ArrayList<NodoArista>(); 
		ArrayList<NodoGrafo> nodos = new ArrayList<NodoGrafo>();
			
		NodoGrafo auxNodo = nodo;
		NodoArista aux; 
		auxNodo.Visitado = true;
		GrafoDinamic arbol = new GrafoDinamic();
		int indice = 0;
		arbol.agregarVertice(nodo.valor);	
		nodos.add(nodo);
	while(!nodos.isEmpty()){
			aux = auxNodo.lista;
			while(aux != null) {
				if(!aux.isVisitado()) {
					aristas.add(aux);
					aux.setVisitado(true);
				}
				aux = aux.getSig();
			}
			
			indice = menorArista(aristas);
			if(indice != -1) {
				aux = aristas.get(indice);
				arbol.agregarVertice(aux.getApunta().valor);
				aux.getApunta().Visitado = true;
				arbol.agregarArista(aux.getOrigen(), aux.getApunta().valor, aux.getPeso());			
				aristas.remove(indice);
				nodos.add(aux.getApunta());
				auxNodo = aux.getApunta();
			}else {
				return arbol;
			}
			
		}
		return arbol;
	}
	
	public static void main(String[] args) {
		GrafoDinamic grafo = new GrafoDinamic();

		// Creo vertices
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);
		
		// Creo aristas con su peso
		grafo.agregarArista(1, 3, 1);
		grafo.agregarArista(3, 1, 1);
		
		grafo.agregarArista(1, 4, 5);
		grafo.agregarArista(4, 1, 5);
		
		grafo.agregarArista(1, 2, 6);
		grafo.agregarArista(2, 1, 6);
		
		grafo.agregarArista(2, 3, 5);
		grafo.agregarArista(3, 2, 5);
		
		grafo.agregarArista(3, 4, 5);
		grafo.agregarArista(4, 3, 5);
		
		grafo.agregarArista(3, 5, 6);
		grafo.agregarArista(5, 3, 6);
		
		grafo.agregarArista(3, 6, 4);
		grafo.agregarArista(6, 3, 4);
		
		grafo.agregarArista(2, 5, 3);
		grafo.agregarArista(5, 2, 3);
		
		grafo.agregarArista(4, 6, 2);
		grafo.agregarArista(6, 4, 2);
		
		grafo.agregarArista(5, 6, 6);
		grafo.agregarArista(6, 5, 6);
		
		// Elijo el nodo que utilizo como origen
		int nodoInicial = 1;	
		
		System.out.println("Algoritmo de Prim" );
		System.out.println("-----------------");
		NodoGrafo origen = grafo.encontrarNodo(nodoInicial);
		System.out.println("Nodo origen : " + origen.valor);
		prim(origen).mostrarMatriz();
		
	}

}