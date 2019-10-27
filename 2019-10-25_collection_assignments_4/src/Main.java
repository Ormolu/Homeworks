import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> letters1 = Arrays.asList("aa", "bb", "cc", "dd");
        List<String> letters2 = Arrays.asList("bb", "cc", "dd", "aa");
        List<String> letters3 = Arrays.asList("bb", "cc", "dd", "ee");
        List<String> letters4 = Arrays.asList("bb", "cc", "dd");

        System.out.println(Main.isCyclic(letters1, letters2));
        System.out.println(Main.isCyclic(letters1, letters3));
        System.out.println(Main.isCyclic(letters1, letters4));
    }

    public static boolean isCyclic (List<String> l1, List<String> l2) {

        if (l1.size() != l2.size()) {
            return false;
        }

        String string1 = "";
        String string2 = "";

        for(String s : l1) {
            string1 += s;
            string1 += ",";
        }

        for(String s : l1) {
            string1 += s;
            string1 += ",";
        }

        for(String s : l2) {
            string2 += s;
            string2 += ",";
        }

        return string1.contains(string2);
    }
}
