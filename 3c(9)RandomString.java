 import java.util.Random; 
 
public class RandomStringGenerator { 
    public static String generateRandomString(int length) { 
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; 
        StringBuilder result = new StringBuilder(); 
        Random random = new Random(); 
 
        for (int i = 0; i < length; i++) { 
            result.append(chars.charAt(random.nextInt(chars.length()))); 
        } 
        return result.toString(); 
    } 
 
    public static void main(String[] args) { 
        System.out.println("Random String: " + generateRandomString(10)); 
    } 
} 
