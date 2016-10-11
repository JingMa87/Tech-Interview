/*
 * Cracking the Code Interview
 * 
 * Question: Generate all Permutations for a string.
 * Uses recursion to calculate this.
 */

import java.util.Scanner;


public class permutation {
	
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}

	public static void main(String[] args) {
		System.out.println("Please enter a string: ");
		Scanner sc = new Scanner(System.in);
		String permString = sc.nextLine();
		System.out.println("All possible permuations for "+ permString +":");
		permutation(permString);

	}

}
