package pkjDS;

import javax.swing.*;

import static pkjDS.MyLilPane.setUnits;
import static pkjDS.SimpleSorts.setChoice;
import java.util.Arrays;
import java.util.Scanner;

public class SortingVisualizer {

	private static Scanner s;

	public static void main(String[] args) throws InterruptedException {
		s = new Scanner(System.in);
		System.out.println("Quick Sort = Q \nMerge Sort = M \nHeap Sort = H \nBubble Sort = B \n"
				+ "Insertion Sort = I \nSelection Sort = S \nRadix Sort = R \nCounting Sort = C\n---------");
		System.out.println("1. Random // 2. Reversed // 3. Sorted \n---------");
		JFrame demo = new JFrame("Sorting Visualizer");
		System.out.println("Please, enter the length of the array?");
		setUnits(s.nextInt());
		System.out.println("Please, enter the delay time (ms)?");
		MyLilPane.delay = s.nextInt();
		MyLilPane pane = new MyLilPane();
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.add(pane);
		demo.pack();
		demo.setLocationRelativeTo(null);
		demo.setVisible(true);
		new Thread(new Runnable() {
			@Override
			public void run() {
				int[] clona = new int[pane.arr.length];
				while (true) {
					if (!Arrays.equals(clona, pane.arr)) {
						pane.repaint();
						clona = pane.arr.clone();
					}
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						System.out.println("Exception!");
					}
				}
			}
		}).start();

		while (true) {
			System.out.println("Sorting Technique?");
			char sc = s.next().charAt(0);
			pane.resetStatistics();
			switch (sc) {
			case ('Q'):
			case ('q'):
				setChoice(validate(), pane.arr);
				pane.setCurrent("Quick Sort", "Θ(n log(n)", QuickSort.sort(pane.arr, 0, pane.arr.length - 1));
				pane.repaint();
				break;
				
			case ('M'):
			case ('m'):
				setChoice(validate(), pane.arr);
				pane.setCurrent("Merge Sort", "Θ(n log(n))", MergeSort.mergeSort(pane.arr, 0, pane.arr.length - 1));
				pane.repaint();
				break;
				
			case ('H'):
			case ('h'):
				setChoice(validate(), pane.arr);
				pane.setCurrent("Heap Sort", "Θ(n log(n))", HeapSort.sort(pane.arr));
				pane.repaint();
				break;
				
			case ('B'):
			case ('b'):
				setChoice(validate(), pane.arr);
				pane.setCurrent("Bubble Sort", "Θ(n^2)", SimpleSorts.bubbleSort(pane.arr));
				pane.repaint();
				break;
				
			case ('I'):
			case ('i'):
				setChoice(validate(), pane.arr);
				pane.setCurrent("Insertion Sort", "Θ(n^2)", SimpleSorts.insertionSort(pane.arr));
				pane.repaint();
				break;
				
			case ('S'):
			case ('s'):
				setChoice(validate(), pane.arr);
				pane.setCurrent("Selection Sort", "Θ(n^2)", SimpleSorts.selectionSort(pane.arr));
				pane.repaint();
				break;
				
			case ('R'):
			case ('r'):
				setChoice(validate(), pane.arr);
				pane.setCurrent("Radix Sort", "Θ(nk)", RadixSort.sort(pane.arr));
				pane.repaint();				
				break;
				
			case ('C'):
			case ('c'):
				setChoice(validate(), pane.arr);
				pane.setCurrent("Counting Sort", "Θ(n+k)", CountingSort.sort(pane.arr));
				pane.repaint();
				break;
				
			default:
			}
		}
	}

	private static int validate() {
		System.out.println("Enter Shuffling mode?");
		int sh = s.nextInt();
		while (!(sh == 1 || sh == 2 || sh == 3)) {
			sh = s.nextInt();
		}
		return sh;
	}
}