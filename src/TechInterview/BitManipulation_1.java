import java.util.Scanner;
/**
 * This class has solution to problem #5.1 'Insertion' 
 * of chapter 'BitManipulation' from book 'Cracking the Coding Interview'.
 * @author akanksha bhardwaj
 */
public class BitManipulation {
    
    public void insertion(String N, String M, int i, int j) {
        int n = Integer.parseInt(N,2);
        int m = Integer.parseInt(M,2);
        /* divide new number in three parts 
         * first part from number n  ,all bits from the most significant bit through j+1 (inclusive) 
         * second part from number m complete
         * third part from number n , all bits from i-1 through 0 (inclusive)
         */
        int first = n & (-1 << (j+1));
        int second = m << i;
        int third = n & ( (1 << i) -  1);
        int num = (first | second ) | third ;
        System.out.println(Integer.toBinaryString(num));
    }
    public static void main(String[] args) {
    
        BitManipulation bm = new BitManipulation();
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        String M  = sc.next();
        int i = sc.nextInt();
        int j = sc.nextInt();
        bm.insertion(N , M , i, j);	
        
    }
}
