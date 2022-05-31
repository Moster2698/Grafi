package test;

import java.util.Random;

import it.univr.Structures.RbTree;

public class TestRbtree {

	public static void main(String[] args) {
		RbTree rb = new RbTree();
		Random rn = new Random();
		rb.Insert(10,6,15,4,8);
			
		System.out.println(rb.Interval(4));
	}
}
