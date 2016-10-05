package TechInterview;

import java.util.HashMap;

public class Trie {
    
    private Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void add(String word) {
        if (contains(word)) return;
        
        Node curr = root;
        for (char c : word.toCharArray()) {
            Node child = curr.getChild(c);
            if (child != null)
                curr = child;
            else {
                Node node = new Node();
                curr.children.put(c, node);
                curr = node;
            }
            curr.count++;
        }
        curr.isWord = true;
    }
    
    public Node remove(String word) {
        if (!contains(word)) return null;
                    
        Node curr = root;
        for (char c : word.toCharArray()) {
            Node child = curr.getChild(c);
            if (child.count == 1) {
                curr.children.remove(c);
                return child;
            }
            else {
                curr = child;
                curr.count--;
            }
        }
        curr.isWord = false;
        return curr;
    }
    
    public boolean contains(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            curr = curr.getChild(c);
            if (curr == null)
                return false;
        }
        return curr.isWord;
    }
    
    public class Node {
        
        private int count;
        private boolean isWord;
        private HashMap<Character, Node> children;
        
        public Node() {
            count = 0;
            isWord = false;
            children = new HashMap<>();
        }
        
        public Node getChild(char c) {
            return children.get(c);
        }
    }
    
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("apple");
        trie.add("app");
        trie.add("appli");
        System.out.println("Contains apple: " + trie.contains("apple"));
        System.out.println("Contains app: " + trie.contains("app"));
        System.out.println("Contains appli: " + trie.contains("appli"));
        trie.remove("apple");
        trie.remove("app");
        trie.remove("appli");
        System.out.println("Contains apple: " + trie.contains("apple"));
        System.out.println("Contains app: " + trie.contains("app"));
        System.out.println("Contains appli: " + trie.contains("appli"));
    }
}