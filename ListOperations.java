import java.util.*;

public class ListOperations {

    public static void main(String[] args) {
        // Initial elements
        String[] initialElements = {"Apple", "Banana", "Orange"};

        // Demonstrate operations on ArrayList
        System.out.println("--- ArrayList Operations ---");
        ArrayList<String> arrayList = new ArrayList<>();
        performListOperations(arrayList, initialElements);

        // Demonstrate operations on LinkedList
        System.out.println("\n--- LinkedList Operations ---");
        LinkedList<String> linkedList = new LinkedList<>();
        performListOperations(linkedList, initialElements);
    }

    public static void performListOperations(List<String> list, String[] initialElements) {
        // 1. Adding elements
        System.out.println("\n1. Adding initial elements:");
        for (String element : initialElements) {
            add(list, element);
        }
        printList(list);

        // 2. Adding element at a specific index
        System.out.println("\n2. Adding 'Mango' at index 1:");
        addAtIndex(list, 1, "Mango");
        printList(list);

        // 3. Adding multiple elements
        System.out.println("\n3. Adding multiple elements [Grapes, Kiwi]:");
        List<String> newElements = Arrays.asList("Grapes", "Kiwi");
        addAll(list, newElements);
        printList(list);

        // 4. Accessing elements
        System.out.println("\n4. Accessing element at index 2:");
        accessElement(list, 2);

        // 5. Updating elements
        System.out.println("\n5. Updating element at index 0 to 'Pineapple':");
        updateElement(list, 0, "Pineapple");
        printList(list);

        // 6. Removing elements
        System.out.println("\n6. Removing element at index 3:");
        removeElement(list, 3);
        printList(list);

        // 7. Searching elements
        System.out.println("\n7. Searching for 'Banana':");
        searchElement(list, "Banana");
        System.out.println("Searching for 'Papaya':");
        searchElement(list, "Papaya");

        // 8. List size
        System.out.println("\n8. List size:");
        printSize(list);

        // 9. Iterating over list (for-each loop)
        System.out.println("\n9. Iterating over list (for-each loop):");
        iterateListForEach(list);

        // 10. Using Iterator
        System.out.println("\n10. Using Iterator:");
        iterateListWithIterator(list);

        // 11. Sorting
        System.out.println("\n11. Sorting the list:");
        sortList(list);
        printList(list);

        // 12. Sublist
        System.out.println("\n12. Sublist from index 1 to 3 (exclusive):");
        subList(list, 1, 3);

        // 13. Clearing the list
        System.out.println("\n13. Clearing the list:");
        clearList(list);
        printList(list);
    }

    // 1. Adding elements
    public static void add(List<String> list, String element) {
        list.add(element);
    }

    // 2. Adding element at a specific index
    public static void addAtIndex(List<String> list, int index, String element) {
        list.add(index, element);
    }

    // 3. Adding multiple elements
    public static void addAll(List<String> list, Collection<? extends String> c) {
        list.addAll(c);
    }

    // 4. Accessing elements
    public static void accessElement(List<String> list, int index) {
        if (index >= 0 && index < list.size()) {
            System.out.println("Element at index " + index + ": " + list.get(index));
        } else {
            System.out.println("Invalid index.");
        }
    }

    // 5. Updating elements
    public static void updateElement(List<String> list, int index, String newElement) {
        if (index >= 0 && index < list.size()) {
            list.set(index, newElement);
        } else {
            System.out.println("Invalid index for update.");
        }
    }

    // 6. Removing elements
    public static void removeElement(List<String> list, int index) {
        if (index >= 0 && index < list.size()) {
            System.out.println("Removed element: " + list.remove(index));
        } else {
            System.out.println("Invalid index for removal.");
        }
    }

    // 7. Searching elements
    public static void searchElement(List<String> list, String element) {
        if (list.contains(element)) {
            System.out.println("'" + element + "' found at index: " + list.indexOf(element));
        } else {
            System.out.println("'" + element + "' not found in the list.");
        }
    }

    // 8. List size
    public static void printSize(List<String> list) {
        System.out.println("List size: " + list.size());
    }

    // 9. Iterating over list (for-each loop)
    public static void iterateListForEach(List<String> list) {
        for (String fruit : list) {
            System.out.print(fruit + " ");
        }
        System.out.println();
    }

    // 10. Using Iterator
    public static void iterateListWithIterator(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    // 11. Sorting
    public static void sortList(List<String> list) {
        Collections.sort(list);
    }

    // 12. Sublist
    public static void subList(List<String> list, int fromIndex, int toIndex) {
        List<String> sub = list.subList(fromIndex, toIndex);
        System.out.println("Sublist: " + sub);
    }

    // 13. Clearing the list
    public static void clearList(List<String> list) {
        list.clear();
        System.out.println("List cleared.");
    }

    // Helper function to print the list
    public static void printList(List<String> list) {
        System.out.println("Current list: " + list);
    }
}
