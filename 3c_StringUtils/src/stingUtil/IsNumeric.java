//Q8. Write a Java Program for Verifying if a string contains only numeric characters using user defined
//function isNumeric()

package stingUtil;


	public class IsNumeric {

	    // User-defined function to check if the string contains only numeric digits.
	    public static boolean isNumeric(String input) {
	        if (input == null || input.isEmpty()) {
	            return false;
	        }
	        return input.matches("\\d+");
	    }
	    
	    public static void main(String[] args) {
	        String numericString = "123456";
	        String nonNumericString = "123a456";
	        
	        System.out.println("Is '" + numericString + "' numeric? " + isNumeric(numericString));
	        System.out.println("Is '" + nonNumericString + "' numeric? " + isNumeric(nonNumericString));
	    }
	}


