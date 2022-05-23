package it.univr.grafi;

public class Main {
	
	public static void main(String[] args) {
		testFF();
	}
	
	public static void testFF() {
		Grafo grafo = new GrafoOrientato();
		Nodo a = new Nodo("a");
		Nodo b = new Nodo("b");
		Nodo c = new Nodo("c");
		Nodo d = new Nodo("d");
		Nodo e = new Nodo("e");
		Nodo f = new Nodo("f");
		
		grafo.addNode(a,b,c,d,e,f);
		Arco ab = new Arco(a,b, 0, 16, 0, 0);
		Arco bc = new Arco(b,c, 0, 12, 0, 0);
		Arco cd = new Arco(c,d, 0, 20, 0, 0);
		Arco ae = new Arco(a,e, 0, 13, 0, 0);
		Arco ef = new Arco(e,f, 0, 14, 0, 0);
		Arco eb = new Arco(e,b, 0, 4, 0, 0);
		Arco ce = new Arco(c,e, 0, 9, 0, 0);
		Arco fc = new Arco(f,c, 0, 7, 0, 0);
		Arco fd = new Arco(f,d, 0, 4, 0, 0);
		grafo.aggiungiArco(a, ae);
		grafo.aggiungiArco(a, ab);
		grafo.aggiungiArco(b, bc);
		grafo.aggiungiArco(c, cd);
		grafo.aggiungiArco(c, ce);
		grafo.aggiungiArco(e, eb);
		grafo.aggiungiArco(e, ef);
		grafo.aggiungiArco(f, fc);
		grafo.aggiungiArco(f, fd);
		AlgoritmiElementari.FordFulkerson(grafo, a, d);
		System.out.println(grafo);
	}
	public static void testBfs() {
		Grafo grafo = new GrafoOrientato();
		Nodo a = new Nodo("a");
		Nodo b = new Nodo("b");
		Nodo c = new Nodo("c");
		Nodo d = new Nodo("d");
		Nodo e = new Nodo("e");
		Nodo f = new Nodo("f");
		
		grafo.addNode(a,b,c,d,e,f);
		Arco ab = new Arco(a,b, 0, 16, 11, 5);
		Arco bc = new Arco(b,c, 0, 12, 12, 0);
		Arco cd = new Arco(c,d, 0, 20, 15, 5);
		Arco ae = new Arco(a,e, 0, 13, 8, 5);
		Arco ef = new Arco(e,f, 0, 14, 11, 3);
		Arco eb = new Arco(e,b, 0, 4, 1, 3);
		Arco ce = new Arco(c,e, 0, 9, 4, 5);
		Arco fc = new Arco(f,c, 0, 7, 7, 0);
		Arco fd = new Arco(f,d, 0, 4, 4, 0);
		grafo.aggiungiArco(a, ae);
		grafo.aggiungiArco(a, ab);
		grafo.aggiungiArco(b, bc);
		grafo.aggiungiArco(c, cd);
		grafo.aggiungiArco(c, ce);
		grafo.aggiungiArco(e, eb);
		grafo.aggiungiArco(e, ef);
		grafo.aggiungiArco(f, fc);
		grafo.aggiungiArco(f, fd);
		Grafo path = AlgoritmiElementari.BfsPath(AlgoritmiElementari.creaReteResidua(grafo), a, d);
		System.out.println(path);
	
	}
	public static void TestMst() {
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
		
		AlgoritmiElementari.BFS(grafo, a);
	}
}
