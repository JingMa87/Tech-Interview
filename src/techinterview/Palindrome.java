package techinterview;

/**
 * Created by will on 10/8/16.
 */
public class Palindrome {
    public static boolean is(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Invalid argument 'null'.");
        }

        int i = 0, j = word.length() - 1;

        while (i <= j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }

            ++i;
            --j;
        }

        return true;
    }
}
