import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Properties;

public class SorterFactory {

    public static Sorter getInstance() throws Exception{
            // create a reader object on the properties file
            FileReader reader = new FileReader("factory.properties");

            // create properties object
            Properties p = new Properties();

            // Add a wrapper around reader object
            p.load(reader);

            String className = p.getProperty("sorter");

            Class<?> cl = Class.forName(className);
            Sorter sorter = (Sorter) cl.getDeclaredConstructor().newInstance();

            return sorter;
    }

    public static void main(String[] args) {
        SorterFactory sorterFactory = new SorterFactory();

        try {
            Sorter sorter = sorterFactory.getInstance();

            System.out.println("Testing sorting algorithm with integers...");
            Integer arr[] = {5, 18, 100, 589, 2, 0, 0, 75};
            Comparator<Integer> comparator = (a, b) -> a - b;
            sorter.sort(arr, comparator);
            System.out.println(Arrays.toString(arr));
            System.out.println();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
