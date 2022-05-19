package it.univr.ordinamento;
import java.util.Random;

/**
 * @author mattia ceron
 *
 */
public class  Ordinamento {

	static private int[] B;
	static private int volte=0;
	public static void MergeSort(int[] A,int p,int r) {
		if(volte==0) {
			B=new int[A.length];
		}
		volte++;
		MSort(A,p,r);
	}
	
	private static void MSort(int[] A,int p,int r) {
		if(p<r) {
			int q=(p+r)/2;
			MSort(A, p, q);
			MSort(A,q+1,r);
			Merge(A,p,q,r);
		}
		
	}
	
	private static void Merge(int[] A, int p, int q, int r) {

		int i=0;
		int j=p;
		int k=q+1;
		while(j<=q || k<=r)
		{
			if(j<=q && (k>r || A[j]<=A[k])) {
				B[i]=A[j];
				j++;
			}else {
				B[i]=A[k];
				k++;
			}
			i++;
			
		}
		for(i=0;i<(r-p+1);i++) {
			A[p+i]=B[i];
		}
		
	}
	
	public static void QuickSortNoRecursiveTail(int[] A, int p, int r) {
		while(p<r) {
			int q=RandomizedPartition(A,p,r);
			QuickSortNoRecursiveTail(A, p, q);
			p=q+1;
		}
		
	}
	public static void QuickSort(int[] A, int p, int r) {
		if(p<r)
		{
			int q=RandomizedPartition(A,p,r);
			QuickSort(A, p, q);
			QuickSort(A, q+1, r);
		}
		
	}

	/**
	 * @param A Array di interi che deve essere ordinato
	 * @param p indice di sinistra
	 * @param r indice a destra
	 * @return un intero che rappresenta il punto di incontro degli indici
	 */
	private static int Partition(int[] A, int p, int r) {
		int x=A[p];
		int i=p-1;
		int j=r+1;
		while(true) {
			do {
				j--;
			}while(A[j]>x);
			do {
				i++;
			}while(A[i]<x);
			if(i<j) {
				//System.out.println("i="+i+", j="+j+" A[i]= "+A[i] +"  A[j]="+A[j]);
				int tmp = A[j];
				A[j]=A[i];
				A[i]=tmp;
			}else 
				return j;
			
		}
	}
	
	private static int RandomizedPartition(int[] A,int p,int r) {
		int i = new Random().nextInt(r-p)+p;
		int tmp=A[i];
		A[i]=A[p];
		A[p]=tmp;
		return Partition(A, p, r);
	}
	public static void InsertionSort(int[] A) {
		for(int j=1;j<A.length;j++) {
			int key=A[j];
			int i=j-1;
			while(i>0 && A[i]>key) {
				A[i+1]=A[i];
				i--;
				A[i+1]=key;
			}
		}
	}
	/***
	 * 
	 * @param A Heap che soddisfa la proprietà (indice padre maggiore di quello dei figli)
	 * @param i indice da inserire
	 */
	static private int HeapSize;
	
	private static void Hpify(int[] A,int i) {
		//l indice figlio sinistro
		//r indice figlio destro
		//largest indice di quello più grande
		int l,r,largest;
		l=2*i+1;
		r=2*i+2;
		if(l<HeapSize && A[l]>A[i])
			largest=l;
		else
			largest=i;
		if(r<HeapSize && A[r]>A[largest])
			largest=r;
		if(largest!=i) {
			int tmp=A[i];
			A[i]=A[largest];
			A[largest]=tmp;
			Hpify(A, largest);
		}
	}
	private static void IterativeHeapify(int[]A,int i) {
		int l,r,largest;
		largest=i;
		do {
			l=2*i+1;
			r=2*i+2;
			if(l<HeapSize && A[l]>A[i])
				largest=l;
			else
				largest=i;
			if(r<HeapSize && A[r]>A[largest])
				largest=r;
			if(largest!=i) {
				int tmp=A[i];
				A[i]=A[largest];
				A[largest]=tmp;
				tmp=largest;
				largest=i;
				i=tmp;
			}
		}while(largest!=i);
	}
	private static void BuildHeap(int[] A) {
		HeapSize=A.length;
		for(int i=A.length/2-1;i>=0;i--)
			Hpify(A, i);
	}
	public  static void HeapSort(int[] A) {
		BuildHeap(A);
		for(int i=A.length-1;i>0;i--) {
			int tmp= A[0];
			A[0]=A[i];
			A[i]=tmp;
			HeapSize--;
			Hpify(A, 0);
		}
	}
	public static int[] CountingSort(int[]A,int k) {
		int[] B = new int[A.length];
		int[] C = new int[k];
		for(int i=0;i<k;i++)
			C[i]=0;
		for(int j=1;j<A.length;j++)
			C[A[j]]++;
		for(int i=1;i<k;i++)
			C[i]=C[i]+C[i-1];
		for(int j=A.length-1;j>0;j--)
		{
			B[C[A[j]]]=A[j];
			C[A[j]]--;
		}
		return B;
	}
	public static int RandSelect(int[] A,int p,int r,int i) {
		if(p==r)
			return A[p];
		int q=RandomizedPartition(A, p, r);
		int k=q-p+1;
		if(i<k)
			return RandSelect(A, p, q, i);
		return RandSelect(A, q+1, r, i-k);
	}
	public static int IterativeRandSelect(int[] A,int p,int r,int i) {
		while(p!=r) {
			
			int q=RandomizedPartition(A, p, r);
			int k=q-p+1;
			if(i<k)
				return RandSelect(A, p, q, i);
			p=q+1;
			i=i-k;
		
		}
		return A[p];
		
	}
	
	public static void sort(int[] A ) {
		int maxDepth = 0;
		maxDepth = (int) (Math.log(A.length) / Math.log(2));
		IntroSort(A,maxDepth,0,A.length);
	}
	private static void IntroSort(int[] A,int maxDepth,int begin, int end) 
	{
		int n = end;
		if(n<= 1)
			return;
		else if (maxDepth == 0)
			HeapSort(A);
		else
			{
				int p = Partition(A,begin,end-1);
				
				IntroSort(A, maxDepth-1,begin,p);
				IntroSort(A, maxDepth-1,p+1,end-1);
			}
	}
	
}

