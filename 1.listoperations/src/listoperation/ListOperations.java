//1.a Develop a Java program for adding elements [Apple, Banana, Orange] into an ArrayList
//and a LinkedList to perform the following operations with different functions directed as
//follows
//1. Adding elements, 2. Adding element at specific index, 3. Adding multiple elements, 4.
//Accessing elements,5. Updating elements, 6. Removing elements, 7. Searching elements, 8. List
//size, 9. Iterating over list, 10. Using Iterator, 11. Sorting, 12. Sublist, 13. Clearing the list


package listoperation;

import java.util.*;

public class ListOperations {
    public static void main(String[] args) {
        // Initialize ArrayList and LinkedList
        List<String> arrayList = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange"));
        List<String> linkedList = new LinkedList<>(Arrays.asList("Apple", "Banana", "Orange"));

        System.out.println("=== ArrayList Operations ===");
        performOperations(new ArrayList<>(arrayList));

        System.out.println("\n=== LinkedList Operations ===");
        performOperations(new LinkedList<>(linkedList));
    }

    public static void performOperations(List<String> list) {
        // 1. Adding elements
        list.add("Grapes");
        System.out.println("1. After adding 'Grapes': " + list);

        // 2. Adding element at specific index
        list.add(1, "Mango");
        System.out.println("2. After adding 'Mango' at index 1: " + list);

        // 3. Adding multiple elements
        List<String> moreFruits = Arrays.asList("Papaya", "Pineapple");
        list.addAll(moreFruits);
        System.out.println("3. After adding multiple elements: " + list);

        // 4. Accessing elements
        System.out.println("4. Element at index 2: " + list.get(2));

        // 5. Updating elements
        list.set(0, "Strawberry");
        System.out.println("5. After updating index 0 to 'Strawberry': " + list);

        // 6. Removing elements
        list.remove("Mango");
        list.remove(2);
        System.out.println("6. After removing 'Mango' and element at index 2: " + list);

        // 7. Searching elements
        System.out.println("7. Contains 'Banana'? " + list.contains("Banana"));

        // 8. List size
        System.out.println("8. List size: " + list.size());

        // 9. Iterating over list
        System.out.print("9. Iterating using for-each: ");
        for (String fruit : list) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // 10. Using Iterator
        System.out.print("10. Iterating using Iterator: ");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 11. Sorting
        Collections.sort(list);
        System.out.println("11. Sorted list: " + list);

        // 12. Sublist
        List<String> subList = list.subList(1, 3); // from index 1 to 2
        System.out.println("12. Sublist (1 to 3): " + subList);

        // 13. Clearing the list
        list.clear();
        System.out.println("13. After clearing the list: " + list);
    }
}
