package pkjDS;

import static pkjDS.Swap_Delay.swap;

public class SimpleSorts {
	
	public static void shuffle(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int random = i + (int) (Math.random() * (array.length - i));
			swap(array, i, random);
		}
	}
	
	public static void reversed(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = array.length-i-1;
		}
	}
	
	public static void sorted(int [] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
			}
	}
	
	public static void setChoice(int x, int [] array) {
		if(x == 1)
			shuffle(array);
		else if(x == 2)
			reversed(array);
		else if(x == 3)
			sorted(array);
	}
	
	public static double insertionSort(int[] array) {
		long start = System.nanoTime();
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
				swap(array, j, j - 1);
			}
		}
		return(((double) (System.nanoTime()-start))/100000000);
	}

	public static double selectionSort(int[] array) {
		long start = System.nanoTime();
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}

			if (minIndex != i) {
				swap(array, minIndex, i);
			}
		}
		return(((double) (System.nanoTime()-start))/100000000);
	}

	public static double bubbleSort(int[] array) {
		long start = System.nanoTime();
		for (int i = 1; i < array.length; i++) {
			for (int j = 1; j < array.length; j++) {
				if (array[j - 1] > array[j]) {
					swap(array, j, j - 1);
				}
			}
		}
		return(((double) (System.nanoTime()-start))/100000000);
	}
}
