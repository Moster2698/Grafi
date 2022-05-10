package grafi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class GrafoOrientato extends Grafo {

	private int links;
	public GrafoOrientato() {
		super();
		links = 1;
	}
	public GrafoOrientato(HashMap<Nodo, LinkedList<Nodo>> grafo) {
		super(grafo);
	}
	@Override
	public void linkNode(Nodo nodeParent, Nodo nodeToAdd) {
		if(nodeParent==null || nodeToAdd ==null) {
			throw new IllegalArgumentException("Uno dei due valori inseriti è nullo");
		}
		if(links>Math.pow(getVertici().size(),2)) {
			throw new ArrayIndexOutOfBoundsException("Il numero dei nodi è troppo elevato");
		}
		if(!grafo.containsKey(nodeParent))
			throw new IllegalArgumentException("Il grafo non contiene il nodo "+ nodeParent);
		if(!grafo.containsKey(nodeToAdd))
			throw new IllegalArgumentException("Il grafo non contiene il nodo "+ nodeToAdd);
		if(!grafo.get(nodeParent).contains(nodeToAdd))
		{
			links++;
			grafo.get(nodeParent).add(nodeToAdd);
		}
	}
	public void RimuoviCollegamenti() {
		for(Entry<Nodo,LinkedList<Nodo>> entry : grafo.entrySet()) {
			entry.getValue().clear();
		}
		links=0;
	}

}
