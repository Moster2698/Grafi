package it.univr.grafi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

public abstract class Grafo {

	protected HashMap<Nodo,LinkedList<Arco>> grafo;
	private List<Nodo> vertici;
	protected List<Arco> archi;
	private final Random random = new Random();
	public Grafo() {
		grafo = new HashMap<Nodo,LinkedList<Arco>>();
		vertici = new LinkedList<Nodo>();
		archi = new LinkedList<Arco>();
	}	
	public Grafo(HashMap<Nodo, LinkedList<Arco>> grafo) {
		this.grafo = grafo;
		vertici = new LinkedList<Nodo>(grafo.keySet());
	}
	public void addNode(Nodo... nodi) {
		for(int i=0;i<nodi.length;i++) {
			if(!grafo.containsKey(nodi[i])) {
				grafo.put(nodi[i],new LinkedList<Arco>());
				vertici.add(nodi[i]);
			}

		}
	}
	public abstract void aggiungiArco(Nodo nodeParent,Nodo nodeToAdd,int peso);
	public abstract void aggiungiArco(Nodo parent,Arco a);
	
	public abstract void rimuoviCollegamenti();
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Entry<Nodo,LinkedList<Arco>> e : grafo.entrySet()) {
			//Se ci sono nodi adiacenti
			if(!e.getValue().isEmpty()) {
				sb.append(e.getValue());
				sb.append("\n");
			}
			
		}
		return sb.toString();
	}
	public void stampaVertici() {
		for(Nodo nodo : vertici)
			System.out.println(nodo);
	}
	public List<Nodo> getVertici(){
		return vertici;
	}
	public Arco getArco(Nodo u,Nodo v) {
		List<Arco> archi = grafo.get(u);
		for(Arco a : archi) {
			if(a.getDestinazione().equals(v))
				return a;
		}
		return null;
	}
	public void rimuoviArco(Nodo u,Nodo v) {
		if(grafo.containsKey(u)) {
			Arco a = getArco(u, v);
			grafo.get(u).remove(a);
			archi.remove(a);
		}
	}
	public boolean contieneNodo(Nodo nodoDaCercare) {
		return grafo.containsKey(nodoDaCercare);
	}
	public List<Arco> getArchiAdiacenti(Nodo n){
		return grafo.get(n);
	}
	public List<Nodo> getAdjLinkedList(Nodo n){
		List<Arco> archiAdiacenti = grafo.get(n);
		List<Nodo> nodiAdiacenti = new LinkedList<Nodo>();
		for(Arco a: archiAdiacenti)
			nodiAdiacenti.add(a.getDestinazione());
		return nodiAdiacenti;
	}
	public void addNode(LinkedList<Nodo> createNodes) {
		for(Nodo n: createNodes)
			addNode(n);
	}
	public HashMap<Nodo,LinkedList<Arco>> getRappresentazione(){
		return grafo;
	}
	public int peso(Nodo u, Nodo v) {
		List<Arco> archi = grafo.get(u);
		for(Arco a : archi) {
			if(a.getDestinazione().equals(v))
				return a.getPeso();
		}
		throw new IllegalArgumentException("Il nodo v non ?? un nodo adiacente");
	}
	public void randomLink(int links) {
		for(int i=0;i<links;i++) {
			Nodo u = vertici.get(random.nextInt(vertici.size()));
			Nodo v = vertici.get(random.nextInt(vertici.size()));
			aggiungiArco(u, v,0);
		}
	}
	public void trasponiGrafo() {
		HashMap<Nodo, LinkedList<Arco>> transposedGraph = new HashMap<Nodo, LinkedList<Arco>>();
		for(Entry<Nodo,LinkedList<Arco>> entry : grafo.entrySet()) {
			for(Arco a : entry.getValue()) {
				LinkedList<Arco> tmp = null;
				Nodo nodoAdiacente = a.getDestinazione();
				if(!transposedGraph.containsKey(nodoAdiacente)) {
					 tmp = new LinkedList<Arco>();
					 transposedGraph.put(nodoAdiacente,tmp);
				}
				tmp = transposedGraph.get(nodoAdiacente);
				tmp.add(new Arco(entry.getKey(),nodoAdiacente,a.getPeso()));
			}
		}
		grafo = transposedGraph;
	}
	public List<Arco> getArchi(){
		return archi;
	}
	public  abstract void aggiungiArco(Arco st);
}
