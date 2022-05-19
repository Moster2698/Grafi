package it.univr.grafi;

public class Arco implements Comparable<Arco>{
	private Nodo destinazione;
	private int peso;
	
	public Arco(Nodo destinazione,int peso) {
		this.destinazione = destinazione;
		this.peso = peso;
	}
	public Arco(Nodo destinazione) {
		this(destinazione,0);
	}
	public int getPeso() {
		return peso;
	}

	public Nodo getDestinazione() {
		return destinazione;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return destinazione.toString() + " (" + peso +")";
	}
	@Override
	public int compareTo(Arco o) {
		int cmp = o.getDestinazione().compareTo(getDestinazione());
		 if(cmp == 0)
			 return peso - o.peso;
		 return cmp;
	}
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Arco && ((Arco)obj).getDestinazione().equals(getDestinazione())
				&& ((Arco)obj).peso == peso;
	}
}
