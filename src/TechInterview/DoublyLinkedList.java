package TechInterview;

public class DoublyLinkedList<E> {
    
    private Node head;
    private Node tail;
    private int size;
    
    public DoublyLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    public void add(E value) {
        Node node = new Node(value);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }
    
    public Node remove(int index) {
        Node curr = head;
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        size--;
        return curr;
    }
    
    public E get(int index) {
        Node curr = head;
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        return curr.getValue();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node curr = head;
        for (int i = 0; i < size; i++) {
            curr = curr.next;
            sb.append(curr.value);
            if (i != size - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
    
    public class Node {

        private Node prev;
        private Node next;
        private E value;

        public Node() {
            this.value = null;
        }

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }
    }
    
    public static void main(String[] args) {
        DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
        ll.add(4);
        ll.add(1);
        ll.add(289);
        System.out.println(ll);
        
        ll.remove(0);
        System.out.println(ll);
    }
}