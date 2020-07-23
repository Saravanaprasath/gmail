package logics;

import java.util.Scanner;

public class ReverseNumbers {
    int givenNumber;
    int reversedNumber = 0;
    Scanner sc = new Scanner(System.in);

    //Reverse a number
    public void reverseNumbers() {
        System.out.println("Enter the number:");
        givenNumber = 123;//sc.nextInt();
        System.out.println(givenNumber);
        while (givenNumber > 0) {
            reversedNumber = reversedNumber * 10;
            reversedNumber = reversedNumber + givenNumber % 10;
            givenNumber = givenNumber / 10;
        }
        System.out.println(reversedNumber);
    }


    public static void main(String[] args) {
        ReverseNumbers numbers = new ReverseNumbers();
        numbers.reverseNumbers();
    }
}
