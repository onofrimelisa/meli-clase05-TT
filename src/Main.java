import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SorterFactory sorterFactory = new SorterFactory();

        try {
            Sorter sorter = sorterFactory.getInstance();

            System.out.println("Testing sorting algorithm with an array of 100000 integers...");

            Integer[] array= new Integer[100000];
            Random random = new Random();

            // Initialize array
            for (int i =0; i< array.length; i++)
            {
                array[i] = random.nextInt(100000)+1;
            }

            Timer timer = new Timer();

            Comparator<Integer> comparator = (a, b) -> a - b;
            timer.start();
            sorter.sort(array, comparator);
            timer.end();

            System.out.println("The array after sorting is the folowing: ");
            System.out.println(Arrays.toString(array));
            System.out.println();
            System.out.println("Elapsed Time: " + timer.elapsedTime());

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
