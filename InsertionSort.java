public class InsertionSort {
	public int[] sort(int[] A) {
		for (int i = 1; i < A.length; i++) {
			int key = A[i];
			int j = i;
			while (j > 0 && A[j - 1] > key) {
				A[j] = A[j - 1];
				j = j - 1;
			}
			A[j] = key;
		}
		return A;
	}
}
