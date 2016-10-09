package techinterview;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class AnagramTest {

    @Test
    public void testFindsAnagrams() throws Exception {
        Collection<String> anagrams = new Anagram().findAll("baste", Arrays.asList("abets", "baste", "betas", "beast", "beats"));
        assertEquals(4, anagrams.size());
    }

    @Test
    public void testEmptyDictionaryFindsNoAnagrams() throws Exception {
        Collection<String> anagrams = new Anagram().findAll("baste", Collections.emptyList());
        assertEquals(0, anagrams.size());
    }
}