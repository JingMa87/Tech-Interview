package TechInterview;

public class Parenthesis {


//    Implement an algorithm to print all valid (e.g., properly opened and closed) combinations
//    of n-pairs of parentheses.

    public static void parenthesis(int open, int closed, String answer) {

        if (open == 0 && closed == 0) {
            System.out.printf("%s\n", answer);
        }
        if (open > 0) {
            parenthesis(open - 1, closed + 1, answer + "(");
        }
        if (closed > 0) {
            parenthesis(open, closed - 1, answer + ")");
        }

    }


    public static void solution(int n) {

        parenthesis(n, 0, "");

    }

    public static void main(String[] args) {

        solution(3);

    }

}




