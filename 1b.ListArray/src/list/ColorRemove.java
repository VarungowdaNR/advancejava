//Write a java program for getting different colors through ArrayList interface and remove the
//2nd element and color "Blue" from the ArrayList


package list;

import java.util.ArrayList;

public class ColorRemove {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        System.out.println("Original List: " + colors);

        if (colors.size() > 1) {
            colors.remove(2); // Remove 2nd element (index 1)
        }
        colors.remove("Blue"); // Remove by value

        System.out.println("After Removals: " + colors);
    }
}
