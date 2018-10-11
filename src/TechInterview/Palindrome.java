public class Palindrome {
    /* Palindrome is defined by:
    a word, phrase, sentence, or number that reads the same backward or forward.
    The function should be case-insensitive and ignore punctuations.
    */

    public static void main(String[] args) {
        System.out.println("\"madam\" = " + isPalinedrome("madam"));
        System.out.println("\"hello\" = " + isPalinedrome("hello"));
        System.out.println("\"AbCddCbA\" = " + isPalinedrome("AbCddCbA"));
        System.out.println("\"\" = " + isPalinedrome(""));
        System.out.println("\"Do geese see god?\" = " + isPalinedrome("Do geese see god?"));
    }

    public static boolean isPalinedrome(String phrase) {
        boolean result = true;
        String newPhrase = "";

        if (phrase.isEmpty()) return false;

        // Case-insensitive
        newPhrase = phrase.toUpperCase();

        int endIndex = newPhrase.length() - 1;

        for (int i = 0; i < endIndex && result; i++) {
            if (newPhrase.charAt(endIndex) < 'A' || newPhrase.charAt(endIndex) > 'Z') {
                // If non-alphabet, ignore
                endIndex--;
                // i should not change
                i--;
            } else
            if (newPhrase.charAt(i) >= 'A' && newPhrase.charAt(i) <= 'Z') {
                if (newPhrase.charAt(i) != newPhrase.charAt(endIndex)) {
                    result = false;
                } else {
                    endIndex--;
                }
            }
        }

        return result;
    }
}