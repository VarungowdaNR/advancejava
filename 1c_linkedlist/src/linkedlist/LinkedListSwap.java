//5. Write a Java program that swaps two elements ( first and third elements ) in a linked list ( using
//Collections.swap(l_list, 0, 2))

package linkedlist;

import java.util.LinkedList;
import java.util.Collections;

public class LinkedListSwap {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");

        System.out.println("Before Swap: " + list);
        if (list.size() >= 3) {
            Collections.swap(list, 0, 2); // swap 1st and 3rd (index 0 and 2)
            System.out.println("After Swapping First and Third: " + list);
        } else {
            System.out.println("Not enough elements to swap.");
        }
    }
}

