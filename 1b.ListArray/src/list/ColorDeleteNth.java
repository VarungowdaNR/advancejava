//Write a java program for getting different colors through ArrayList interface and delete nth
//element from the ArrayList object by using remove by index
//

package list;

import java.util.ArrayList;
import java.util.Scanner;

public class ColorDeleteNth {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Original List: " + colors);
        System.out.print("Enter index (0-based) to remove: ");
        int n = scanner.nextInt();

        if (n >= 0 && n < colors.size()) {
            colors.remove(n);
            System.out.println("Updated List after removing index " + n + ": " + colors);
        } else {
            System.out.println("Invalid index.");
        }

        scanner.close();
    }
}
