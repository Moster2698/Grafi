package grafi;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
		System.out.println();
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
}
