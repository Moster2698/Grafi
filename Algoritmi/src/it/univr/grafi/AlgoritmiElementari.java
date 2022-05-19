package it.univr.grafi;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import it.univr.Structures.MinHeap;

 public class AlgoritmiElementari {

	public static void  BFS(Grafo grafo,Nodo s) {
		if(!grafo.ContieneNodo(s))
			throw new IllegalArgumentException("Il nodo inserito non è presente nel grafo");
		List<Nodo> vertici = grafo.getVertici();
		vertici.remove(s);
		for(Nodo nodo : vertici) {
			nodo.setColor("white");
			nodo.setDistance(Integer.MAX_VALUE);
			nodo.setNodeParent(null);
		}
		s.setColor("gray");
		s.setDistance(0);
		s.setNodeParent(null);
		Queue<Nodo> coda = new LinkedList<Nodo>();
		coda.add(s);
		while(!coda.isEmpty()) {
			Nodo u = coda.poll();
			System.out.println(u.getName());
			for(Nodo v : grafo.getAdjLinkedList(u)) {
				if(v.getColor().equals("white")) {
					v.setColor("gray");
					v.setDistance(u.getDistance()+1);
					v.setNodeParent(u);
					coda.add(v);
				}
			}
			u.setColor("black");
		}
	}
	private static int TIME;
	private static boolean vis[];
	public static boolean DFS(Grafo grafo) {
		List<Nodo> vertici = grafo.getVertici();
		vis=new boolean[vertici.size()];
		for(Nodo v : vertici) {
			v.setColor("white");
			v.setNodeParent(null);
		}
		TIME = 0;
		for(Nodo v : vertici) {
			if(v.getColor().equalsIgnoreCase("white"))
				DFSVisit(v,grafo);
		}
	
		for(int i=0;i<vis.length;i++) {
			System.out.println(vis[i]);
			if(!vis[i])
				return false;
		}
		return true;
	}
	private static void DFSVisit(Nodo u,Grafo grafo) {
		u.setColor("gray");
		u.setDtime(TIME++);
		vis[u.getID()] = true;
		if(grafo.getAdjLinkedList(u)!=null) {
			for(Nodo v : grafo.getAdjLinkedList(u)) {
				if(v.getColor().equalsIgnoreCase("white")) {
					v.setNodeParent(u);
					DFSVisit(v, grafo);
				}
			}	
		}
		u.setColor("Black");
		u.setFtime(TIME++);
	}
	public static void MstPrim(Grafo g,Nodo r){
		MinHeap<Nodo> q = new MinHeap<Nodo>(g.getVertici().size() ,new Comparator<Nodo>() {	
			@Override
			public int compare(Nodo o1, Nodo o2) {
				return o1.key - o2.key;
			}
		});
		for(Nodo v : g.getVertici()) {
			v.key = Integer.MAX_VALUE;
			v.setNodeParent(null);
			q.Insert(v);
		}
		r.key = 0;	
		int somma=0;
 	//	MinHeap<Nodo> queue = new MinHeap<Nodo>(cmp,g.getVertici().toArray(new Nodo[g.getVertici().size()]));
		while(!q.isEmpty()) {
			System.out.println(q);
			Nodo u  = q.ExtractMin();
			List<Nodo> verticiAdiacenti = g.getAdjLinkedList(u);
			for(Nodo v : verticiAdiacenti) {
				int pesoArco = g.peso(u, v);
				if(q.contains(v) && pesoArco < v.key) {
					v.setNodeParent(u);
					v.key=pesoArco;
					q.DecreaseKey(q.indexOf(v), v);
				}
			}
		}
		for(Nodo n : g.getVertici())
			somma+=n.key;
		printMstPrim(g);
		System.out.println(somma);
	}
	private static void printMstPrim(Grafo g) {
		for(Nodo nodo : g.getVertici()) {
			System.out.println(nodo + " parente : " + nodo.getParent());
		}
	}
}
