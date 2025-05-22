//Q6. Write a Java Program for Capitalizing the first letter of each word. using user defined function
//capitalizeWords()


package stingUtil;

public class CapitalizeWords {
	 // User-defined function to capitalize the first letter of each word.
    public static String capitalizeWords(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        
        String[] words = input.split("\\s+");
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            if(word.length() > 0) {
                capitalized.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    capitalized.append(word.substring(1).toLowerCase());
                }
                capitalized.append(" ");
            }
        }
        return capitalized.toString().trim();
    }
    
    public static void main(String[] args) {
        String sentence = "java programming language";
        System.out.println("Original: " + sentence);
        System.out.println("Capitalized: " + capitalizeWords(sentence));
    }
}