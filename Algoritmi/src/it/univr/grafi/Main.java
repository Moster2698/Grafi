package it.univr.grafi;

public class Main {
	
	public static void main(String[] args) {
		Grafo grafo = new GrafoNonOrientato();
		Nodo a = new Nodo("a");
		Nodo b = new Nodo("b");
		Nodo c = new Nodo("c");
		Nodo d = new Nodo("d");
		Nodo e = new Nodo("e");
		Nodo f = new Nodo("f");
		Nodo g = new Nodo("g");
		Nodo h = new Nodo("h");
		Nodo i = new Nodo("i");
		
		grafo.addNode(a,b,c,d,e,f,g,h,i);
		
		grafo.aggiungiArco(a, b, 4);
		grafo.aggiungiArco(a, h, 8);
		
		grafo.aggiungiArco(b, c, 8);
		grafo.aggiungiArco(b, h, 11);
		
		grafo.aggiungiArco(c, d, 7);
		grafo.aggiungiArco(c, i, 2);
		grafo.aggiungiArco(c, f, 4);
		
		grafo.aggiungiArco(d, e, 9);
		grafo.aggiungiArco(d, f, 14);
		
		grafo.aggiungiArco(e, f, 10);
		
		grafo.aggiungiArco(f, g, 2);
		
		grafo.aggiungiArco(g, h, 1);
		grafo.aggiungiArco(g, i, 6);
		
		grafo.aggiungiArco(h, i, 7);
		
		AlgoritmiElementari.MstPrim(grafo, a);
	}
}
