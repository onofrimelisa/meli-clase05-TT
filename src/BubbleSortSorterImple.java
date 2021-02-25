import java.util.Arrays;
import java.util.Comparator;

public class BubbleSortSorterImple<T> implements Sorter<T> {


    @Override
    public void sort(T[] arr, Comparator<T> c) {
        System.out.println("Sorting using Bubble Sort algorithm.");
        System.out.println();

        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (c.compare(arr[j], arr[j+1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

    public static void main(String[] args) {
        System.out.println("Testing Bubble Sort algorithm...");
        BubbleSortSorterImple sorter = new BubbleSortSorterImple();
        Integer arr[] = {5, 18, 100, 589, 2, 0, 0, 75};

        System.out.println("The array before sorting is the folowing: ");
        System.out.println(Arrays.toString(arr));
        System.out.println();

        Comparator<Integer> comparator = (a, b) -> a - b;
        sorter.sort(arr, comparator);

        System.out.println("The array after sorting is the folowing: ");
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }
}
