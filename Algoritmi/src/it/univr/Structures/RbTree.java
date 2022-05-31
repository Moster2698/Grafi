package it.univr.Structures;


public class RbTree {
	private Nodo root;
	private Nodo nil = new Nodo(Integer.MIN_VALUE,"black",0);
	public void Insert(int... number) {
		for(int i: number)
			Insert(i);
	}
	public void Insert(int number) {
		Nodo z = new Nodo(number,"red");
		Nodo y = nil;
		Nodo x = root;
		if(root == null) {
			z.color="black";
			root = z;
		}
		else {
			while(!x.equals(nil)) {
				y = x;
				x.size++;
				if(z.key < x.key) {

					x = x.left;
				} 

				else {

					x = x.right;
				}	
			}
			z.parent = y;
			if(z.key < y.key)
				y.left = z;
			else
				y.right = z;
			z.right = nil;
			z.left = nil;
			insertFixUp(z);
		}

	}
	@Override
	public String toString() {
		return print("",root,false);
	}
	String s ="";
	private String print(String prefix, Nodo n, boolean isLeft) {
		if (n != null && !n.equals(nil)) {
			s=s.concat(prefix + (isLeft ? "|-- " : "\\-- ") + n.key +"("+ n.color +", " +n.size+")\n");
			//   System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.value);
			print(prefix + (isLeft ? "|   " : "    "), n.left, true);
			print(prefix + (isLeft ? "|   " : "    "), n.right, false);
		}
		return s;
	}
	private void insertFixUp(Nodo z) {
		Nodo y;
		while(z.parent.color.equalsIgnoreCase("red")) {
			if(z.parent.equals(z.parent.parent.left)) {
				y = z.parent.parent.right;
				if(y.color.equalsIgnoreCase("red"))
				{
					z.parent.color = "black";
					y.color = "black";
					z.parent.parent.color = "red";
					z = z.parent.parent;
				}
				else 
				{ 
					if(z.equals(z.parent.right)) {
						z = z.parent;
						leftRotate(z);
					}
					z.parent.color = "black";
					z.parent.parent.color = "red";
					rightRotate(z.parent.parent);
				}
			}
			else {
				if(z.parent.equals(z.parent.parent.right)) {
					y = z.parent.parent.left;
					if(y.color == "red")
					{
						z.parent.color = "black";
						y.color = "black";
						z.parent.parent.color = "red";
						z = z.parent.parent;
					}
					else { 
						if(z.equals(z.parent.left)) {
							z = z.parent;
							if(!z.right.equals(nil))
								leftRotate(z);
						}
						z.parent.color = "black";
						z.parent.parent.color = "red";
						if(z.parent.parent.left!=null && !z.parent.parent.left.equals(nil))
							rightRotate(z.parent.parent);
					}
				}
			}
		}
		root.color = "black";
	}
	public Nodo NodovicinoMaggiore(int number) {
		return nearestGreater(root, number, number, nil);
	}
	private Nodo nearestGreater(Nodo x,int number,int diff,Nodo n) {
		if(x.equals(nil))
		{
			if(diff==number)
				return null;
			System.out.println(n);
			return n;
		}
		if(x.key==number)
			return x;
		if(x.key>number) {
			if(x.key - number < diff)
				return nearestGreater(x.left, number, x.key - number,x);
			return nearestGreater(x.left, number,diff,n);
		}
			return nearestGreater(x.right, number, diff,n);
	}
	public Nodo NodoVicinoMinore(int number) {
		return nearestLess(root, number, number, nil);
	}
	private Nodo nearestLess(Nodo x,int number,int diff,Nodo n) {
		if(x.equals(nil))
		{
			System.out.println(n.key);
			if(diff==number)
				return null;
			return n;
		}
		if(x.key==number)
			return x;
		if(x.key<number) {
			if(number - x.key < diff)
				return nearestLess(x.right, number, x.key - number,x);
			return nearestLess(x.right, number,diff,n);
		}
			return nearestLess(x.left, number, diff,n);
	}
	private void leftRotate(Nodo x) {
		Nodo y = x.right;
		x.right = y.left;
		if(!y.left.equals(nil)) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		if(x.parent.equals(nil)) {
			root = y;
		}
		else if(x.equals(x.parent.left))
			x.parent.left = y;
		else
			x.parent.right = y;
		y.left = x;
		x.parent = y;
		y.size = x.size;
		x.size = x.left.size + x.right.size ;
	}
	private void rightRotate(Nodo x) {
		Nodo y = x.left;
		x.left = y.right;
		if(!nil.equals(y.right))
			y.right.parent = x;
		y.parent = x.parent;
		if(x.parent.equals(nil))
			root = y;
		else if (x.equals(x.parent.right))
			x.parent.right = y;
		else
			x.parent.left = y;
		y.right = x;
		x.parent = y;
		y.size = x.size;
		x.size = x.left.size + x.right.size +1;
	}
	public Nodo OSSelect(int i) {
		return OssSelect(root, i);
	}
	private Nodo OssSelect(Nodo x, int i) {
		int r = x.left.size + 1;
		if(i==r)
			return x;
		if(i < r)
			return OssSelect(x.left, i);
		return OssSelect(x.right, i-r);
	}
	public int Rank(Nodo x) {
		if(x==null)
			return 0;
		int r = x.left.size +1;
		Nodo y = x;
		while(!y.equals(root)) {
			if(y.equals(y.parent.right))
				r = r + y.parent.left.size + 1;
			y = y.parent;
		}
		return r;
	}
	public int Interval(int k) {
		int rankK = Rank(NodovicinoMaggiore(k));
		int rankK2 = Rank(NodoVicinoMinore(2*k));
		System.out.println(rankK2);
		if(rankK==rankK2 && rankK!=0)
			return 1;
		if(rankK==0 || rankK2==0)
			return rankK2-rankK;
		return rankK2 - rankK+1;
	}
	private class Nodo implements Comparable<Nodo> {
		private Integer key;
		private String color;
		private Nodo parent,left,right;
		private int size;

		public Nodo(int key,String color,int size) {
			this.key = key;
			this.color = color;
			this.size = size;
			parent = nil;
			right = nil;
			left = nil;
			size = 1;
		}
		public Nodo(int key,String color) {
			this(key,color,1);
		}
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof RbTree.Nodo) {
				RbTree.Nodo o = (RbTree.Nodo) obj;
				if(o.key == key)
					return true;
			}
			return false;
		}
		@Override
		public int compareTo(Nodo o) {
			// TODO Auto-generated method stub
			return o.key - key;
		}
		@Override
		public String toString() {
			return key+"";
		}
	}
}
