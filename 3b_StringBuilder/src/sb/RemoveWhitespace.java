//Q5. Write a Java Program for Eliminating all whitespace characters from a string using user defined
//function removeWhitespace()

package sb;

public class RemoveWhitespace {
    public static String removeWhitespace(String str) {
        return str.replaceAll("\\s+", "");
    }

    public static void main(String[] args) {
        String input = " A I E T   M o o d b i d r i ";
        System.out.println("Original: '" + input + "'");
        System.out.println("Without Whitespace: '" + removeWhitespace(input) + "'");
    }
}

