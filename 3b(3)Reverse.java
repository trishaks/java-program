public class StringReverser { 
    public static String reverseString(String str) { 
        return new StringBuilder(str).reverse().toString(); 
    } 
 
    public static void main(String[] args) { 
        String str = "Hello World"; 
        System.out.println("Reversed: " + reverseString(str)); 
    } 
}
