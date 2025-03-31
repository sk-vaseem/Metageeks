import java.util.Comparator;
import java.util.TreeSet;

public class CustomSortingExample {
    public static void main(String[] args) {

        TreeSet<String> sortedStrings = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int lengthComparison = Integer.compare(s2.length(), s1.length());
                if (lengthComparison != 0) {
                    return lengthComparison;
                }
                return s1.compareTo(s2);
            }
        });
        sortedStrings.add("apple");
        sortedStrings.add("banana");
        sortedStrings.add("kiwi");
        sortedStrings.add("blueberry");
        sortedStrings.add("mango");


        System.out.println("Sorted strings: " + sortedStrings);
    }
}
