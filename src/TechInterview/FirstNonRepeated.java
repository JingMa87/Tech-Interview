/***

Given a string s consisting of lowercase Latin Letters, find the first non repeating character in s.

Input:

The first line contains T denoting the number of testcases. Then follows description of testcases.
Each case begins with a single integer N denoting the length of string. The next line contains the string s.
 
Output:


 For each testcase, print the first non repeating character present in string.
 
 Print -1 if there is no non repeating character.

***/

import java.util.*;
import java.lang.*;
import java.io.*;

class FirstNonRepeated {
	public static void main (String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
		    Map<Character,Integer> map= new HashMap<>();
		    int n = sc.nextInt();
		    String s = sc.next();
		    
		    for(int i=0;i<n;i++)
		    {
		        if(map.containsKey(s.charAt(i)))
		        map.put(s.charAt(i),map.get(s.charAt(i))+1);
		        else
		        map.put(s.charAt(i),1);
		    }
		    int check = 0;
		    for(int i=0;i<n;i++)
		    {
		        if(map.get(s.charAt(i))==1)
		        {
		            System.out.println(s.charAt(i));
		            check = 1;
		            break;
		        }
		    }
		    if(check == 0)
		    System.out.println(-1);
		}
	}
}