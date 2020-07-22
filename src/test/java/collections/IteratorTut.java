package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IteratorTut {
    ArrayList list;
    HashMap<String, String> myMap;
    Iterator iterator;

    public void addToList() {
        list = new ArrayList();
        int[] arr = {5, 10, 15, 20, 25, 30};
        for (int value : arr) {
            boolean res = false;
            if (value <= 10) {
                res = list.add(value);
                System.out.println(res);
            } else {
                System.out.println(res);
            }
        }
        System.out.println(list);
    }

    public void addToMap() {
        myMap = new HashMap();
        myMap.put("name", "saravana");
        myMap.put("class", "12");
        myMap.put("year", "2020");
        myMap.put("browser", "firefox");
        myMap.put("country", "India");
        System.out.println(myMap);
    }

    public void listIterateElements() {
        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void mapIteratorElements() {
        //Map.Entry<String,String> data = (Map.Entry<String, String>) myMap.entrySet();
        for (Map.Entry<String, String> entry : myMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        IteratorTut iteratorTut = new IteratorTut();
        iteratorTut.addToMap();
        iteratorTut.mapIteratorElements();
    }
}
