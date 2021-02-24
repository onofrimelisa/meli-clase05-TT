import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class QuickSortSorterImple<T> implements Sorter<T> {

    private int partition(T arr[], int begin, int end, Comparator<T> c) {
        T pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (c.compare(arr[j], pivot) <= 0) {
                i++;

                T swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        T swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

   public void quickSort(T arr[], int begin, int end, Comparator<T> c) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end, c);

            quickSort(arr, begin, partitionIndex-1, c);
            quickSort(arr, partitionIndex+1, end, c);
        }
    }

    @Override
    public void sort(T[] arr, Comparator<T> c) {
        this.quickSort(arr, 0, arr.length - 1, c);
    }

    public static void main(String[] args) {
        System.out.println("Testing Quick Sort algorithm...");
        QuickSortSorterImple sorter = new QuickSortSorterImple();
        Integer arr[] = {5, 18, 100, 589, 2, 0, 0, 75};
        Comparator<Integer> comparator = (a, b) -> a - b;
        sorter.sort(arr, comparator);
        System.out.println(Arrays.toString(arr));
    }
}
