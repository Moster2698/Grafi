package it.univr.grafi;

import java.util.LinkedList;
import java.util.Random;

import it.univr.Structures.MinHeap;
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
		
		grafo.linkNode(a, b, 4);
		grafo.linkNode(a, h, 8);
		
		grafo.linkNode(b, c, 8);
		grafo.linkNode(b, h, 11);
		
		grafo.linkNode(c, d, 7);
		grafo.linkNode(c, i, 2);
		grafo.linkNode(c, f, 4);
		
		grafo.linkNode(d, e, 9);
		grafo.linkNode(d, f, 14);
		
		grafo.linkNode(e, f, 10);
		
		grafo.linkNode(f, g, 2);
		
		grafo.linkNode(g, h, 1);
		grafo.linkNode(g, i, 6);
		
		grafo.linkNode(h, i, 7);
		
		AlgoritmiElementari.MstPrim(grafo, a);
	}
}
