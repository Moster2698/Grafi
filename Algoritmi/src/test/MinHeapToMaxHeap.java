package test;

import it.univr.Structures.MinHeap;

public class MinHeapToMaxHeap {

	public static void main(String[] args) {
		MinHeap<Integer> minHeap = new MinHeap<Integer>(3, 5, 1, 6, 8, 20, 10, 12, 18, 9);
		System.out.println(minHeap);
	}
}
