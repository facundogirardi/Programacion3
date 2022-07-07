package auxiliares;
import java.util.Comparator;

public class NodoArista implements Comparable<NodoArista>{
	int peso;
	NodoArista sig;
	NodoGrafo apunta;
	boolean Visitado;
	int origen;
	
	public int compareTo(NodoArista aux) {
		if(this.peso < aux.peso) {
			return -1;
		}else if(this.peso > aux.peso) {
			return 1;
		}else {
			return 0;
		}
	}
	
		
	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public NodoGrafo getApunta() {
		return apunta;
	}

	public void setApunta(NodoGrafo apunta) {
		this.apunta = apunta;
	}

	public boolean isVisitado() {
		return Visitado;
	}

	public void setVisitado(boolean visitado) {
		Visitado = visitado;
	}

	public NodoArista getSig() {
		return sig;
	}

	public void setSig(NodoArista sig) {
		this.sig = sig;
	}

	public int getOrigen() {
		return origen;
	}

	public void setOrigen(int origen) {
		this.origen = origen;
	}

}
