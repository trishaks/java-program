import java.util.ArrayList;
import java.util.List;

public class ColorSearch {

    public static void main(String[] args) {
        // Creating an ArrayList to store colors
        List<String> colors = new ArrayList<>();

        // Adding different colors to the ArrayList
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Red");
        colors.add("Purple");
        colors.add("Orange");

        System.out.println("List of colors: " + colors);

        // Searching for the color "Red"
        String searchColor = "Red";
        boolean isRedAvailable = colors.contains(searchColor);

        // Displaying the search result
        if (isRedAvailable) {
            System.out.println("\nThe color \"" + searchColor + "\" is available in the list.");
        } else {
            System.out.println("\nThe color \"" + searchColor + "\" is not available in the list.");
        }
    }
}
