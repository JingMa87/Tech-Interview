package techinterview;

import java.util.Arrays;

public class Vector<E> {

    private Object[] array;
    private int count;

    public Vector() {
        this(10);
    }

    public Vector(int size) {
        array = new Object[size];
        count = 0;
    }

    public synchronized void add(E value) {
        if (count == array.length) 
            array = Arrays.copyOf(array, array.length * 2);
        array[count++] = value;
    }

    public synchronized E get(int index) {
        if ( index < 0 || index >= count)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        return (E) array[index];
    }

    public synchronized E remove(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + count);

        E value = (E) array[index];
        for (int i = index; i < count; i++)
            array[i] = array[i + 1];
        count--;
        return value;
    }

    public void display() {
        System.out.print("Displaying list: ");
        for (int i = 0; i < count; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static void main(String...a) {
        Vector<Integer> list = new Vector<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.display();
        
        System.out.println("Element at index " + 1 + ": " + list.get(1));
        System.out.println("Element removed from index " + 1 + ": " + list.remove(1));
        list.display();
    }
}