package techinterview;

public class StackArray {

    private int size;
    private int[] array;
    private int top;
    
    public StackArray(int size) {
        this.size = size;
        array = new int[size];
        top = -1;
    }
    
    public StackArray() {
        this(10);
    }
    
    public void push(int value) {
        if (top < size - 1)
            array[++top] = value;
    }
    
    public int pop() {
        if (top > -1)
            return array[top--];
        return -1;
    }
    
    public int peek() {
        if (top > -1)
            return array[top];
        return -1;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == size - 1;
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray(10); 
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
        System.out.println();
    }
}