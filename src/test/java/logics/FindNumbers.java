package logics;

import java.util.Scanner;

public class FindNumbers {
    int[] arr;
    int size;
    int search;
    int count = 0;
    Scanner sc = new Scanner(System.in);

    public void addElements() {
        System.out.println("Enter the no.of elements");
        size = sc.nextInt();
        System.out.println("Enter " + size + " elements");
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Added elements in array");
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }

    public void findElement() {
        System.out.println("Enter the searching element");
        search = sc.nextInt();
        for (int i = 0; i < size; i++) {
            if (arr[i] == search) {
                count++;
            }
        }
        if (count > 0) {
            System.out.println(search + " is present " + count + " times");
        } else {
            System.out.println(search + " is not present");
        }

    }


    public static void main(String[] args) {
        FindNumbers findNumbers = new FindNumbers();
        findNumbers.addElements();
        findNumbers.findElement();
    }
}
