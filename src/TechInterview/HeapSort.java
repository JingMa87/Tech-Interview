package TechInterview;

import java.util.Arrays;

public class HeapSort {
	
	public static int[] heapSort(int list[]) {
		int size = list.length;
		
		for (int i = size/2 - 1; i >= 0; i--) {
			heapify(list, size, i);
		}
		
		for(int i = list.length-1; i >= 0; i--) {
			int swap = list[0];
			list[0] = list[i];
			list[i] = swap;
			size--;
			heapify(list, size, 0);
		}
		return list;
	}
	
	private static int leftChild(int i) {
		return 2 * i + 1;
	}
	
	private static int rightChild(int i) {
		return 2 * i + 2;
	}
	
	private static void heapify(int[] list, int size, int i) {
		int largestElementIndex = i;
		int leftChildIndex = leftChild(i);
		if (leftChildIndex < size && list[leftChildIndex] > list[largestElementIndex]) {
			largestElementIndex = leftChildIndex;
		}
		
		int rightChildIndex = rightChild(i);
  		if (rightChildIndex < size && list[rightChildIndex] > list[largestElementIndex]) {
	  		largestElementIndex = rightChildIndex;
  		}
		if (largestElementIndex != i) {
			int swap = list[i];
			list[i] = list[largestElementIndex];
			list[largestElementIndex] = swap;
			heapify(list, size, largestElementIndex);
		}
	}
	
	public static void main(String[] args) {
		int[] list = {9, 8, 10, 3, 5, 4, 7, 2, 1, 6};
		System.out.println(Arrays.toString(list));
		
		heapSort(list);
		System.out.println(Arrays.toString(list));
	}
}
