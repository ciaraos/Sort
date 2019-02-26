package sortComparison;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	String expectedResult="";
    	double[] a = {};
    	
		double[] expected1 = SortComparison.insertionSort(a);
		assertEquals("To test empty insertion sort", expectedResult,SortComparison.toString(expected1));
 	
		double[] expected2 = SortComparison.quickSort(a);
		assertEquals("To test empty quick sort", expectedResult,SortComparison.toString(expected2));
 	
		double[] expected3 = SortComparison.mergeSortIterative(a);
		assertEquals("To test empty merge sort iterative", expectedResult,SortComparison.toString(expected3));

		double[] expected4 = SortComparison.mergeSortRecursive(a);
		assertEquals("To test empty merge sort recursive", expectedResult,SortComparison.toString(expected4));

		double[] expected5 = SortComparison.selectionSort(a);
		assertEquals("To test empty selection sort", expectedResult,SortComparison.toString(expected5));
    }
    
    @Test
    public void testInsertionSort()
    {
    	double[] a = {62, 83, 18, 53};
    	double[] expected = {18, 53, 62, 83};
    	double[] actual = SortComparison.insertionSort(a);
    	assertEquals("To test insertion sort", SortComparison.toString(expected), SortComparison.toString(actual));
    }
    
    @Test 
    public void testQuickSort()
    {
    	double[] a = {62, 83, 18, 53};
    	double[] expected = {18, 53, 62, 83};
    	double[] actual = SortComparison.quickSort(a);
    	assertEquals("To test quick sort", SortComparison.toString(expected), SortComparison.toString(actual));
    }
    
    @Test
    public void testMergeSortIterative()
    {
    	double[] a = {62, 83, 18, 53};
    	double[] expected = {18, 53, 62, 83};
    	double[] actual = SortComparison.mergeSortIterative(a);
    	assertEquals("To test merge sort iterative", SortComparison.toString(expected), SortComparison.toString(actual));
    }
    
    @Test
    public void testMergeSortRecursive()
    {
    	double[] a = {62, 83, 18, 53};
    	double[] expected = {18, 53, 62, 83};
    	double[] actual = SortComparison.mergeSortRecursive(a);
    	assertEquals("To test merge sort recursive", SortComparison.toString(expected), SortComparison.toString(actual));
    }
    
    @Test
    public void testSelectionSort()
    {
    	double[] a = {62, 83, 18, 53};
    	double[] expected = {18, 53, 62, 83};
    	double[] actual = SortComparison.selectionSort(a);
    	assertEquals("To test selection sort", SortComparison.toString(expected), SortComparison.toString(actual));
    }


    // TODO: add more tests here. Each line of code and each decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    }

}
