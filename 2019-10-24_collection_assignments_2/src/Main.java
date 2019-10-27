import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ivan", "Maria", "Stephan", "John", "Amalia");
        System.out.println(names);

        List<String> filteredNames = new ArrayList<>();

        for (String n : names) {
            if (n.length() != 4) {
                filteredNames.add(n);
            }
        }
        System.out.println(filteredNames);
    }
}
