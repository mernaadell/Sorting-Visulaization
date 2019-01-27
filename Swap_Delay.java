package pkjDS;

public class Swap_Delay {
    public static void delay() {
        try {
            Thread.sleep(MyLilPane.delay);

        } catch (InterruptedException e) {
            System.out.println("Exception");
        }
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        Swap_Delay.delay();
    }
}
