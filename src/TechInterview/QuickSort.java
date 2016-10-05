package TechInterview;

import java.util.Arrays;

public class QuickSort {
    
    public static void quickSort(int[] list, int start, int end) {
        if (start < end) {
            int pivot = partition(list, start, end);
            quickSort(list, start, pivot - 1);
            quickSort(list, pivot + 1, end);
        }
    }
    
    private static int partition(int[] list, int start, int end) {
        int j = end - 1;
        int pivot = list[end];
        while (true) {
            while (list[start] < pivot)
                start++;
            while(list[j] > pivot)
                j--;
            if (start >= j) 
                break;
            int temp = list[start];
            list[start] = list[j];
            list[j] = temp;
        }
        int temp = list[start];
        list[start] = list[end];
        list[end] = temp;
        return start;
    }

    public static void main(String[] args) {
        int[] list = {23, 44, 1, 209, 2, 88, 13, 37};
        System.out.println(Arrays.toString(list));
        
        quickSort(list, 0, list.length - 1);
        System.out.println(Arrays.toString(list));
    }
}