package it.univr.grafi;

public class Arco implements Comparable<Arco>{
	private Nodo sorgente;
	private Nodo destinazione;
	private int peso;
	private int capacita;
	private int flusso;
	private int capacitaresidua;
	
	public Arco(Nodo sorgente,Nodo destinazione, int peso, int capacita,int flusso,int capacitaresidua) {
		this.sorgente = sorgente;
		this.destinazione = destinazione;
		this.peso = peso;
		this.capacita = capacita;
		this.flusso = flusso;
		this.capacitaresidua = capacita - flusso;
	}
	
	public Arco(Nodo sorgente,Nodo destinazione,int peso) {
		this(sorgente,destinazione,peso,0,0,0);
	}
	public Arco(Nodo sorgente, Nodo destinazione) {
		this(sorgente, destinazione,0,0,0,0);
	}
	
	public void setCapacita(int capacita) {
		this.capacita = capacita;
	}
	public void setFlusso(int flusso) {
		this.flusso = flusso;
	}
	public int getCapacita() {
		return capacita;
	}
	public int getCapacitaResidua() {
		return capacitaresidua;
	}
	public void setCapacitaResidua(int capacitaresidua) {
		this.capacitaresidua = capacitaresidua;
	}
	public int getFlusso() {
		return flusso;
	}
	public int getPeso() {
		return peso;
	}

	public Nodo getDestinazione() {
		return destinazione;
	}
	public Nodo getSorgente() {
		return sorgente;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return sorgente.toString() + " " + destinazione.toString() + " (" + flusso +")";
	}
	@Override
	public int compareTo(Arco o) {
		int cmp = o.getDestinazione().compareTo(getDestinazione());
		 if(cmp == 0)
			 return peso - o.peso;
		 return cmp;
	}
	public void AggiornaCapacitaResidua() {
		capacitaresidua = capacita - flusso;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Arco) {
			Arco altroArco = (Arco)obj;
			return altroArco.destinazione == destinazione && altroArco.sorgente == sorgente;
		}
		return false;
	}
}
