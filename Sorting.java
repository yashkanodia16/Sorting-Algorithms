import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
//import java.util.Vector;

public class Sorting {

	public static void main(String[] args) 
	{
		int inputArraySizes[] = {20000, 30000, 40000, 50000, 60000};
		//int inputArraySizes[] = {20000};
		int length = inputArraySizes.length;
		double insertionTime[] = new double[length];
		double mergeTime[] = new double[length];
		double quickTime[] = new double[length];
		double randomQuickTime[] = new double[length];
		double heapTime[] = new double[length];
		double insertionTimeDouble;
		double mergeTimeDouble;
		double quickTimeDouble;
		double randomQuickTimeDouble;
		double heapTimeDouble;
		
		int[] array = null;
		Random rand = new Random();
		Comparable com[] = null;
		//Vector<Integer> vector = null;
		Scanner scan=new Scanner(System.in);
		int iterations = 3;

		InsertionSort insert = new InsertionSort();
		MergeSort merge = new MergeSort();
		QuickSortMedian quick = new QuickSortMedian();
		Randomized_quick_sort ran = new Randomized_quick_sort();
		ReverseSort reverse = new ReverseSort();
		HeapSort heap = new HeapSort();

		System.out.println("Choose one: \n 1. Unsorted Array \n 2. Sorted Array \n 3. Reversely Sorted Array" );
		int userInput= scan.nextInt();
		
		for(int j = 0 ; j < length; j++) {
			insertionTimeDouble = 0;
			mergeTimeDouble = 0;
			quickTimeDouble = 0;
			randomQuickTimeDouble = 0;
			heapTimeDouble = 0;
			array = new int[inputArraySizes[j]];
			com = new Comparable[inputArraySizes[j]];
			//vector = new Vector<Integer>();
			for(int k = 0; k < iterations;  k++) {
				//vector.clear();
				for (int i = 0; i < array.length; i++) 
				{
					array[i] = rand.nextInt(4000) + 1;
					com[i]=array[i];
					//vector.add(array[i]);
				}
				if(userInput==2)
				{
					//vector.clear();
					insert.sort(array);
					for (int i = 0; i < array.length; i++)
					{
						com[i]=array[i];
						//vector.add(array[i]);
					}

				}

				if(userInput==3)
				{
					//vector.clear();
					reverse.rsort(array);
					for (int i = 0; i < array.length; i++)
					{
						com[i]=array[i];
						//vector.add(array[i]);
					}
				}
				System.out.println();
				System.out.print("Runnung for Array size " + inputArraySizes[j] + " : Iteration " + (k+1));
				System.out.println();
				//sort(array, com, insert, merge, quick, ran, heap);
				
				System.out.println();

				double startTime = System.currentTimeMillis();
				insert.sort(array);
				double stopTime = System.currentTimeMillis();
				double elapsedTime =stopTime - startTime;
				System.out.println("Sorting using insertion sort: " + elapsedTime +"milliseconds");
				insertionTimeDouble += elapsedTime;
			
				System.out.println();

				startTime = System.currentTimeMillis();
				merge.partition(array);
				stopTime= System.currentTimeMillis();
				elapsedTime =stopTime - startTime; 
				System.out.println("Sorting using merge sort " + elapsedTime +"milliseconds");
				mergeTimeDouble += elapsedTime;
				
				System.out.println();

				startTime = System.currentTimeMillis();
				ran.QuickSort(array, 0, array.length -1);
				stopTime= System.currentTimeMillis();
				elapsedTime =stopTime - startTime; 
				System.out.println("Sorting using randomized quick sort " + elapsedTime +"milliseconds");
				randomQuickTimeDouble += elapsedTime;
				
				System.out.println();
				
				startTime = System.currentTimeMillis();
				quick.quicksort(com);
				stopTime= System.currentTimeMillis();
				elapsedTime =stopTime - startTime; 
				System.out.println("Sorting using Quick median sort " + elapsedTime +"milliseconds");
				quickTimeDouble += elapsedTime;
				
				System.out.println();
				
				startTime = System.currentTimeMillis();
				heap.heap_sort(array);
				stopTime= System.currentTimeMillis();
				elapsedTime =stopTime - startTime; 
				System.out.println("Sorting using Heap sort " + elapsedTime +"milliseconds");
				System.out.println();
				heapTimeDouble += elapsedTime;
				
				//System.out.println("Randomised " + randomQuickTimeDouble);
				
			}
			
			insertionTime[j] = (insertionTimeDouble / iterations);
			mergeTime[j] = (mergeTimeDouble / iterations);
			randomQuickTime[j] = (randomQuickTimeDouble / iterations);
			quickTime[j] = (quickTimeDouble / iterations);
			heapTime[j] = (heapTimeDouble / iterations);
			
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}	
		System.out.println();
		System.out.println("Sorting time Insert sort for input arrays: " + Arrays.toString(insertionTime));
		System.out.println("Sorting time Merge sort for input arrays: " + Arrays.toString(mergeTime));
		System.out.println("Sorting time Ramdomised quick sort for input arrays: " + Arrays.toString(randomQuickTime));
		System.out.println("Sorting time Quick Median sort for input arrays: " + Arrays.toString(quickTime));
		System.out.println("Sorting time Heap sort for input arrays: " + Arrays.toString(heapTime));
	}

//	private static void sort(int[] array, Comparable[] com, InsertionSort insert, MergeSort merge, QuickSortMedian quick, Randomized_quick_sort ran, HeapSort heap) {
//		// TODO Auto-generated method stub
//		System.out.println();
//
//		double startTime1 = System.currentTimeMillis();
//		insert.sort(array);
//		double stopTime1 = System.currentTimeMillis();
//		double elapsedTime1 =stopTime1 - startTime1; 
//		System.out.println("Sorting using insertion sort: " + elapsedTime1 +"milliseconds");
//	
//		System.out.println();
//
//		double startTime2 = System.currentTimeMillis();
//		merge.partition(array);
//		double stopTime2= System.currentTimeMillis();
//		double elapsedTime2 =stopTime2 - startTime2; 
//		System.out.println("Sorting using merge sort " + elapsedTime2 +"milliseconds");
//
//		System.out.println();
//
//		double startTime3 = System.currentTimeMillis();
//		ran.QuickSort(array, 0, array.length -1);
//		double stopTime3 = System.currentTimeMillis();
//		double elapsedTime3 =stopTime3 - startTime3; 
//		System.out.println("Sorting using randomized quick sort " + elapsedTime3 +"milliseconds");
//		
//		System.out.println();
//		
//		double startTime4 = System.currentTimeMillis();
//		quick.quicksort(com);
//		double stopTime4 = System.currentTimeMillis();
//		double elapsedTime4 =stopTime4 - startTime4;
//		System.out.println("Sorting using Quick median sort " + elapsedTime4 +"milliseconds");
//		
//		System.out.println();
//		
//		double startTime5 = System.currentTimeMillis();
//		heap.heap_sort(array);
//		double stopTime5 = System.currentTimeMillis();
//		double elapsedTime5 =stopTime5 - startTime5;
//		System.out.println("Sorting using Heap sort " + elapsedTime5 +"milliseconds");
//		System.out.println();
//	}
}
