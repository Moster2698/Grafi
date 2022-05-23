package it.univr.grafi;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;

import it.univr.Structures.MinHeap;

 public class AlgoritmiElementari {

	public static Grafo  BFS(Grafo grafo,Nodo s) {
		Grafo g = null;
		if(grafo instanceof GrafoOrientato)
			g = new GrafoOrientato();
		else
			g = new GrafoNonOrientato();
		if(!grafo.contieneNodo(s))
			throw new IllegalArgumentException("Il nodo inserito non è presente nel grafo");
		List<Nodo> vertici = grafo.getVertici();
		vertici.remove(s);
		for(Nodo nodo : vertici) {
			nodo.setColor("white");
			nodo.setDistance(Integer.MAX_VALUE);
			nodo.setNodeParent(null);
		}
		s.setColor("gray");
		s.setDistance(0);
		s.setNodeParent(null);
		Queue<Nodo> coda = new LinkedList<Nodo>();
		coda.add(s);
		while(!coda.isEmpty()) {
			Nodo u = coda.poll();
			g.addNode(u);
			for(Arco a : grafo.getArchiAdiacenti(u)) {
				Nodo v = a.getDestinazione();
				if(v.getColor().equals("white")) {
					g.aggiungiArco(u, a);
					g.addNode(v);
					v.setColor("gray");
					v.setDistance(u.getDistance()+1);
					v.setNodeParent(u);
					coda.add(v);
				}
			}
			u.setColor("black");
		}
		
		return g;
	}
	
	public static Grafo BfsPath(Grafo grafo,Nodo s,Nodo t) {
		Grafo path = new GrafoOrientato();
		List<Nodo> vertici = grafo.getVertici();
		vertici.remove(s);
		for(Nodo nodo : vertici) {
			nodo.setColor("white");
			nodo.setDistance(Integer.MAX_VALUE);
			nodo.setNodeParent(null);
		}
		s.setColor("gray");
		s.setDistance(0);
		s.setNodeParent(null);
		Queue<Nodo> coda = new LinkedList<Nodo>();
		coda.add(s);
		while(!coda.isEmpty()) {
			Nodo u = coda.poll();
			for(Arco a : grafo.getArchiAdiacenti(u)) {
				Nodo v = a.getDestinazione();
				if(v.getColor().equalsIgnoreCase("white") && grafo.getArco(u, v).getCapacitaResidua()>0 ) {
					v.setColor("gray");
					v.setDistance(u.getDistance()+1);
					v.setNodeParent(u);
					coda.add(v);
					
				}
			}	
			u.setColor("black");
		}
		Nodo n = t;
		while(n!= null) {
			path.addNode(n);
			if(n.getParent()!=null)
			{
				path.aggiungiArco(n.getParent(),grafo.getArco(n.getParent(), n));
			}
				
			n = n.getParent();
		}
		return path;
	}
	private static int TIME;
	private static boolean vis[];
	public static boolean DFS(Grafo grafo) {
		List<Nodo> vertici = grafo.getVertici();
		vis=new boolean[vertici.size()];
		for(Nodo v : vertici) {
			v.setColor("white");
			v.setNodeParent(null);
		}
		TIME = 0;
		for(Nodo v : vertici) {
			if(v.getColor().equalsIgnoreCase("white"))
				DFSVisit(v,grafo);
		}
	
		for(int i=0;i<vis.length;i++) {
			System.out.println(vis[i]);
			if(!vis[i])
				return false;
		}
		return true;
	}
	private static void DFSVisit(Nodo u,Grafo grafo) {
		u.setColor("gray");
		u.setDtime(TIME++);
		vis[u.getID()] = true;
		if(grafo.getAdjLinkedList(u)!=null) {
			for(Nodo v : grafo.getAdjLinkedList(u)) {
				if(v.getColor().equalsIgnoreCase("white")) {
					v.setNodeParent(u);
					DFSVisit(v, grafo);
				}
			}	
		}
		u.setColor("Black");
		u.setFtime(TIME++);
	}
	
	public static void MstPrim(Grafo g,Nodo r){
		MinHeap<Nodo> q = new MinHeap<Nodo>(g.getVertici().size() ,new Comparator<Nodo>() {	
			@Override
			public int compare(Nodo o1, Nodo o2) {
				return o1.key - o2.key;
			}
		});
		for(Nodo v : g.getVertici()) {
			v.key = Integer.MAX_VALUE;
			v.setNodeParent(null);
			q.Insert(v);
		}
		r.key = 0;	
		while(!q.isEmpty()) {
			Nodo u  = q.ExtractMin();
			List<Nodo> verticiAdiacenti = g.getAdjLinkedList(u);
			for(Nodo v : verticiAdiacenti) {
				int pesoArco = g.peso(u, v);
				if(q.contains(v) && pesoArco < v.key) {
					v.setNodeParent(u);
					v.key=pesoArco;
					q.DecreaseKey(q.indexOf(v), v);
				}
			}
		}
		printMstPrim(g);
	}
	public static void FordFulkerson(Grafo g, Nodo s, Nodo t) {
		for(Arco a : g.archi) {
			a.setFlusso(0);
		}
			Grafo grafoResiduo = creaReteResidua(g);
		for(Arco a : grafoResiduo.archi) {
			a.setFlusso(0);
			a.AggiornaCapacitaResidua();
		}
			Grafo camminoAumentante;	
			while( (camminoAumentante = BfsPath(grafoResiduo, s,t)).getArchi().size()!=0) {
				int capacitaResidua=Integer.MAX_VALUE;
				for(Arco a : camminoAumentante.archi) {
					if(a.getCapacita()<capacitaResidua) {
						capacitaResidua = a.getCapacita();
					}
				}
				System.out.println(capacitaResidua);
				for (Arco a : camminoAumentante.archi) {
					if(g.archi.contains(a)) {
						Arco uv = g.getArco(a.getSorgente(), a.getDestinazione());
						uv.setFlusso(uv.getFlusso()+capacitaResidua);
						a.setCapacitaResidua(a.getCapacitaResidua()-capacitaResidua);
						Arco aReverse = grafoResiduo.getArco(a.getDestinazione(), a.getSorgente());
						aReverse.setCapacitaResidua(aReverse.getCapacitaResidua()+capacitaResidua);
					}
					else {
						Arco vu = g.getArco(a.getDestinazione(), a.getSorgente());
						vu.setFlusso(vu.getFlusso()- capacitaResidua);
						System.out.println("ciao");
					}
				}
		}
	}
	public static Grafo creaReteResidua(Grafo grafo) {
		Grafo grafoResiduo = new GrafoOrientato();
		grafoResiduo.addNode(grafo.getVertici().toArray(new Nodo[grafo.getVertici().size()]));
		for(Entry<Nodo,LinkedList<Arco>> adj : grafo.getRappresentazione().entrySet()) {
			for(Arco arco : adj.getValue()) {
				Arco a = new Arco(adj.getKey(),arco.getDestinazione(),0,arco.getCapacita(),0,arco.getCapacita());
				grafoResiduo.aggiungiArco(adj.getKey(), a);
				Arco aReverse = new Arco(arco.getDestinazione(), adj.getKey(),arco.getPeso(), 0, 0,0);
				grafoResiduo.aggiungiArco(arco.getDestinazione(), aReverse);
			}
		}
		return grafoResiduo;
	}
	private static void printMstPrim(Grafo g) {
		for(Nodo nodo : g.getVertici()) {
			System.out.println(nodo + " parente : " + nodo.getParent());
		}
	}
}
