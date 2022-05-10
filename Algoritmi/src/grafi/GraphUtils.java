package grafi;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Map.Entry;

import utils.Name;
public class GraphUtils {
	private static Random r = new Random();
	public static Grafo CreaGrafoOrientatoConnesso(int numeroVertici) {
		Grafo g = new GrafoOrientato();
		LinkedList<Nodo> vertici =  createNodes(numeroVertici);
		g.addNode(vertici);
		ConnettiNodi(g, numeroVertici);
		while(!GrafoConnesso(g)) {
			g.RimuoviCollegamenti();
			ConnettiNodi(g, numeroVertici);
		}
		return g;
	}
	private static void ConnettiTuttiInodi(Grafo g,int numeroVertici) {
		List<Nodo> vertici = g.getVertici();
			for(int i=0;i<numeroVertici;i++) {
						g.linkNode(vertici.get(r.nextInt(vertici.size())), vertici.get(r.nextInt(vertici.size())));
			}
	}
	private static void ConnettiNodi(Grafo g,int links) {
			ConnettiTuttiInodi(g, links);
		
	}
	private static boolean vis1[];
	private static boolean vis2[];
	private static boolean GrafoConnesso(Grafo g) {
		vis1 = new boolean[g.getVertici().size()];
		vis2 = new boolean[g.getVertici().size()];
		Grafo trasposto = trasponiGrafo(g);
		DFS(g,vis1);
		DFS(trasposto,vis2);
		for(int i=0;i<vis1.length;i++) {
			if((!vis1[i] || !vis2[i]))
				return false;
		}
		return true;
	}
	private static void  DFS(Grafo grafo,boolean[] arr) {
		Arrays.fill(arr, false);
		List<Nodo> vertici = grafo.getVertici();
		for(Nodo v : vertici) {
			v.setColor("white");
			v.setNodeParent(null);
		}
		Nodo v = vertici.get(0);
		DFSVisit(v,grafo,arr);
	}
	private static void DFSVisit(Nodo u,Grafo grafo,boolean[] arr) {
		u.setColor("gray");
		arr[u.getID()] = true;
		if(grafo.getAdjLinkedList(u)!=null) {
			for(Nodo v : grafo.getAdjLinkedList(u)) {
				if(v.getColor().equalsIgnoreCase("white")) {
					v.setNodeParent(u);
					DFSVisit(v, grafo,arr);
				}
			}	
		}
		u.setColor("Black");
	}
	private static LinkedList<Nodo> createNodes(int size) {
		LinkedList<Nodo> listaNodi = new LinkedList<Nodo>();
		int time = 0;
		while( time < size) {
			Nodo tmp = new Nodo(Name.getRandomName());
			if(!listaNodi.contains(tmp))
			{
				listaNodi.add(tmp);
				time++;
			}
		}
		return listaNodi;
	}
	private static Grafo trasponiGrafo(Grafo grafo) {
		HashMap<Nodo, LinkedList<Nodo>> transposedGraph = new HashMap<Nodo, LinkedList<Nodo>>();
		for(Nodo v : grafo.getVertici()) {
			transposedGraph.put(v,new LinkedList<Nodo>());
		}
		for(Entry<Nodo,LinkedList<Nodo>> entry : grafo.getRappresentazione().entrySet()) {
			for(Nodo n : entry.getValue()) {
				transposedGraph.get(n).add(entry.getKey());
			}
		}
		return new GrafoOrientato(transposedGraph);
	}
}
