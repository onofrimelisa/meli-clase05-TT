import java.util.Arrays;
import java.util.Comparator;

public class HeapSortSorterImple<T> implements Sorter<T> {

    private void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i]=a[j];
        a[j] = temp;
    }

    private void buildMaxHeap(T arr[], int n, Comparator<T> c)
    {
        for (int i = 1; i < n; i++)
        {
            // if child is bigger than parent
            if (c.compare(arr[i], arr[(i - 1) / 2]) > 0)
            {
                int j = i;

                // swap child and parent until parent is smaller
                while (c.compare(arr[j], arr[(j - 1) / 2]) > 0)
                {
                    swap(arr, j, (j - 1) / 2);
                    j = (j - 1) / 2;
                }
            }
        }
    }

    @Override
    public void sort(T[] arr, Comparator<T> c) {
        System.out.println("Sorting using Heap Sort algorithm.");
        System.out.println();

        int n = arr.length;
        buildMaxHeap(arr, n, c);

        for (int i = n - 1; i > 0; i--)
        {
            // swap value of first index with last indexed
            swap(arr, 0, i);

            // maintaining heap property after each swapping
            int j = 0, index;

            do
            {
                index = (2 * j + 1);

                // if left child is smaller than right child point index variable to right child
                if (index < (i - 1) && c.compare(arr[index], arr[index + 1]) < 0)
                    index++;

                // if parent is smaller than child then swapping parent with child having higher value
                if (index < i && c.compare(arr[j], arr[index]) < 0)
                    swap(arr, j, index);

                j = index;

            } while (index < i);
        }
    }

    public static void main(String[] args) {
        System.out.println("Testing Heap Sort algorithm...");
        HeapSortSorterImple sorter = new HeapSortSorterImple();
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
