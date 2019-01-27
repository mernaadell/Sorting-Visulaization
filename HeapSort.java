package pkjDS;
import static pkjDS.Swap_Delay.swap;

public class HeapSort {
  public static double sort(int arr[])  {
	long start = System.nanoTime();
    int n = arr.length;
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(arr, n, i);
    }
    for (int i = n - 1; i >= 0; i--) {
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      heapify(arr, i, 0);
    }
    return(((double) (System.nanoTime()-start))/100000000);
  }
  private static void heapify(int arr[], int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;
    if (l < n && arr[l] > arr[largest]) {
      largest = l;
    }
    if (r < n && arr[r] > arr[largest]) {
      largest = r;
    }
    if (largest != i) {
      swap(arr, i, largest);
      heapify(arr, n, largest);
    }
  }
}
