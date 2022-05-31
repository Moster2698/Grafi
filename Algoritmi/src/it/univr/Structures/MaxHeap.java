package it.univr.Structures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeap<T extends Comparable<T>> {
	private int heapSize;
	private T[] heap;
	private Comparator<T> comparator;
	//O(nlog n)

	public MaxHeap(Comparator<T> comparator,T... varargs) {
		this.comparator = comparator;
		heap = varargs;
		heapSize = varargs.length;
		BuildHeap(varargs);
	}
	public MaxHeap(T... varargs) {
		this(null,varargs);
	}
	@SuppressWarnings("unchecked")
	public MaxHeap(int length) {
		heap = (T[])new Comparable[length];
		heapSize=0;
	}
	public MaxHeap(int length, Comparator<T> comparator) {
		this(length);
		this.comparator = comparator;
	}
	private void BuildHeap(T[] A) {
		heapSize=A.length;
		if(comparator==null)
			for(int i=A.length/2-1;i>=0;i--)
				HeapifyWithComparable(A, i);
		else
			for(int i=A.length/2-1;i>=0;i--)
				HeapifyWithComparator(A, i);
	}
	private void HeapifyWithComparable(T[] A,int i) {
		int l,r,highest;
		l=2*i+1;
		r=2*i+2;
		if(l<heapSize && A[l].compareTo(A[i])>0)
			highest=l;
		else
			highest=i;
		if(r<heapSize && A[r].compareTo(A[highest])>0)
			highest=r;
		if(highest!=i) {
			T tmp=A[i];
			A[i]=A[highest];
			A[highest]=tmp;
			HeapifyWithComparable(A, i);
		}
	}
	private void HeapifyWithComparator(T[] A,int i) {
		//l indice figlio sinistro
		//r indice figlio destro
		//lowest indice di quello più piccolo
		int l,r,lowest;
		l=2*i+1;
		r=2*i+2;
		if(l<heapSize && comparator.compare(A[l],A[i])>0)
			lowest=l;
		else
			lowest=i;
		if(r<heapSize && comparator.compare(A[r],A[lowest])>0)
			lowest=r;
		if(lowest!=i) {
			T tmp=A[i];
			A[i]=A[lowest];
			A[lowest]=tmp;
			HeapifyWithComparator(A, i);
		}
	}
	
	//O(log n)
	public T ExtractMin() {
		if(heapSize<1)
			throw new IndexOutOfBoundsException("L'heap è vuoto");
		T min = heap[0];	
		heap[0] = heap[heapSize-1];
		heapSize--;
		
		if(comparator==null)
			HeapifyWithComparable(heap, 0);
		else
			HeapifyWithComparator(heap, 0);
		return min;
		
	}
	
	//public 
	public void Insert (T key) {
		if(heapSize==heap.length-1) 
			heap = Arrays.copyOf(heap, heap.length*2);
		heapSize++;
		heap[heapSize-1] = key;
		DecreaseKey(heapSize-1, key);

	}
	//O(log n)
	public void DecreaseKey(int i,T key) {
		heap[i] = key;
		int parent = (i-1)/2;
		if(comparator!=null)
			BubbleUpWithComparator(i, parent);
		else
			BubbleUpWithComparable(i, parent);
	}
	private void BubbleUpWithComparable(int i, int parent) {
		while(i > 0 && heap[i].compareTo(heap[parent])>0) {
			T tmp= heap[i];
			heap[i] = heap[parent];
			heap[parent] = tmp;
			i = parent;
		}
	}
	private void BubbleUpWithComparator(int i,int parent) {
		//Anomalia è che il figlio heap[i] è minore di heap[parent]
		// i < heap = i-heap < 0
		while(i > 0 && comparator.compare(heap[i],heap[parent])>0){
			T tmp= heap[i];
			heap[i] = heap[parent];
			heap[parent] = tmp;
			i = parent;
		}
	}
	public int getLength() {
		return heapSize;
	}
	public int indexOf(T element) {
		for(int i=0;i<heapSize;i++)
		{
			if(heap[i].equals(element))
				return i;
		}
		return -1;
	}
	public boolean isEmpty() {
		return heapSize==0;
	}
	
	public boolean contains(T element) {
		for(int i=0;i<heapSize;i++) {
			if(heap[i].equals(element))
				return true;
		}
		return false;
	}
	@Override
	public String toString()
	{
		String retval = "";
		for(int i=0;i<heapSize;i++)
		{
			if (heap[i] != null) retval += heap[i] +": ";
		}
		return retval + "\n";
	
	}
}
