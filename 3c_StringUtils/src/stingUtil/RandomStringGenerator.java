//Q9. Write a Java Program for Creating a random string of a specified length using user defined
//function generateRandomString()




package stingUtil;


import java.util.Random;

public class RandomStringGenerator {
    
    // Characters to choose from.
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    // User-defined function to generate a random string of given length.
    public static String generateRandomString(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Length cannot be negative.");
        }
        Random random = new Random();
        StringBuilder randomStr = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            randomStr.append(CHARACTERS.charAt(index));
        }
        return randomStr.toString();
    }
    
    public static void main(String[] args) {
        int desiredLength = 10;
        System.out.println("Random String of length " + desiredLength + ": " + generateRandomString(desiredLength));
    }
}
