
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.AcceptPendingException;
import java.util.Random;
public class Maintest {
	private static Random random= new Random();
	
	public static void main(String[] args) {
		int[] array = new int[100];
		for(int i=0;i<100;i++) {
			array[i] = random.nextInt(100);
		}
		Ordinamento.sort(array);
		System.out.println(checkIfSorted(array));
		printArray(array);
		
		
	//	StampaFileTempo();
	}
	private static void printArray(int[] a){
			for(int i=0;i<a.length;i++) {
				if(i%10!=0 || i==0)
					System.out.print(a[i]+" ");
				else
					System.out.println();
			}
	}
	private static boolean checkIfSorted(int[] a) {
		boolean  isSorted=true;
		for(int i=1;i<a.length && isSorted;i++)
			if(a[i]<a[i-1])
				isSorted=false;
		return isSorted;
	}
	private static void StampaFileTempo() {
		try {
			Random random= new Random();
			int length=1000000;
			int[] numeri= new int[length];
			int[] numeri2= new int[length];
			int[] numeri3= new int[length];
			int[] numeri4= new int[length];
			int[] numeri5=new int[length];
			int number;
			long sommaRandom=0;
			long sommaNormale=0;
			long sommaMerge=0;
			long sommaHeapSort=0;
			long sommaCountingSort=0;
			File file= new File("text.txt");
			FileWriter fileWriter = new FileWriter(file);
			int volte=1;
			for(int j=0;j<volte;j++) {
			for(int i=0;i<length;i++) {
				number=random.nextInt(10);
				numeri[i]=number;
				numeri2[i]=number;
				numeri3[i]=number;
				numeri4[i]=number;
				numeri5[i]=number;
			}
			long startTime = System.currentTimeMillis();
			
			Ordinamento.QuickSortNoRecursiveTail(numeri, 0, numeri.length-1);

			long endTime = System.currentTimeMillis();
			
			sommaRandom+=endTime-startTime;
			
			long startTime2 = System.currentTimeMillis();
			
			Ordinamento.QuickSort(numeri, 0, numeri.length-1);
			
			long endTime2 = System.currentTimeMillis();
	
			sommaNormale+=endTime2-startTime2;
			long startTime3 = System.currentTimeMillis();
			
			Ordinamento.MergeSort(numeri3, 0, numeri3.length-1);
			
			long endTime3 = System.currentTimeMillis();
			
			sommaMerge+=endTime3-startTime3;
			
			long startTime4 = System.currentTimeMillis();
			
			Ordinamento.HeapSort(numeri4);
			
			long endTime4 = System.currentTimeMillis();
			
			sommaHeapSort+=endTime4-startTime4;
			long startTime5 = System.currentTimeMillis();
			
			Ordinamento.CountingSort(numeri5, 10);
			
			long endTime5 = System.currentTimeMillis();
			
			sommaCountingSort+=endTime5-startTime5;
			}
			
			
		
			
			
			fileWriter.write("Quicksort: "+(sommaNormale/volte) +" millisecondi\n");
			fileWriter.write("Quicksort Random: "+(sommaRandom/volte) +" millisecondi\n");
			fileWriter.write("Mergesort: "+(sommaMerge/volte) +" millisecondi\n");
			fileWriter.write("HeapSort: "+(sommaHeapSort/volte) +" millisecondi\n");
			fileWriter.write("Counting Sort: "+(sommaCountingSort/volte) +" millisecondi\n");
			fileWriter.flush();
			fileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}