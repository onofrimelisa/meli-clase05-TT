import java.util.Arrays;
import java.util.Comparator;

public class BubbleSortSorterImple<T> implements Sorter<T> {


    @Override
    public void sort(T[] arr, Comparator<T> c) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (c.compare(arr[j], arr[j+1]) > 0) {
                    // swap arr[j+1] and arr[j]
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

    public static void main(String[] args) {
        System.out.println("Testing Bubble Sort algorithm...");
        BubbleSortSorterImple sorter = new BubbleSortSorterImple();
        Integer arr[] = {5, 18, 100, 589, 2, 0, 0, 75};
        Comparator<Integer> comparator = (a, b) -> a - b;
        sorter.sort(arr, comparator);
        System.out.println(Arrays.toString(arr));
    }
}
