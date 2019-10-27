import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 2, 4, 5, 9);
        List<Integer> numbers2 = Arrays.asList(1, 3, 4, 5, 8);

        List<String> combinedNumbers = new ArrayList<>();

        for (int i = 0; i < numbers1.size(); i++) {
            if (numbers1.get(i) == numbers2.get(i)) {
                combinedNumbers.add("YES");
            } else {
                combinedNumbers.add("NO");
            }
        }

        System.out.println(combinedNumbers);
    }
}
