package logics;

import java.util.Scanner;

public class FindLargestSmallest {

    Scanner scanner = new Scanner(System.in);
    int[] arr = {9, 8, 9};
    int length = 3;

    public void getArray() {

        arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }
    }

    public void smallestAndLargestInArray() {
        int smallest = arr[0];
        int largest = arr[0];
        for (int j = 0; j < arr.length; j++) {
            if (smallest > arr[j]) {
                smallest = arr[j];
            }
            if (largest < arr[j]) {
                largest = arr[j];
            }
        }
        if (smallest == largest) {
            System.out.println("All elements are same");
        } else {
            System.out.println("Smallest in Array :" + smallest);
            System.out.println("Largest in Array  :" + largest);
        }

    }


    public static void main(String[] args) {
        FindLargestSmallest largestSmallest = new FindLargestSmallest();
        //largestSmallest.getArray();
        largestSmallest.smallestAndLargestInArray();
    }
}
