import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {

        // task 1
        String filename = "numbers.txt";
        System.out.println("Sum " + Main.sumOfNumbers(filename));

        // task 2
        List<String> strings = Arrays.asList("aaa", "bbbb", "a", "bb");
        List<String> sortedStrings =  Main.sortedByLength(strings);
        System.out.println(sortedStrings);

        // task 3
        List<Person> persons = Main.readSortedPersons("persons.csv");
        System.out.println(persons);

        // task 4
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Ivan", "Susanin", 33));
        customers.add(new Customer("Dmitriy", "Donskoy", 28));
        customers.add(new Customer("Mozay", "Zaycev", 60));
        Main.writeCustomers(customers, "customers.csv");
    }

    public static int sumOfNumbers(String filename) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        OptionalInt reduced = in.lines().mapToInt(Integer::valueOf).reduce((a, b) -> a + b);
        return reduced.getAsInt();
    }

    public static List<String> sortedByLength(List<String> strings) {
        Collections.sort(strings, Comparator.comparingInt(String::length));

        return strings;
    }

    public static void writeCustomers(List<Customer> customers, String fileName) throws Exception {
        FileWriter csvWriter = new FileWriter(fileName);
        for (Customer customer : customers) {
            csvWriter.append(customer.getFirstName() + "," + customer.getLastName()  + "," + customer.getAge());
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }

    public static List<Person> readSortedPersons(String filename) throws Exception{
        List<Person> persons = new ArrayList<>();
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = in.readLine()) != null) {
            persons.add(Main.parseToPerson(line));
        }
        List<Person> personsSorted = persons.stream().sorted(Comparator.comparingInt(Person::getAge)).
                collect(Collectors.toList());
        return personsSorted;
    }

    private static Person parseToPerson(String nameAndAge) {
        String[] values = nameAndAge.split(",");
        return new Person(values[0], Integer.parseInt(values[1]));
    }
}
