package it.univr.grafi;

public class Main {
	
	public static void main(String[] args) {
		testDjikstra();
		TestMst();
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
		int m =AlgoritmiElementari.FordFulkerson(grafo, a, d);
		//System.out.println( m);
		
		Grafo grafo2 = new GrafoOrientato();
		grafo2.addNode(a,b,c,d);
		ab = new Arco(a,b,0,1000000,0,0);
		Arco ac = new Arco(a,c,0,1000000,0,0);
		bc = new Arco(b,c,0,1,0,0);
		cd = new Arco(c,d,0,1000000,0,0);
		Arco bd = new Arco(b,d,0,1000000,0,0);
		grafo2.aggiungiArco(a, ab);
		grafo2.aggiungiArco(a, ac);
		grafo2.aggiungiArco(b, bc);
		grafo2.aggiungiArco(b, bd);
		grafo2.aggiungiArco(c, cd);
		m = AlgoritmiElementari.FordFulkerson(grafo2, a, d);
		System.out.println(m);
	}
	public static void testDjikstra() {
		Grafo grafo = new GrafoOrientato();
		Nodo s = new Nodo("s");
		Nodo t = new Nodo("t");
		Nodo x = new Nodo("x");
		Nodo y = new Nodo("y");
		Nodo z = new Nodo("z");
		grafo.addNode(s,t,x,y,z);
		Arco st = new Arco(s, t, 10);
		Arco tx = new Arco(t, x, 1);
		Arco ty = new Arco(t, y, 2);
		Arco xz = new Arco(x, z, 4);
		Arco sy = new Arco(s, y, 5);
		Arco yt = new Arco(y, t, 3);
		Arco yx = new Arco(y, x, 9);
		Arco yz = new Arco(y, z, 2);
		Arco zx = new Arco(z,x,6);
		grafo.aggiungiArco(st);
		grafo.aggiungiArco(tx);
		grafo.aggiungiArco(ty);
		grafo.aggiungiArco(xz);
		grafo.aggiungiArco(sy);
		grafo.aggiungiArco(yt);
		grafo.aggiungiArco(yx);
		grafo.aggiungiArco(yz);
		grafo.aggiungiArco(zx);
		AlgoritmiElementari.Djikstra(grafo, s);
		System.out.println(grafo.getVertici());
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
		Grafo grafo = new GrafoOrientato();
		Nodo s = new Nodo("s");
		Nodo t = new Nodo("t");
		Nodo x = new Nodo("x");
		Nodo y = new Nodo("y");
		Nodo z = new Nodo("z");
		grafo.addNode(s,t,x,y,z);
		Arco st = new Arco(s, t, 10);
		Arco tx = new Arco(t, x, 1);
		Arco ty = new Arco(t, y, 2);
		Arco xz = new Arco(x, z, 4);
		Arco sy = new Arco(s, y, 5);
		Arco yt = new Arco(y, t, 3);
		Arco yx = new Arco(y, x, 9);
		Arco yz = new Arco(y, z, 2);
		Arco zx = new Arco(z,x,6);
		grafo.aggiungiArco(st);
		grafo.aggiungiArco(tx);
		grafo.aggiungiArco(ty);
		grafo.aggiungiArco(xz);
		grafo.aggiungiArco(sy);
		grafo.aggiungiArco(yt);
		grafo.aggiungiArco(yx);
		grafo.aggiungiArco(yz);
		grafo.aggiungiArco(zx);
		
		AlgoritmiElementari.MstPrim(grafo, s);
		System.out.println(grafo.getVertici());
	}
}
