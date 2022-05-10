package palindroma;

public class Main {

	public static void main(String[] args) {
		String test = "cane";
		int[][] c = palindrome(test);
		for(int i=0;i<test.length();i++) {
			
			for(int j=0;j<test.length();j++){
				System.out.print(" "+c[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	private static int palindrome(String s, int i, int j) {
		if(i>=j)
			return 0;
		System.out.println(s.charAt(i) + "    " + s.charAt(j));
		if(s.charAt(i)!=s.charAt(j))
			return Math.min(palindrome(s, i+1, j),palindrome(s, i, j-1))+1;
		return palindrome(s, i+1, j-1);
		
	}
	private static int[][] b;
	private static int[][] palindrome(String s) {
		
		int n = s.length();
		int[][] c = new int[n][n];
		 b = new int[n][n];
		for(int i=0;i<n;i++) 
			c[i][i] = 0;
		for(int len = 1; len < n; len++) {
			for(int i = 0; i< n - len;i++) {
				int j = i + len;
				
				if(isPalindrome(s.subSequence(i, j)))
					c[i][j] = 1;
				else {
					c[i][j] = Integer.MAX_VALUE;
				for(int k = i; k< j;k++) {
						int q = 1+c[i][k]+c[k+1][j];
						if(q < c[i][j]) {
							c[i][j] = q;
							b[i][j] = k;
						}
				}
				}
			}
		}
		return c;
	}

	private static boolean isPalindrome(CharSequence charSequence) {
		int i=0, j =charSequence.length()-1;
		do {
			if(charSequence.charAt(i)!=charSequence.charAt(j))
				return false;
			i++;
			j--;
		}while(i<=j);
		return true;
	}
	
	
	
}
