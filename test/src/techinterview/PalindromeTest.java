package techinterview;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by will on 10/8/16.
 */
public class PalindromeTest {

    @Test
    public void testIsPalindrome() throws Exception {
        assertTrue(Palindrome.is("racecar"));
        assertFalse(Palindrome.is("race"));
        assertTrue(Palindrome.is("mom"));
    }

    @Test
    public void testEmptyStringIsPalindrome() throws Exception {
        assertTrue(Palindrome.is(""));
    }

    @Test
    public void testSingleLetterIsPalindrome() throws Exception {
        assertTrue(Palindrome.is("a"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullThrowsIllegalArgumentException() throws Exception {
        Palindrome.is(null);
    }
}