//Write a Java program to iterate a linked list in reverse order (using
//objlist.descendingIterator())

package linkedlist;

import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListReverseIterate {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        list.add("Yellow");

        System.out.println("LinkedList: " + list);
        Iterator<String> reverseIterator = list.descendingIterator();

        System.out.print("Reverse Iteration: ");
        while (reverseIterator.hasNext()) {
            System.out.print(reverseIterator.next() + " ");
        }
    }
}

