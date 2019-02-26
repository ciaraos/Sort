package sortComparison;
//-------------------------------------------------------------------------

/**
 * This class contains static methods that implementing sorting of an array of
 * numbers using different sort algorithms.
 *
 * @author
 * @version HT 2019
 */

class SortComparison {

	/**
	 * Sorts an array of doubles using InsertionSort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order.
	 *
	 */
	static double[] insertionSort(double a[]) {
		double temp;
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
				//System.out.print(a[j] + " ");
			}
		}
		return a;
	}// end insertionsort

	/**
	 * Sorts an array of doubles using Quick Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] quickSort(double a[]) {
		recursiveQuick(a, 0, a.length - 1);
		return a;

		// todo: implement the sort

	}// end quicksort

	public static void recursiveQuick(double[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int pivotPos = partition(a, lo, hi);
		recursiveQuick(a, lo, pivotPos - 1);
		recursiveQuick(a, pivotPos + 1, hi);
	}

	private static int partition(double[] numbers, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		double pivot = numbers[lo];
		while (true) {
			while (numbers[++i] < pivot) {
				if (i == hi) {
					break;
				}
			}
			while (pivot < numbers[--j]) {
				if (j == lo) {
					break;
				}
			}
			if (i >= j)
				break;
			double temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
		}
		numbers[lo] = numbers[j];
		numbers[j] = pivot;
		return j;
	}

	/**
	 * Sorts an array of doubles using Merge Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	/**
	 * Sorts an array of doubles using iterative implementation of Merge Sort. This
	 * method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */

	static double[] mergeSortIterative(double a[]) {
		int length = a.length;
		double[] aux = new double[length];
		for(int index = 1; index <= length - 1; index *= 2)
		{
			for(int low = 0; low < length - 1; low += (2 * index))
			{
				int mid = low + index - 1;
				int high = Math.min(low + 2 * index - 1, length - 1);
				myMergeIterative(a, aux, low, mid, high);
			}
		}
		return a;

		// todo: implement the sort

	}// end mergesortIterative

	private static void myMergeIterative(double a[], double[] aux, int lo, int mid, int hi) {
		for(int k = lo; k <= hi; k++)
		{
			aux[k] = a[k];
		}
		
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if ((aux[j] < aux[i])) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
	}

	/**
	 * Sorts an array of doubles using recursive implementation of Merge Sort. This
	 * method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */
	static double[] mergeSortRecursive(double a[]) {
		int length = a.length;
		double[] aux = new double[length];
		for(int index = 1; index <= length - 1; index *= 2)
		{
			for(int low = 0; low < length - 1; low += (2 * index))
			{
				int high = Math.min(low + 2 * index - 1, length - 1);
				myMergeSortRecursive(a, aux, low, high);
			}
		}
		return a;

		// todo: implement the sort

	}// end mergeSortRecursive

	private static void myMergeSortRecursive(double a[], double aux[], int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		myMergeSortRecursive(aux, a, lo, mid);
		myMergeSortRecursive(aux, a, mid + 1, hi);
		myMergeIterative(a, aux, lo, mid, hi);
	}

	/**
	 * Sorts an array of doubles using Selection Sort. This method is static, thus
	 * it can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] selectionSort(double a[]) {
		double n = a.length;
		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (a[j] < a[min_idx])
					min_idx = j;
			// Swap the found minimum element with the first
			// element
			double temp = a[min_idx];
			a[min_idx] = a[i];
			a[i] = temp;
		}
		return a;

		// todo: implement the sort

	}// end selectionsort

	public static void main(String[] args) {
		// todo: do experiments as per assignment instructions
	}
	
	public static String toString(double a[]) {
		String result = "";
		for (int i = 0; i < a.length; i++) {
			result += a[i] + ", ";
		}
		return result;

	}

}// end class
