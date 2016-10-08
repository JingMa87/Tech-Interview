package techinterview;

public class SinglyLinkedList<E> {
    
    private Node head;
    private int size;
    
    public SinglyLinkedList() {
        head = new Node();
        size = 0;
    }
    
    public void add(E value) {
        if (value != null) {
            Node node = new Node(value);
            Node curr = head;
            while (curr.next != null) 
                curr = curr.next;
            curr.next = node;
            size++;
        }
    }
    
    public void addFirst(E value) {
        if (value != null) {
            Node node = new Node(value);
            node.next = head.next;
            head.next = node;
            size++;
        }
    }
    
    public Node remove(int index) {
        if (index >= 0 && index < size) {
            Node curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
            size--;
            return curr;
        }
        return null;
    }
    
    public E get(int index) {
        if (index > 0 && index < size) {
            Node curr = head;
            for (int i = 0; i <= index; i++) {
                curr = curr.next;
            }
            return curr.getValue();
        }
        return null;
    }
    
    public void reverseOrder() {
        Node prev = null;
        Node curr = head;
        Node next;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = prev;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        for (int i = 0; i < size; i++) {
            curr = curr.next;
            sb.append(curr.value);
            if (i != size - 1)
                sb.append(" ");
        }
        return sb.toString();
    }
    
    public class Node {

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
        SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
        ll.add(42);
        ll.add(21);
        ll.add(459);
        System.out.println(ll);
        
        ll.addFirst(4);
        ll.addFirst(1);
        ll.addFirst(289);
        System.out.println(ll);
        
        ll.remove(0);
        System.out.println(ll);
        
        ll.reverseOrder();
        System.out.println(ll);
    }
}