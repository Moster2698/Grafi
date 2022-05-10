package grafi;

public class Arco {

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
		return "-->" + destinazione;
	}
}
