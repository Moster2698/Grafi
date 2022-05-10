package it.univr.Structures;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BinaryTree  {

	private Node root;
	
	public void addNode(int value) {
		if(root==null)
			root = new Node(value);
		else {
			root.add(value);
			
		}
		
	}
	
	 String s ="";
	    private String print(String prefix, Node n, boolean isLeft) {
	        if (n != null) {
	        	s=s.concat(prefix + (isLeft ? "|-- " : "\\-- ") + n.value+"\n");
	         //   System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.value);
	            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
	            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
	        }
	        return s;
	    }
	    @Override
		public String toString() {
			
			return print("",root,false);
		}
	public int Height() {
		return root.NodeHeight();
	}
	 public void dumpAsXML(String fileName) throws IOException {
		  try (Writer writer = new BufferedWriter(new FileWriter(fileName))) {
			  writer.write("<binary-tree>\n");
			  root.dumpAsXML("root", "  ", writer);
			  writer.write("</binary-tree>\n");
		  }
		  
	  }
	 /***
	  * 
	  * @param node: nodo Da cui iniziare a stampare
	  * Stampa un albero binario in modo PreVisit
	  */
	 public void PrintPreOrder(Node node) {
		 
			if(node==null)
				return;
			
			System.out.println(node.value);
			
			 
		      PrintPreOrder(node.left);
		      PrintPreOrder(node.right);
		
		}
	 /***
	  * 
	  *@param node: nodo Da cui iniziare a stampare
	  *@brief: Stampa un albero binario. Inizia dai nodi a destra e poi quelli a sinistra.
	  */
	 public void PrintPostOrder(Node node) {
			if(node==null)
				return;
			 PrintPostOrder(node.right);
			System.out.println(node.value);
			 PrintPostOrder(node.left);
		     
		}
	 /***
	  * 
	  * @param node: nodo Da cui iniziare a stampare
	  * @brief: Stampa un albero binario in modo InVisit. Stampa
	  * prima tutti i nodi a sinistra, poi quelli a destra
	  */
	 public void PrintInOrder(Node node) {
			if(node==null)
				return;
			 PrintInOrder(node.left);
			 System.out.println(node.value);
			 PrintInOrder(node.right);
		}
	 /**
	  * 
	  * 
	  * @return nodo radice dell'albero
	  */
	 
	 
	 public Node CloseValue(Node n, int k,Node close) {
		 if(n == null)
			 return close;
		 if(close == null)
			 close = n;
		 if(Math.abs(n.value - k)<Math.abs(close.value - k)) {
			 close = n;
			
		 }
		 if(n.value > k)
			 return CloseValue(n.left, k, close);
		 return CloseValue(n.right, k, close);
	 }
	 public Node getRoot() {
		 return root;
	 }
	private class Node {
		//nodo figlio sinistro
		private Node left;
		//nodo figlio destro
		private Node right;
		//valore del nodo
		private int value;
		private boolean red = true;
		private Node(int value) {
			this.value = value;
		}
		
		private void add(int added) {
			if (added < value)
		        if (left == null)
		          left = new Node(added);
		        else
		          left.add(added);
		      else if (added > value)
		        if (right == null)
		          right = new Node(added);
		        else
		          right.add(added);
		}
		   
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return value+" ";
		}
		private int NodeHeight()  {
			if(right==null && left==null)
				return 1;
			else if(right==null)
				return 1+left.NodeHeight();
			else if(left==null)
				return 1+right.NodeHeight();
			return Math.max(right.NodeHeight(),left.NodeHeight())+1;
			
		}
		private void dumpAsXML(String tag, String spaces, Writer writer) throws IOException {
	    	writer.write(spaces + "<" + tag + " value = \"" + value + "\">\n");

	    	if (left != null)
	    		left.dumpAsXML("left-subtree", spaces + "  ", writer);
	    	
	    	if (right != null)
	    		right.dumpAsXML("right-subtree", spaces + "  ", writer);

	    	writer.write(spaces + "</" + tag + ">\n");
	    }

	}
	
	
}
