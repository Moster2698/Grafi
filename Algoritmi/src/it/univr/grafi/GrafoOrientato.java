package it.univr.grafi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class GrafoOrientato extends Grafo {

	private int links;
	public GrafoOrientato() {
		super();
		links = 1;
	}
	public GrafoOrientato(HashMap<Nodo, LinkedList<Arco>> grafo) {
		super(grafo);
	}
	@Override
	public void aggiungiArco(Nodo nodeParent, Nodo nodeToAdd,int peso) {
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
		if(!grafo.get(nodeParent).contains(new Arco(nodeToAdd,peso)))
		{
			links++;
			grafo.get(nodeParent).add(new Arco(nodeToAdd,peso));
		
			
		}
	}
	public void aggiungiArco(Nodo sorgente, Nodo destinazione) {
		aggiungiArco(sorgente, destinazione,0);
	}
	
	public void rimuoviCollegamenti() {
		for(Entry<Nodo,LinkedList<Arco>> entry : grafo.entrySet()) {
			entry.getValue().clear();
		}
		archi.clear();
			
		links=0;
	}

}
