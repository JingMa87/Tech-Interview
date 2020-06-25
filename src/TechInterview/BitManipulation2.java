import static java.lang.Integer.max;
import java.util.Scanner;
/**
 * This class has solution to the problem #5.3 Flip Bit to Win
 * of chapter 'BitManipulation' from book 'Cracking the Coding Interview'.
 * @author akanksha bhardwaj
 */
public class BitManipulation2 {
    
    public void flipToWin(int n) {
        String s = Integer.toBinaryString(n);
        int l = s.length();
        char[] c = s.toCharArray();
        int prev_zindex = -1 ;                         // store index to previously encourtered 0 bit
        int max_seq = 0 , curr_seq = 0;
        for(int i = 0 ; i < l; i++) {
           if(c[i] == '0') {
               if(prev_zindex == -1) {                 // first 0 bit encountered
                   curr_seq = i + 1;
                }
               else {
                    max_seq = max(max_seq , curr_seq); // update answer with sequence value according to previous 0 bit
                    curr_seq = i - prev_zindex ;       // update current sequence length according to this 0 bit
               }
               prev_zindex = i;
           }
           else {
               curr_seq += 1;
           }
        } 
        max_seq = max(max_seq , curr_seq);
        System.out.println(max_seq);        
    }    
    
    public static void main(String[] args) {
        BitManipulation2 bm = new BitManipulation2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
	      bm.flipToWin(n);
    }
}
