package it.univr.grafi;

public class Nodo implements Comparable<Nodo> {
	private static int ID=0;
	private String  name;
	private Nodo parent;
	private int inizio;
	private int fine;
	private String color;
	private int distance;
	private final int id;
	//Utile per l'albero dei cammini minimi
	public int key;
	public Nodo(String name) {
		id=ID++;
		this.name = name;
	}
	@Override
	public int hashCode() {
		
	    return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Nodo) {
			if(((Nodo)obj).name.equals(name))
				return true;
		}
		return false;
	}
	
	public void setDtime(int inizio) {
		this.inizio = inizio;
	}
	public void setFtime(int fine) {
		this.fine = fine;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public void setNodeParent(Nodo parent) {
		this.parent = parent;
	}
	public Nodo getParent() {
		return parent;
	}
	public int getDtime() {
		return inizio;
	}
	public int getFtime() {
		return fine;
	}
	public String getColor() {
		return color;
	}
	public int getDistance() {
		return distance;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return name + ": " + key;
	}
	public int getID() {
		return id;
	}
	@Override
	public int compareTo(Nodo o) {
		if(o==null)
			return id;
		return id - o.getID();
	}
	
	
}
