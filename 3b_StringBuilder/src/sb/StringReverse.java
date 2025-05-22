//Q3. Write a Java Program for Reversing the characters in a string using user defined function
//reverseString().


package sb;

public class StringReverse {
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        String input = "Hello AIET";
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reverseString(input));
    }
}
