package techinterview;
 
import java.util.Arrays;

public class ArrayList<E> {
 
    private Object[] array;
    private int size;
    
    public ArrayList() {
        this(10);
    }
     
    public ArrayList(int n) {
        array = new Object[n];
        size = 0;
    }
     
    public void add(E value) {
        add(size, value);
    }
    
    public void add(int index, E value) {
        if (index >= 0 && index <= size) {
            int curr = size;
            while (curr > index) {
                array[curr] = array[curr - 1];
                curr--;
            }
            array[index] = value;
            size++;
            if (array.length - size < 5)
                array = Arrays.copyOf(array, array.length * 2);
        } 
        else
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
     
    public E get(int index) {
        if (index >= 0 && index < size)
            return (E) array[index];
        else
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
     
    public E remove(int index) {
        if (index >= 0 && index < size) {
            E value = (E) array[index];
            while (index < size - 1) {
                array[index] = array[index + 1];
                index++;
            }
            size--;
            return value;
        } 
        else
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
     
    public int size() {
        return size;
    }
     
    public static void main(String a[]) {
        ArrayList al = new ArrayList();
        al.add(0);
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        for (int i = 0; i < al.size(); i++)
            System.out.print(al.get(i) + " ");
        System.out.println();
        
        System.out.println("Element at Index 4: " + al.get(4));
        System.out.println("Removing element at index 2: " + al.remove(2));
        for (int i = 0; i < al.size(); i++)
            System.out.print(al.get(i) + " ");
        System.out.println();
        al.add(2, 2);
        for (int i = 0; i < al.size(); i++)
            System.out.print(al.get(i) + " ");
        System.out.println();
    }
}