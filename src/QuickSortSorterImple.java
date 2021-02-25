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
       int[] stack = new int[end - begin + 1];

       // initialize top of stack
       int top = -1;

       // push initial values of l and h to stack
       stack[++top] = begin;
       stack[++top] = end;

       // Keep popping from stack while is not empty
       while (top >= 0) {
           // Pop h and l
           end = stack[top--];
           begin = stack[top--];

           // Set pivot element at its correct position
           // in sorted array
           int p = partition(arr, begin, end, c);

           // If there are elements on left side of pivot,
           // then push left side to stack
           if (p - 1 > begin) {
               stack[++top] = begin;
               stack[++top] = p - 1;
           }

           // If there are elements on right side of pivot,
           // then push right side to stack
           if (p + 1 < end) {
               stack[++top] = p + 1;
               stack[++top] = end;
           }
       }
    }

    @Override
    public void sort(T[] arr, Comparator<T> c) {
        System.out.println("Sorting using Quick Sort algorithm.");
        System.out.println();

        this.quickSort(arr, 0, arr.length - 1, c);
    }

    public static void main(String[] args) {
        System.out.println("Testing Quick Sort algorithm...");
        QuickSortSorterImple sorter = new QuickSortSorterImple();
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
