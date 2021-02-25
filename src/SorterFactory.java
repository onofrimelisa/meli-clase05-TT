import java.io.FileReader;
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

        System.out.println("Building sorter with the class name: " + className);
        System.out.println();

        Class<?> cl = Class.forName(className);
        Sorter sorter = (Sorter) cl.getDeclaredConstructor().newInstance();

        return sorter;
    }
}
