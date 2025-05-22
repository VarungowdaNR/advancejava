//Q2. Write a Java Program for Counting how many times a substring appears in a main string

package sb;

public class SubstringCount {
    public static int countOccurrences(String str, String sub) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }

    public static void main(String[] args) {
        String mainStr = "AIET is the best. AIET is located in Moodbidri.";
        String subStr = "AIET";

        System.out.println("Occurrences of substring'" + subStr + "': " + countOccurrences(mainStr, subStr));
    }
}
