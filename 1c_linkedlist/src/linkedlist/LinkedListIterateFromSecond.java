//Write a Java program to iterate through all elements in a linked list starting at the
//specified position ( 2nd) using iterator ( hint : Iterator iteratorobj = listobj.listIterator(1))

package linkedlist;
import java.util.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListIterateFromSecond {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        list.add("Yellow");

        System.out.println("LinkedList: " + list);
        ListIterator<String> iterator = list.listIterator(1); // starts from 2nd element (index 1)
        System.out.print("Elements from 2nd position: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
