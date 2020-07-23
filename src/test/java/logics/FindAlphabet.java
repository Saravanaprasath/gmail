package logics;

import java.util.Scanner;

public class FindAlphabet {
    String string = "saravanaprasath";
    char[] alphabets;
    int count = 0;
    Scanner sc = new Scanner(System.in);
    char searchAlphabet;

    public void findElement() {
        alphabets = string.toCharArray();
        System.out.println("Enter the search element");
        searchAlphabet = sc.next().charAt(0);
        for (char c : alphabets) {
            if (searchAlphabet == c) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println(searchAlphabet + " is not present");
        } else {
            System.out.println(searchAlphabet + " is present " + count + " times");
        }
    }

    public static void main(String[] args) {
        FindAlphabet findAlphabet = new FindAlphabet();
        findAlphabet.findElement();

    }
}
