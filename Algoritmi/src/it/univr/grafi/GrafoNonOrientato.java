package it.univr.grafi;

import java.util.LinkedList;
import java.util.Map.Entry;

public class GrafoNonOrientato extends Grafo {

	public GrafoNonOrientato() {
		super();
	}
	@Override
	public void linkNode(Nodo nodeParent, Nodo nodeToAdd,int peso) {
		if(nodeParent==null || nodeToAdd ==null) {
			throw new IllegalArgumentException("Uno dei due valori inseriti è nullo");
		}
		if(!grafo.containsKey(nodeParent))
			throw new IllegalArgumentException("Il grafo non contiene il nodo "+ nodeParent);
		if(!grafo.containsKey(nodeToAdd))
			throw new IllegalArgumentException("Il grafo non contiene il nodo "+ nodeToAdd);
		if(!grafo.get(nodeParent).contains(new Arco(nodeToAdd,peso)))
		{
			grafo.get(nodeParent).add(new Arco(nodeToAdd,peso));
			grafo.get(nodeToAdd).add(new Arco(nodeParent,peso));
		}
	}
	public void RimuoviCollegamenti() {
		for(Entry<Nodo,LinkedList<Arco>> entry : grafo.entrySet()) {
			entry.getValue().clear();
		}
	}

}
