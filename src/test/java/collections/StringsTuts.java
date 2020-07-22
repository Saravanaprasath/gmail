package collections;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class StringsTuts {
    String given = "vivo";

    //Reverse the String - StringBuffer
    @Test
    public void reverseTheStringUsingStringBuffer() {
        StringBuffer sb = new StringBuffer();
        sb.append(given);
        System.out.println("Given : " + given);
        System.out.println("Reverse : " + sb.reverse());
    }

    @Test
    public void reverseTheStringMyLogic() {
        char[] givenArray = given.toCharArray();
        String reversed = "";
        for (int i = givenArray.length - 1; i >= 0; i--) {
            System.out.println(givenArray[i]);
            reversed = reversed + givenArray[i];
        }
        System.out.println(reversed);
    }

    @Test
    public void reverseTheStringCollections() {
        ArrayList<Character> characters = new ArrayList<>();
        char[] givenArr = given.toCharArray();
        for (Character ch : givenArr) {
            characters.add(ch);
        }
        Collections.reverse(characters);
        ListIterator iterator = characters.listIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }


}
