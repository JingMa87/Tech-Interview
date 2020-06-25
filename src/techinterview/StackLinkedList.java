package techinterview;

public class StackLinkedList<E> {

    private Node head;
    private int size = 0;
    
    public void push(E value) {
        Node curr = new Node(value);
        curr.next = head;
        head = curr;
        size++;
    }

    public E pop() {
        if (head != null) {
            E value = head.value;
            head = head.next;
            size--;
            return value;
        }
        return null;
    }
    
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            sb.append(curr.value).append(" ");
            curr = curr.next;
        }
        return sb.toString();
    }

    public class Node {
        
        private E value;
        private Node next;
        
        public Node(E value) {
            this.value = value;
        }
    }
    
    public static void main(String[] args) {
        StackLinkedList<Integer> stack = new StackLinkedList<>();
        stack.push(25);
        stack.push(12);
        stack.push(7);
        stack.push(82);
        System.out.println("Stack: " + stack);
        System.out.println("Size: " + stack.size());
        
        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack: " + stack);
        System.out.println("Size: " + stack.size());
    }
}