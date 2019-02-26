package sortComparison;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//-------------------------------------------------------------------------

/**
 * This class contains static methods that implementing sorting of an array of
 * numbers using different sort algorithms.
 *
 * @author Ciara O'Sullivan
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
		double tmp;
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					tmp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = tmp;
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

	public static void recursiveQuick(double[] a, int low, int high) {
		if (high <= low) {
			return;
		}
		int pivot = partition(a, low, high);
		recursiveQuick(a, low, pivot - 1);
		recursiveQuick(a, pivot + 1, high);
	}

	private static int partition(double[] a, int low, int high) {
		int i = low;
		int j = high + 1;
		double pivot = a[low];
		while (true) {
			while (a[++i] < pivot) {
				if (i == high) {
					break;
				}
			}
			while (pivot < a[--j]) {
				if (j == low) {
					break;
				}
			}
			if (i >= j)
				break;
			double tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
		a[low] = a[j];
		a[j] = pivot;
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
		int aLength = a.length;
		double[] aux = new double[aLength];
		for(int index = 1; index <= aLength - 1; index *= 2)
		{
			for(int low = 0; low < aLength - 1; low += (2 * index))
			{
				int mid = low + index - 1;
				int high = Math.min(low + 2 * index - 1, aLength - 1);
				myMergeIterative(a, aux, low, mid, high);
			}
		}
		return a;

		// todo: implement the sort

	}// end mergesortIterative

	private static void myMergeIterative(double a[], double[] aux, int low, int mid, int high) {
		for(int k = low; k <= high; k++)
		{
			aux[k] = a[k];
		}
		
		int i = low;
		int j = mid + 1;
		for (int k = low; k <= high; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > high) {
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
		int aLength = a.length;
		double[] aux = new double[aLength];
		for(int index = 1; index <= aLength - 1; index *= 2)
		{
			for(int low = 0; low < aLength - 1; low += (2 * index))
			{
				int high = Math.min(low + 2 * index - 1, aLength - 1);
				myMergeSortRecursive(a, aux, low, high);
			}
		}
		return a;

		// todo: implement the sort

	}// end mergeSortRecursive

	private static void myMergeSortRecursive(double a[], double aux[], int low, int high) {
		if (high <= low) {
			return;
		}
		int mid = low + (high - low) / 2;
		myMergeSortRecursive(aux, a, low, mid);
		myMergeSortRecursive(aux, a, mid + 1, high);
		myMergeIterative(a, aux, low, mid, high);
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
		double aLength = a.length;
		for (int i = 0; i < aLength - 1; i++) {
			int index = i;
			for (int j = i + 1; j < aLength; j++)
				if (a[j] < a[index])
					index = j;
			double tmp = a[index];
			a[index] = a[i];
			a[i] = tmp;
		}
		return a;

		// todo: implement the sort

	}// end selectionsort

	public static void main(String[] args) {
		// todo: do experiments as per assignment instructions
	}
	
	public static String toString(double a[]) {
		String myString = "";
		for (int i = 0; i < a.length; i++) {
			myString += a[i] + ", ";
		}
		return myString;

	}

}// end class
