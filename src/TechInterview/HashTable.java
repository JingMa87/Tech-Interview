package TechInterview;

public class HashTable {
    
    private final int SIZE = 128;
    private final HashEntry[] TABLE;

    public HashTable() {
        TABLE = new HashEntry[SIZE];
    }

    public void put(int key, int value) {
        TABLE[getHashCode(key)] = new HashEntry(key, value);
    }

    public int get(int key) {
        int hashCode = getHashCode(key);
        return TABLE[hashCode] == null ? -1 : TABLE[hashCode].value;
    }
    
    private int getHashCode(int key) {
        int hashCode = key % SIZE;
        while (TABLE[hashCode] != null && TABLE[hashCode].key != key)
            hashCode = (hashCode + 1) % SIZE;
        return hashCode;
    }
      
    private class HashEntry {
        
        private int key;
        private int value;

        public HashEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.put(0, 90);
        ht.put(128, 180);
        ht.put(256, 34);
        System.out.print(ht.get(0) + " ");
        System.out.print(ht.get(128) + " ");
        System.out.print(ht.get(256) + " ");
        System.out.println();
    }
}