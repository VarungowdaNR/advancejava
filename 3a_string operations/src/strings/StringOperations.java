//2 a. Develop a java program for performing various string operations with different string
//handling functions directed as follows
//String Creation and Basic Operations, Length and Character Access, String Comparison, String
//Searching, Substring Operations , String Modification, Whitespace Handling, String
//Concatenation, String Splitting, StringBuilder Demo, String Formatting , Validate Email with
//contains( ) and startsWith() and endsWith()

package strings;

public class StringOperations {
    public static void main(String[] args) {
        // String Creation and Basic Operations
        String str1 = "AIET";
        String str2 = " welcomes you!";
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);

        // Length and Character Access
        System.out.println("Length of str1: " + str1.length());
        System.out.println("Character at index 2 in str1: " + str1.charAt(2));

        // String Comparison
        String str3 = "AIET";
        System.out.println("str1 equals str3? " + str1.equals(str3));
        System.out.println("str1 compareTo str2: " + str1.compareTo(str2));

        // String Searching
        System.out.println("str2 contains 'welcome'? " + str2.contains("welcome"));
        System.out.println("Index of 'e' in str2: " + str2.indexOf('e'));

        // Substring Operations
        System.out.println("Substring of str2 (10 to 13): " + str2.substring(10, 13));

        // String Modification
        String modifiedStr = str2.replace("you", "everyone");
        System.out.println("Modified str2: " + modifiedStr);

        // Whitespace Handling
        String messy = "  Hello AIET!  ";
        System.out.println("Original with spaces: '" + messy + "'");
        System.out.println("After trim(): '" + messy.trim() + "'");

        // String Concatenation
        String full = str1.concat(str2);
        System.out.println("Concatenated string: " + full);

        // String Splitting
        String colors = "Red,Green,Blue";
        String[] colorArray = colors.split(",");
        System.out.print("Split colors: ");
        for (String c : colorArray) {
            System.out.print(c + " ");
        }
        System.out.println();

        // StringBuilder Demo
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println("StringBuilder result: " + sb.toString());

        // String Formatting
        String name = "Varun";
        int age = 21;
        String formatted = String.format("Name: %s, Age: %d", name, age);
        System.out.println("Formatted String: " + formatted);

        // Email Validation
        String email = "student@aiet.edu";
        boolean validEmail = email.contains("@") && email.endsWith(".edu") && email.startsWith("student");
        System.out.println("Is valid email? " + validEmail);
    }
}

