package Trabalho2;

import java.util.LinkedList;

public class teste {
	private static int contador = 1;
	private static LinkedList<Character> alfabeto = new LinkedList<>();

	public static void populaListaAlfabeto() {
		alfabeto.add('a');
		alfabeto.add('b');
		alfabeto.add('c');
		alfabeto.add('d');
		alfabeto.add('e');
		alfabeto.add('f');
		alfabeto.add('g');
		alfabeto.add('h');
		alfabeto.add('i');
		alfabeto.add('j');
		alfabeto.add('k');
		alfabeto.add('l');
		alfabeto.add('m');
		alfabeto.add('n');
		alfabeto.add('o');
		alfabeto.add('p');
		alfabeto.add('q');
		alfabeto.add('r');
		alfabeto.add('s');
		alfabeto.add('t');
		alfabeto.add('u');
		alfabeto.add('v');
		alfabeto.add('w');
		alfabeto.add('x');
		alfabeto.add('y');
		alfabeto.add('z');
	}

	public static String modeloImpressao() {
		return "Case#" + contador + ":\n";
	}

	public static void imprimeResultado(Grafo g) {
		AlgoritmoEstruturaConjuntosDisjuntos a = new AlgoritmoEstruturaConjuntosDisjuntos(g);
		boolean primeira = true;

		System.out.print(modeloImpressao());

		for (LinkedList<Integer> c : a.getLista()) {
			if (!primeira) {
				System.out.println();
			}
			primeira = false;
			for (Integer v : c) {
				System.out.print(alfabeto.get(v) + ",");
			}
		}
		System.out.println();
		System.out.println(a.getLista().size() + " connected components.");
		System.out.println();

		contador++;
	}

	public static void main(String[] args) {
		// Cria a lista com o alfabeto
		populaListaAlfabeto();

		// Esses testes sao os exemplos do enunciado
		// teste 1
		int qtdVertices1 = 3;
		Grafo g1 = new Grafo(qtdVertices1);
		g1.addArresta(alfabeto.indexOf('a'), alfabeto.indexOf('c'));
		imprimeResultado(g1);

		// teste 2
		int qtdVertices2 = 10;
		Grafo g2 = new Grafo(qtdVertices2);

		g2.addArresta(alfabeto.indexOf('a'), alfabeto.indexOf('b'));
		g2.addArresta(alfabeto.indexOf('a'), alfabeto.indexOf('c'));
		g2.addArresta(alfabeto.indexOf('a'), alfabeto.indexOf('g'));
		g2.addArresta(alfabeto.indexOf('b'), alfabeto.indexOf('c'));
		g2.addArresta(alfabeto.indexOf('c'), alfabeto.indexOf('g'));
		g2.addArresta(alfabeto.indexOf('e'), alfabeto.indexOf('d'));
		g2.addArresta(alfabeto.indexOf('d'), alfabeto.indexOf('f'));
		g2.addArresta(alfabeto.indexOf('h'), alfabeto.indexOf('i'));
		g2.addArresta(alfabeto.indexOf('i'), alfabeto.indexOf('j'));
		g2.addArresta(alfabeto.indexOf('j'), alfabeto.indexOf('h'));
		imprimeResultado(g2);

		// teste 3
		int qtdVertices3 = 6;
		Grafo g3 = new Grafo(qtdVertices3);

		g3.addArresta(alfabeto.indexOf('a'), alfabeto.indexOf('b'));
		g3.addArresta(alfabeto.indexOf('b'), alfabeto.indexOf('c'));
		g3.addArresta(alfabeto.indexOf('c'), alfabeto.indexOf('a'));
		g3.addArresta(alfabeto.indexOf('e'), alfabeto.indexOf('f'));
		imprimeResultado(g3);
	}
}
