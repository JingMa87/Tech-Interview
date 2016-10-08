package techinterview;

public class Queue<E> {

    private Node first;
    private Node last;
    private int size;

    public void enqueue(E value) {
        if (first == null) {
            last = new Node(value);
            first = last;
        } 
        else {
            last.next = new Node(value);
            last = last.next;
        }
        size++;
    }

    public E dequeue() {
        if (first != null) {
            E value = first.value;
            first = first.next;
            size--;
            return value;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = first;
        while (curr != null) {
            sb.append(curr.value).append(" ");
            curr = curr.next;
        }
        return sb.toString().trim();
    }

    public class Node {
        
        private E value;
        private Node next;
        
        public Node(E value) {
            this.value = value;
        }
    }
    
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(14);
        queue.enqueue(6);
        queue.enqueue(98);
        System.out.println("Queue: " + queue);
        System.out.println("Size: " + queue.size);
        
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Queue: " + queue);
        System.out.println("Size: " + queue.size);
    }
}