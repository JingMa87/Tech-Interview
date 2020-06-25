package techinterview;

public class BinarySearch {
    
    public static int binarySearch(int[] array, int value) {
        int start = 0;
        int end = array.length;
        int mid;
        
        while (start < end) {
            mid = (start + end) / 2;
            if (value == array[mid])
                return mid;
            else if (value < array[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] array = {3, 6, 9, 15, 23, 43, 87};
        System.out.println(binarySearch(array, 87));
    }
}