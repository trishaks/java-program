public class StringCheck { 
    public sta c boolean isNullOrEmpty(String str) { 
        return str == null || str.trim().isEmpty(); 
    } 
 
    public sta c void main(String[] args) { 
        String str1 = "   "; 
        String str2 = null; 
        String str3 = "Hello"; 
 
        System.out.println("str1 is empty: " + isNullOrEmpty(str1)); 
        System.out.println("str2 is empty: " + isNullOrEmpty(str2)); 
        System.out.println("str3 is empty: " + isNullOrEmpty(str3)); 
    } 
} 
