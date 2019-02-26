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
* 10 random             |0.012         |0.193333      |0.027112          |0.083556             |1.536888   |
* ----------------------------------------------------------------------------------------------------------
* 100 random            |0.389778      |0.059556      |0.304444          |0.130666             |0.286666   |
* ----------------------------------------------------------------------------------------------------------
* 1000 random           |6.768886      |0.762667      |1.646665          |0.393333             |16.403548  |
* ----------------------------------------------------------------------------------------------------------
* 1000 duplicates       |1.108888      |1.520888      |0.871556          |0.414222m            |2.424443   |
* ----------------------------------------------------------------------------------------------------------
* 1000 nearly ordered   |0.3926        |0.212         |0.932             |0.340445             |1.709332   |
* ----------------------- -----------------------------------------------------------------------------------
* 1000 reverse order    |2.530221      |1.394666      |0.895556          |0.208888             |1.359999   |
* ----------------------------------------------------------------------------------------------------------
* 1000 sorted           |1.343999      |1.127999      |0.824888          |0.111555             |1.548444   |
* ----------------------------------------------------------------------------------------------------------

*

* Questions:

* a)Which of the sorting algorithms does the order of input have an impact on? Why?
*   -merge sort recursive is significantly faster when sorting nearly sorted or fully sorted arrays.
*    If is faster at sorting reverse arrays than random arrays but not as fast as the sorted or nearly sorted array

*   -merge sort iterative is quickest with a reverse array
*   -selection sort is the slowest with random100 input, which woud lead us to believe that that order of the array does matter,
*     and it is best suited to sorting nearly sorted, fully sorted or reverse array


* b)Which algorithm has the biggest difference between the best and worst performance, based
on the type of input, for the input of size 1000? Why?

selection sort has the biggest difference between worst and best run times.... best was 0.0216ms with the random10 input file
and the worst was 6.8849ms with the random1000 input file. That is  difference of 6.863 ms


* c)Which algorithm has the best/worst scalability, i.e., the difference in performance time
based on the input size? Please consider only input files with random order for this answer.


* d)Did you observe any difference between iterative and recursive implementations of merge
sort?


e)Which algorithm is the fastest for each of the 7 input files?

---------------------------------------------
|input file          |Fates algorithm       |
---------------------------------------------
|random10            |Quick sort            |
---------------------------------------------
|random100           |Quick sort            |
---------------------------------------------
|random1000          |Quick sort            |
--------------------------------------------
|fewUnique1000       |Merge sort recursive  |
--------------------------------------------
|nearlyOrdered1000   |Quick sort            |
--------------------------------------------
|reverse1000         |Merge sort recursive  |
--------------------------------------------
|sorted1000          |Merge sort iterative  |
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
