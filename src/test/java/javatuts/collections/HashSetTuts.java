package javatuts.collections;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTuts {
    HashSet<String> hash1 = new HashSet<>();
    HashSet<String> hash2 = new HashSet<>();
    HashSet<String> cloneSet = new HashSet<>();

    public void addToHash1() {
        hash1.add("a");
        hash1.add("b");
        hash1.add("c");
        hash1.add("d");
        hash1.add("c");
        hash1.add("h");
        hash2.add("l");
        System.out.println("Hash1 - Added Elements");
        System.out.println(hash1);
    }

    public void addToHash2() {
        hash2.add("e");
        hash2.add("h");
        hash2.add("j");
        hash2.add("k");
        hash2.add("l");
        hash2.add("a");
        System.out.println("Hash2 - Added Elements");
        System.out.println(hash2);
    }

    public void cloneSets() { //Take a copy of hash1 and put it into cloneSet
        cloneSet = (HashSet) hash1.clone();
        System.out.println("After cloning - Clone Set");
        System.out.println(cloneSet);
    }

    public void find() {
        System.out.println("Find a : " + hash1.contains("a"));
        System.out.println("Find x : " + hash1.contains("x"));
    }

    public void iterate() {
        Iterator<String> iterator = hash1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void removeElement() { // Remove element if it's present in the hashset
        System.out.println("Remove z : " + hash1.remove("z"));
        System.out.println("Remove a : " + hash1.remove("a"));
        System.out.println(hash1);
    }

    public void findSizeOfHashSet() {
        System.out.println("HashSet Size:");
        System.out.println(hash1.size());
    }

    public void clearSet() {
        hash1.clear();
        System.out.println("After Clear");
        System.out.println(hash1);
    }

    public void findUnionAndIntersection() {
        System.out.println("Intersection");
        hash1.retainAll(hash2);
        System.out.println(hash1);
       /* System.out.println("Union");
        hash2.addAll(hash1);
        System.out.println(hash1);
        System.out.println(hash2);*/
    }


    public static void main(String[] args) {
        HashSetTuts hashSetTuts = new HashSetTuts();
        hashSetTuts.addToHash1();
        hashSetTuts.addToHash2();
        hashSetTuts.findUnionAndIntersection();
        //hashSetTuts.findSizeOfHashSet();
        //hashSetTuts.clearSet();
        //hashSetTuts.addToHash2();
        //hashSetTuts.cloneSets();
        //hashSetTuts.find();
        //hashSetTuts.iterate();
        //hashSetTuts.removeElement();
        //hashSetTuts.findSizeOfHashSet();
    }
}
