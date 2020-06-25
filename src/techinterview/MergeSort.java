package techinterview;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] list) {
        int n = list.length;
        if (n <= 1) return list;
        
        int mid = n / 2;
        int[] list1 = new int[mid];
        int[] list2 = new int[n - mid];
        for (int i = 0; i < mid; i++)
            list1[i] = list[i];
        for (int i = mid; i < n; i++)
            list2[i - mid] = list[i];
        
        mergeSort(list1);
        mergeSort(list2);
        merge(list1, list2, list);
        return list;
    }

    private static void merge(int[] list1, int[] list2, int[] result) {
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        
        while (index1 < list1.length && index2 < list2.length) {
            if (list1[index1] < list2[index2])
                result[index3++] = list1[index1++];
            else
                result[index3++] = list2[index2++];
        }
        while (index1 < list1.length)
            result[index3++] = list1[index1++];
        while (index2 < list2.length)
            result[index3++] = list2[index2++];
    }
    
    public static void main(String[] args) {
        int[] list = {12, 327, 51, 3, 190, 76, 1, 35, 202, 116};
        System.out.println(Arrays.toString(list));
        
        mergeSort(list);
        System.out.println(Arrays.toString(list));
    }
}