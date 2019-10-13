import java.util.Random;

public class Randomized_quick_sort {
	public static void swap(int[] arr, int a, int b) 
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public int[] QuickSort(int[] A, int start, int end) {

		if (end > start) {
			Random rand = new Random();
			int pIndex = start + rand.nextInt(end - start + 1);
			swap(A, pIndex, end);
			int pivot = A[end];
			int index = partition(A, start, end, pivot);
			QuickSort(A, start, index - 1);
			QuickSort(A, index + 1, end);
		}
		/*
		 * long stopTime = System.currentTimeMillis(); long elapsedTime =
		 * stopTime - startTime; System.out.println("\n" + elapsedTime +
		 * "milliseconds");
		 */
		return A;
	}

	public static int partition(int[] A, int start, int end, long pivot) {
		int startPtr = start - 1;
		int endPtr = end;
		while (true) {
			while (A[++startPtr] < pivot)
				;
			while (endPtr > 0 && A[--endPtr] > pivot)
				;
			if (startPtr >= endPtr)
				break;
			else
				swap(A, startPtr, endPtr);
		}
		swap(A, startPtr, end);
		return startPtr;
	}
}
