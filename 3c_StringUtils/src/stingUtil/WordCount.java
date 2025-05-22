//Q10. Write a Java Program for Counting the number of words in a string using user defined function
//countWords()

package stingUtil;


public class WordCount {
    
    // User-defined function to count the number of words in a string.
    public static int countWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        // Split based on one or more whitespace characters.
        String[] words = input.trim().split("\\s+");
        return words.length;
    }
    
    public static void main(String[] args) {
        String sentence = "This is a sample sentence for counting words.";
        System.out.println("Sentence: " + sentence);
        System.out.println("Word Count: " + countWords(sentence));
    }
}
