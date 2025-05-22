//Q1. Write a Java Program for Checking if a given string is null or contains only whitespace using user
//defined function isNullOrEmpty().


package sb;

public class StringCheck {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static void main(String[] args) {
        String input1 = null;
        String input2 = "   ";
        String input3 = "Hello";

        System.out.println("Input1 is null or empty? " + isNullOrEmpty(input1));
        System.out.println("Input2 is null or empty? " + isNullOrEmpty(input2));
        System.out.println("Input3 is null or empty? " + isNullOrEmpty(input3));
    }
}
