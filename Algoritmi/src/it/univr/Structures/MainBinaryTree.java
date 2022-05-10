package it.univr.Structures;

import java.io.IOException;
import java.util.Random;


public class MainBinaryTree {

	
	public static void main(String[] args) throws IOException {
		Random random = new Random();
		BinaryTree binaryTree = new BinaryTree();
		
		for(int i=0;i<10;i++)
			binaryTree.addNode(random.nextInt(10));
	//	binaryTree.print();
		System.out.println(binaryTree);
		System.out.println(binaryTree.CloseValue(binaryTree.getRoot(),11, null));
	}
}
