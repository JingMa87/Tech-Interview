package techinterview;

import java.util.*;
import java.util.ArrayList;

/**
 * Anagram Interview Question:
 *
 *    Typically posed as follows:
 *
 *        Given a word, and a "dictionary" find all anagrams of the given word (i.e. words which use all the same letters
 *        as the given word but in a different order.)
 */
public class Anagram {
    private Map<String, Collection<String>> anagramsByKey = new HashMap<>();

    public Collection<String> findAll(String word, Collection<String> dictionary) {
        preprocess(word, dictionary);

        Collection<String> anagrams = anagramsByKey.get(generateKey(word));

        if (anagrams == null) {
            anagrams = new HashSet<>();
        }

        return anagrams;
    }

    private void preprocess(String word, Collection<String> dictionary) {
        dictionary.stream().filter(entry -> !word.equals(entry)).forEach(entry -> {
            String key = generateKey(entry);

            if (!anagramsByKey.containsKey(key)) {
                anagramsByKey.put(key, new HashSet<>());
            }

            anagramsByKey.get(key).add(entry);
        });
    }

    private String generateKey(String entry) {
        List<Character> characters = new ArrayList<>();

        for (char c : entry.toCharArray()) {
            characters.add(c);
        }

        Collections.sort(characters);

        StringBuilder keySb = new StringBuilder();
        characters.forEach(keySb::append);

        return keySb.toString();
    }

}
