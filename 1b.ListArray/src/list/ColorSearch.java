//Write a java program for getting different colors through ArrayList interface and search whether
//the color "Red" is available or not


package list;

import java.util.ArrayList;

public class ColorSearch {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        System.out.println("Colors: " + colors);
        if (colors.contains("Red")) {
            System.out.println("Red is available in the list.");
        } else {
            System.out.println("Red is not available in the list.");
        }
    }
}
