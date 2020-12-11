package Trabalho2;

import java.util.LinkedList;

public class AlgoritmoEstruturaConjuntosDisjuntos {
	private LinkedList<LinkedList> listaDeConjuntos;
	
	// construtor
	public AlgoritmoEstruturaConjuntosDisjuntos(Grafo g) {
		listaDeConjuntos = new LinkedList<>();
		CONNECTEDCOMPONENTS(g);
		ordenaConjuntos();
	}

	// get lista
	public LinkedList<LinkedList> getLista() {
		return listaDeConjuntos;
	}

	// set lista
	private void setLista(LinkedList<LinkedList> lista) {
		this.listaDeConjuntos = lista;
	}

	// Define quantas e quais sao as componentes conexas
	private void CONNECTEDCOMPONENTS(Grafo g) {
		// Define um conjunto para cada vertice do grafo
		for (Vertice v : g.getListaVertices()) {
			makeSet(v.getNome());
		}

		for (Vertice v : g.getListaVertices()) {
			// Para cada adjacente de cada vertice faz-se a uniao de conjuntos caso ainda
			// nao tenha sido feita
			for (Vertice a : v.getAdjacente()) {
				if (!find(a.getNome()).equals(find(v.getNome()))) {
					union(a.getNome(), v.getNome());
				}
			}
		}
	}

	// makeSet
	private void makeSet(int vertice) {
		// Add na lista de conjuntos uma lista (conjunto) para cada vertice
		// Cada uma destas lista tem como conteudo o proprio vertice
		// Isso sao conjuntos de um elemento
		LinkedList<Integer> conjunto = new LinkedList<>();
		conjunto.add(vertice); 
		getLista().add(conjunto);
	}

	// find
	private LinkedList<Integer> find(int vertice) {
		// Retorna a lista (conjunto) que o vertice se encontra
		for (LinkedList<Integer> c : getLista()) {
			if (c.contains(vertice)) {
				return c;
			}
		}
		return null;
	}

	// union
	private void union(int vertice1, int vertice2) {
		// Encontra-se as listas (conjuntos) dos vertices recebidos
		LinkedList<Integer> l1 = find(vertice1);
		LinkedList<Integer> l2 = find(vertice2);

		// Remove-se essas listas (conjuntos) da lista de conjuntos
		getLista().remove(l1);
		getLista().remove(l2);

		// Repassamos todos elementos de uma das listas (conjuntos) para a outra(o)
		for (Integer v : l1) {
			l2.add(v);
		}
		// Add essa lista com os elementos de ambas a listas (conjuntos) na lista de conjuntos
		getLista().add(l2);
	}

	// Metodo para ordenar os conjuntos para a impressao
	private void ordenaConjuntos() {
		LinkedList<Integer> aux = new LinkedList<>();
		LinkedList<LinkedList> novaLista = new LinkedList<>();

		// Ordena em ordem crescente os vertices das listas (conjuntos) da lista de conjuntos
		// Adiciona na lista auxiliar o primeiro vertice de cada lista (conjunto) da lista de conjuntos
		// Esses vertices possuem o menor valor de cada lista (conjunto)
		for (LinkedList<Integer> c : getLista()) {
			c.sort(null);
			aux.add(c.getFirst());
		}

		// Ordena em ordem crecente a lista aux
		aux.sort(null);

		// Adiciona na nova lista as listas (conjuntos) da lista atual conforme a ordem da lista aux
		for (Integer v : aux) {
			for (LinkedList<Integer> c : getLista()) {
				if (c.contains(v)) {
					novaLista.add(c);
					getLista().remove(c);
					break;
				}
			}
		}
		// Faz um setLista que recebe como parametro a nova lista
		setLista(novaLista);
	}
}
