package logics;

import java.util.Collections;
import java.util.LinkedList;

public class ReverseSentence {
    String sentence = "India loves Pakistan";

    public void reverseSen1() {
        String[] str = sentence.split(" ");
        System.out.println(str.length);
        for (int i = str.length - 1; i >= 0; i--) {
            System.out.print(str[i] + " ");
        }
    }

    public void reverseSen2() {
        LinkedList<String> arr = new LinkedList<>();
        String[] str = sentence.split(" ");
        for (int i = 0; i < str.length; i++) {
            arr.add(str[i]);
        }
        for (int i = arr.size() - 1; i >= 0; i--) {
            System.out.print(arr.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        ReverseSentence reverseSentence = new ReverseSentence();
        reverseSentence.reverseSen2();
    }
}
