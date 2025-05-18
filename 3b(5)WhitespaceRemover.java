public class WhitespaceRemover { 
    public static String removeWhitespace(String str) { 
        return str.replaceAll("\\s+", ""); 
    } 
 
    public static void main(String[] args) { 
        String str = " Hello  World "; 
        System.out.println("Without whitespace: " + removeWhitespace(str)); 
    } 
} 
