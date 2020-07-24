package logics;

import java.util.HashSet;

public class FindMissingAlphabet {
    String givenString = "saravanaprasath12345";

    public void findMissingAlphabets() {
        char[] givenAlpha = givenString.toCharArray();
        char[] allAlphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        HashSet<Character> givenSet = new HashSet<>();
        for (char c : givenAlpha) {
            givenSet.add(c);
        }
        System.out.println("Alphabets in Given String");
        System.out.println(givenSet);
        HashSet<Character> allAlphabetsSet = new HashSet<>();
        for (char c : allAlphabets) {
            allAlphabetsSet.add(c);
        }
        System.out.println(allAlphabetsSet);
        allAlphabetsSet.removeAll(givenSet);
        System.out.println("Alphabets not in Given String");
        System.out.println(allAlphabetsSet);
    }

    public static void main(String[] args) {
        FindMissingAlphabet findMissingAlphabet = new FindMissingAlphabet();
        findMissingAlphabet.findMissingAlphabets();
    }
}
