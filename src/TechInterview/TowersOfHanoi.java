package TechInterview;

 /*
  * Cracking the Code Interview
  *
  * In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of different sizes which
  * can slide onto any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom
  * (e.g., each disk sits on top of an even larger one). You have the following constraints:
  * (A) Only one disk can be moved at a time.
  * (B) A disk is slid off the top of one rod onto the next rod.
  * (C) A disk can only be placed on top of a larger disk.
  */

public class TowersOfHanoi {

    public static void move(char start, char carry, char target, int n) {
        if (n == 1) {
            System.out.println(String.format("Move the stack from %c on %c.", start, target));
        } else {
            move(start, target, carry, n-1);
            move(start, carry, target, 1);
            move(carry, start, target, n-1);
        }
    }

    public static void main(String[] args) {
        move('a', 'b', 'c', 4);
    }
}
