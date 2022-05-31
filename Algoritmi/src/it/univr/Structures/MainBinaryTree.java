package it.univr.Structures;

import java.io.IOException;
import java.util.Random;


public class MainBinaryTree {

	
	public static void main(String[] args) throws IOException {
		BinomialHeap<Integer> binomialHeap = new BinomialHeap<Integer>();
		binomialHeap.insert(1);
		System.out.println(binomialHeap.size());
	}
}
