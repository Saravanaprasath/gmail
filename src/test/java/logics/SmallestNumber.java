package logics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SmallestNumber {
    public void findSmallest1() {
        int smallest = Integer.MAX_VALUE;
        int[] arr = {12, 15, 4, 25, 2, 6};
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        System.out.println("Smallest Value " + smallest);
    }

    public void findSmallest2() {
        int[] arr = {12, -1, 15, 4, 25, 2, 6, 1, -5, -7};
        int smallest = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        System.out.println(smallest + " is smallest");
    }

    public void findSmallest3() {
        int[] arr = {12, -1, 15, 4, 25, 2, 6, 1, -5, -7};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
        }
        Collections.sort(arrayList);
        System.out.println(arrayList.get(0));
    }


    public void findSmallest4() {
        int[] arr = {12, -1, 15, 4, 25, 2, 6, 1, -5, -7};
        Arrays.sort(arr);
        System.out.println(arr[0]);
    }


    public static void main(String[] args) {
        SmallestNumber smallestNumber = new SmallestNumber();
        smallestNumber.findSmallest4();
    }
}
