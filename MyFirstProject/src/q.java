import java.util.Scanner;

public class q {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        double sum = 0;

        for (int i = 0; i < size; i++) {
            System.out.print("Enter element at index " + i + ": ");
            array[i] = scanner.nextInt();
            sum += array[i];
        }

        double average = sum / size;
        System.out.print("The array is: [ ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println("]");
        System.out.println("The average of the elements in the array is: " + average);
    }
}