package grafi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

public abstract class Grafo {

	protected HashMap<Nodo,LinkedList<Nodo>> grafo;
	private List<Nodo> vertici;
	private final Random random = new Random();
	public Grafo() {
		grafo = new HashMap<Nodo,LinkedList<Nodo>>();
		vertici = new LinkedList<Nodo>();
	}
	public Grafo(HashMap<Nodo, LinkedList<Nodo>> grafo) {
		this.grafo = grafo;
		vertici = new LinkedList<Nodo>(grafo.keySet());
	}
	public void addNode(Nodo... nodi) {
		for(int i=0;i<nodi.length;i++) {
			if(!grafo.containsKey(nodi[i])) {
				grafo.put(nodi[i],new LinkedList<Nodo>());
				vertici.add(nodi[i]);
			}

		}
	}
	public abstract void linkNode(Nodo nodeParent,Nodo nodeToAdd);
	public abstract void RimuoviCollegamenti();
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Entry<Nodo,LinkedList<Nodo>> e : grafo.entrySet()) {
			sb.append(e.getKey().getName());
			//Se ci sono nodi adiacenti
			if(!e.getValue().isEmpty()) {
				sb.append("--->"+e.getValue());
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	public void PrintCharachteristics() {
		for(Nodo nodo : vertici)
			System.out.println(nodo);
	}
	public List<Nodo> getVertici(){
		return vertici;
	}
	public boolean ContieneNodo(Nodo nodoDaCercare) {
		return grafo.containsKey(nodoDaCercare);
	}
	public LinkedList<Nodo> getAdjLinkedList(Nodo n){
		return grafo.get(n);
	}
	public void addNode(LinkedList<Nodo> createNodes) {
		for(Nodo n: createNodes)
			addNode(n);
	}
	public HashMap<Nodo,LinkedList<Nodo>> getRappresentazione(){
		return grafo;
	}
	public void randomLink(int links) {
		for(int i=0;i<links;i++) {
			Nodo u = vertici.get(random.nextInt(vertici.size()));
			Nodo v = vertici.get(random.nextInt(vertici.size()));
			linkNode(u, v);
		}
	}
	public void Transpose() {
		HashMap<Nodo, LinkedList<Nodo>> transposedGraph = new HashMap<Nodo, LinkedList<Nodo>>();
		for(Entry<Nodo,LinkedList<Nodo>> entry : grafo.entrySet()) {
			for(Nodo n : entry.getValue()) {
				LinkedList<Nodo> tmp = null;
				if(!transposedGraph.containsKey(n)) {
					 tmp = new LinkedList<Nodo>();
					 transposedGraph.put(n,tmp);
				}
				tmp = transposedGraph.get(n);
				tmp.add(entry.getKey());
			}
		}
		grafo = transposedGraph;
	}

}
