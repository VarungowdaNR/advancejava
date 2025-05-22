package linkedlist;

import java.util.LinkedList;

public class LinkedListInsertAtEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");

        System.out.println("Before Inserting: " + list);

        // Insert "Pink" at the end
        list.offerLast("Pink");

        System.out.println("After Inserting 'Pink' at end: " + list);
    }
}
