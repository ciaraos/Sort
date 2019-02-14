package sortComparison;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/*

                                                          time in ms
*                       | insertion    | quick        | merge recursive  | merge iterative     | selection |
* ----------------------------------------------------------------------------------------------------------
* 10 random             |0.012         |0.193333      |0.027112          |0.083556             |0.536888   |
* ----------------------------------------------------------------------------------------------------------
* 100 random            |0.389778      |0.059556      |0.304444          |0.130666             |0.286666   |
* ----------------------------------------------------------------------------------------------------------
* 1000 random           |6.768886      |1.462667      |3.646665          |5.393333             |10.403548  |
* ----------------------------------------------------------------------------------------------------------
* 1000 few unique       |10.108888     |5.520888      |1.871556          |3.414222m            |7.424443   |
* ----------------------------------------------------------------------------------------------------------
* 1000 nearly ordered   |3.9926        |0.212         |1.932             |2.340445             |9.709332   |
* ----------------------- -----------------------------------------------------------------------------------
* 1000 reverse order    |10.530221     |3.394666      |2.895556          |2.208888             |10.359999  |
* ----------------------------------------------------------------------------------------------------------
* 1000 sorted           |1.143999      |1.127999      |1.824888          |3.111555             |7.548444   |
* ----------------------------------------------------------------------------------------------------------

*

* Questions:

* a)Which of the sorting algorithms does the order of input have an impact on? Why?
	Quick sort and Insertion sort are affected by input size as can be seen by nearly ordered ad reverse 

* b)Which algorithm has the biggest difference between the best and worst performance, based
on the type of input, for the input of size 1000? Why?
	Insertion Sort: there is a big difference between reverse order at 10ms and sorted order at 1ms

* c)Which algorithm has the best/worst scalability, i.e., the difference in performance time
based on the input size? Please consider only input files with random order for this answer.
	Best: Quick, 1ms at 1000, 0ms at 100 and 10
	Worst: Selection sort, 10ms at 1000 and 0 at 100 and 10

* d)Did you observe any difference between iterative and recursive implementations of merge
sort?
	There is a difference but it is so small that it doesn't really matter due to the order of magnitude 

e)Which algorithm is the fastest for each of the 7 input files?

---------------------------------------------------------------
|input file          |Fastest algorithm                        |
---------------------------------------------------------------
|random10            |any can be used as input size is so small|
---------------------------------------------------------------
|random100           |any can be used as input size is so small|
---------------------------------------------
|random1000          |Quick sort            |
--------------------------------------------
|fewUnique1000       |Merge sort recursive  |
--------------------------------------------
|nearlyOrdered1000   |Quick sort            |
--------------------------------------------
|reverse1000         |Both merges           |
--------------------------------------------
|sorted1000          |Insertion Sort        |
--------------------------------------------
*/

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Ciara O'Sullivan
 *  @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    //test constructor
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
    	String[] inputFiles = new String[]{"C:\\Users\\ciara\\Documents\\College\\2nd Year\\numbers10.txt", 
	    		"C:\\Users\\ciara\\Documents\\College\\2nd Year\\numbers100.txt",
	    		"C:\\Users\\ciara\\Documents\\College\\2nd Year\\numbers1000.txt",
	    		"C:\\Users\\ciara\\Documents\\College\\2nd Year\\numbers1000Duplicates.txt",
	    		"C:\\Users\\ciara\\Documents\\College\\2nd Year\\numbersNearlyOrdered1000.txt",
	    		"C:\\Users\\ciara\\Documents\\College\\2nd Year\\numbersReverse1000.txt",
	    		"C:\\Users\\ciara\\Documents\\College\\2nd Year\\numbersSorted1000.txt"};

        for (String myFile : inputFiles) {
            ArrayList<Double> numbers = new ArrayList<>();
            try (BufferedReader buffReader = new BufferedReader(new FileReader(myFile))) {
                String readLine = buffReader.readLine();
                while (readLine != null) {
                	readLine = buffReader.readLine();
                    if (readLine != null) numbers.add(Double.parseDouble(readLine));
                }

                double[] a = restartArr(numbers);
                double start = System.nanoTime();
                SortComparison.selectionSort(a);
                double end = System.nanoTime();
                double totalTime = (end - start) / 1000000;
                System.out.println(myFile.split("/")[myFile.split("/").length - 1] + " Selection Sort : " + totalTime + "ms");

                a = restartArr(numbers);
                start = System.nanoTime();
                SortComparison.insertionSort(a);
                end = System.nanoTime();
                totalTime = (end - start) / 1000000;
                System.out.println(myFile.split("/")[myFile.split("/").length - 1] + " Insertion Sort : " + totalTime + "ms");

                a = restartArr(numbers);
                start = System.nanoTime();
                SortComparison.mergeSortIterative(a);
                end = System.nanoTime();
                totalTime = (end - start) / 1000000;
                System.out.println(myFile.split("/")[myFile.split("/").length - 1] + " Merge Sort Iterative : " + totalTime + "ms");


                a = restartArr(numbers);
                start = System.nanoTime();
                SortComparison.mergeSortRecursive(a);
                end = System.nanoTime();
                totalTime = (end - start) / 1000000;
                System.out.println(myFile.split("/")[myFile.split("/").length - 1] + " Merge Sort Recursive : " + totalTime + "ms");

                a = restartArr(numbers);
                start = System.nanoTime();
                SortComparison.quickSort(a);
                end = System.nanoTime();
                totalTime = (end - start) / 1000000;
                System.out.println(myFile.split("/")[myFile.split("/").length - 1] + " Quick Sort : " + totalTime + "ms");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static double[] restartArr(ArrayList<Double> doubles) {
        double[] a;
        a = new double[doubles.size()];
        for (int j = 0; j < a.length; j++) {
            a[j] = doubles.get(j);
        }
        return a;
    }
}
