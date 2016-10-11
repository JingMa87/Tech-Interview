package TechInterview;

import java.util.Arrays;
import static java.lang.System.out;

/**
 * @author gavin
 */
public class InsertionSort {

    /**
     * Sorts the parameter in-place
     *
     * @param list an array
     */
    public static final void sort(int[] list) {
        if (null == list || list.length <= 1) {
            return;
        }

        for (int i = 1; i < list.length; i++) {
            int j = i;
            while (j > 0 && (list[j - 1] > list[j])) {
                swap(list, j);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nullList = null;
        int[] emptyList = new int[0];
        int[] singleItemList = {23};
        int[] nonEmptyList = {23, 44, 1, 209, 2, 88, 13, 37};
        int[] worstcaseList = {209, 88, 44, 37, 23, 13, 2, 1};
        int[] sortedList = {1, 2, 13, 23, 37, 44, 88, 209};

        insertionSort(nullList, "null list");
        insertionSort(emptyList, "empty list");
        insertionSort(singleItemList, "single item list");
        insertionSort(nonEmptyList, "non empty list");
        insertionSort(worstcaseList, "worse case list");
        insertionSort(sortedList, "already sorted list");
    }

    private static void insertionSort(int[] list, String comment) {
        out.println(comment);
        out.println("\tbefore: " + Arrays.toString(list));
        sort(list);
        out.println("\t after: " + Arrays.toString(list));
    }

    private static void swap(int[] list, int j) {
        int prev = list[j - 1];
        int next = list[j];
        list[j - 1] = next;
        list[j] = prev;
    }
}
