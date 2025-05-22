//Q7. Write a Java Program for Shortening a string to a specified length and adds an ellipsis using user
//defined function truncate()


package stingUtil;

public class TruncateString {
	 public static String truncate(String input, int maxLength) {
	        if (input == null || maxLength < 0) {
	            return input;
	        }
	        if (input.length() <= maxLength) {
	            return input;
	        } else {
	            return input.substring(0, maxLength) + "...";
	        }
	    }
	    
	    public static void main(String[] args) {
	        String text = "This is a very long string that needs to be truncated.";
	        int truncateLength = 25;
	        System.out.println("Original: " + text);
	        System.out.println("Truncated: " + truncate(text, truncateLength));
	    }
	}
