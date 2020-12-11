package Trabalho2;

public class Grafo {
	private Vertice[] ListaVertices;
	
	public Grafo(int v) {
		setListaVertices(new Vertice[v]);
		for (int i = 0; i < v; i++) {
			getListaVertices()[i] = new Vertice(i);
		}
	}
	
	protected Vertice[] getListaVertices() {
		return ListaVertices;
	}

	protected void setListaVertices(Vertice[] listaVertices) {
		ListaVertices = listaVertices;
	}

	// Metodo que cria as arrestas
	protected void addArresta(int v1, int v2) {
		getListaVertices()[v1].getAdjacente().add(getListaVertices()[v2]);
		if (v1 != v2)
			getListaVertices()[v2].getAdjacente().add(getListaVertices()[v1]); 
	}
}
