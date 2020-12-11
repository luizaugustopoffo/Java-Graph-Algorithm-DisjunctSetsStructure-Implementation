package Trabalho2;

import java.util.LinkedList;

public class Vertice {
	private int nome;
	private LinkedList<Vertice> adjacente;

	public Vertice(int nome) {
		setNome(nome);
		setAdjacente(new LinkedList<>());
	}

	protected int getNome() {
		return nome;
	}

	protected void setNome(int nome) {
		this.nome = nome;
	}

	protected LinkedList<Vertice> getAdjacente() {
		return adjacente;
	}

	protected void setAdjacente(LinkedList<Vertice> adjacente) {
		this.adjacente = adjacente;
	}
}
