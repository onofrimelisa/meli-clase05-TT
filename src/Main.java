import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        SorterFactory sorterFactory = new SorterFactory();

        try {
            Sorter sorter = sorterFactory.getInstance();

            System.out.println("Testing sorting algorithm with integers...");
            Integer arr[] = {5, 18, 100, 589, 2, 0, 0, 75};
            System.out.println("The array before sorting is the folowing: ");
            System.out.println(Arrays.toString(arr));
            System.out.println();

            Comparator<Integer> comparator = (a, b) -> a - b;
            sorter.sort(arr, comparator);

            System.out.println("The array after sorting is the folowing: ");
            System.out.println(Arrays.toString(arr));
            System.out.println();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
