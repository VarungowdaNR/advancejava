//Write a java program for getting different colors through ArrayList interface and extract the
//elements 1st and 2nd from the ArrayList object by using SubList()

package list;

import java.util.ArrayList;
import java.util.List;

public class ColorSubList {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        System.out.println("Original List: " + colors);
        List<String> subList = colors.subList(0, 2); // Extract 1st and 2nd (index 0 and 1)
        System.out.println("Sublist (1st and 2nd): " + subList);
    }
}
