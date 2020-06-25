package TechInterview;

import java.util.Arrays;
import java.util.Random;

/**
 * Solution to the problem #9.1 about merging two sorted arrays
 * of chapter 'Sorting and Searching' from book 'Cracking the Coding Interview'.
 */

public class MergeArrays {

    private static int SIZE_A = 50;
    private static int SIZE_B = 15;

    public static void main(String[] args) {


        int[] arrayA = new int[SIZE_A];
        int[] arrayB = new int[SIZE_B];


        Random random = new Random();
        for (int i = 0; i < (SIZE_A - SIZE_B); i++) {
            int q = random.nextInt(100);
            arrayA[i] = q;
        }


        for (int i = 0; i < SIZE_B; i++) {
            int q = random.nextInt(100);

            arrayB[i] = q;
        }

        Arrays.sort(arrayA, 0, SIZE_A - SIZE_B);
        Arrays.sort(arrayB, 0, SIZE_B);

        System.out.println("Array A before merge");
        for (int i : arrayA)
            System.out.print(i + " ");
        System.out.println("\nArray B before merge");
        for (int i : arrayB)
            System.out.print(i + " ");

        System.out.println("\n\nMerging...");
        mergeArrays(arrayA, arrayB);

    }

    private static void mergeArrays(int[] arrayA, int[] arrayB) {

        int i = SIZE_A - SIZE_B - 1;
        int j = SIZE_B - 1;
        while (i >= 0 && j >= 0) {
            if (arrayA[i] > arrayB[j]) {
                arrayA[i + j + 1] = arrayA[i];
                i--;
            } else {
                arrayA[i + j + 1] = arrayB[j];
                j--;
            }
        }

        while (j >= 0) {
            arrayA[i + j + 1] = arrayB[j];
            j--;
        }

        System.out.println("\nArray A after merge:");
        for (int k : arrayA)
            System.out.print(k + " ");
    }
}
