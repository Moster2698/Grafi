package grafi;

import java.util.LinkedList;
import java.util.Map.Entry;

public class GrafoNonOrientato extends Grafo {

	public GrafoNonOrientato() {
		super();
	}
	@Override
	public void linkNode(Nodo nodeParent, Nodo nodeToAdd) {
		if(nodeParent==null || nodeToAdd ==null) {
			throw new IllegalArgumentException("Uno dei due valori inseriti è nullo");
		}
		if(!grafo.containsKey(nodeParent))
			throw new IllegalArgumentException("Il grafo non contiene il nodo "+ nodeParent);
		if(!grafo.containsKey(nodeToAdd))
			throw new IllegalArgumentException("Il grafo non contiene il nodo "+ nodeToAdd);
		if(!grafo.get(nodeParent).contains(nodeToAdd))
		{
			grafo.get(nodeParent).add(nodeToAdd);
			grafo.get(nodeToAdd).add(nodeParent);
		}
	}
	public void RimuoviCollegamenti() {
		for(Entry<Nodo,LinkedList<Nodo>> entry : grafo.entrySet()) {
			entry.getValue().clear();
		}
	}

}
