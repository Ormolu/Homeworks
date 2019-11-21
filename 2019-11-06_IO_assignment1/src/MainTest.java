import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testSum() throws Exception {
        assertEquals(107, Main.sumOfNumbers("numbers.txt"));
    }

    @Test
    public void testCompareLength() {
        List<String> strings = Arrays.asList("aaa", "bbbb", "a", "bb");
        List<String> sortedStrings = Main.sortedByLength(strings);
        assertEquals("a", sortedStrings.get(0));
        assertEquals("bb", sortedStrings.get(1));
        assertEquals("aaa", sortedStrings.get(2));
        assertEquals("bbbb", sortedStrings.get(3));
    }

    @Test
    public void testWriteCsv() throws Exception {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Ivan", "Susanin", 33));
        String fileName = "testCustomers.csv";
        Main.writeCustomers(customers, fileName);
        File csvOutputFile = new File(fileName);
        assertTrue(csvOutputFile.exists());
        Files.deleteIfExists(csvOutputFile.toPath());
    }

    @Test
    public void testReadCsv() throws Exception {
        List<Person> persons = Main.readSortedPersons("persons.csv");

        assertEquals(10, persons.get(0).getAge());
        assertEquals("Piotr", persons.get(0).getName());

        assertEquals(18, persons.get(1).getAge());
        assertEquals("Ivan", persons.get(1).getName());

        assertEquals(20, persons.get(2).getAge());
        assertEquals("Anna", persons.get(2).getName());
    }

}
