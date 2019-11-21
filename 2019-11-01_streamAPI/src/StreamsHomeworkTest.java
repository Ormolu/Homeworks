import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamsHomeworkTest {
    private StreamsHomework m;

    @Before
    public void setUp(){
        m = new StreamsHomework();
    }

    @Test
    public void testGetAddressesOfAdults()
    {
        Address address1 = new Address("Musterstr.", 23);
        Address address2 = new Address("Muellerdamm", 1);
        Address address3 = new Address("Neustr.", 14);
        Address address4 = new Address("Schlossstr.", 229);
        Address address5 = new Address("Blumenstr.", 4);

        Person person1 = new Person("Ivan", 43, address1);
        Person person2 = new Person("Maria", 38, address2);
        Person person3 = new Person("Niklas", 16, address3);
        Person person4 = new Person("Eugenia", 27, address4);
        Person person5 = new Person("Mira", 16, address5);

        List<Person> personList = Arrays.asList(person1, person2, person3, person4, person5);
        List<Address> expectedAddresses = Arrays.asList(address1, address2, address4);

        assertEquals(this.m.getAddressesOfAdults(personList), expectedAddresses);
    }

    @Test
    public void testGetUniqueNames()
    {
        List<String> names = Arrays.asList("Anna", "Boris", "Caesar", "David", "Anna", "Boris", "Caesar");
        List<String> expectedNames = Arrays.asList("Anna", "Boris", "Caesar", "David");

        assertEquals(this.m.getUniqueNames(names), expectedNames);
    }

    @Test
    public void testGetGroupedByAge()
    {
        Address address1 = new Address("Musterstr.", 23);
        Address address2 = new Address("Muellerdamm", 1);
        Address address3 = new Address("Neustr.", 14);
        Address address4 = new Address("Schlossstr.", 229);
        Address address5 = new Address("Blumenstr.", 4);

        Person person1 = new Person("Ivan", 43, address1);
        Person person2 = new Person("Maria", 38, address2);
        Person person3 = new Person("Niklas", 16, address3);
        Person person4 = new Person("Eugenia", 27, address4);
        Person person5 = new Person("Mira", 16, address5);

        List<Person> personList = Arrays.asList(person1, person2, person3, person4, person5);

        Map<Integer, String> expectedGroups = new HashMap();
        expectedGroups.put(16,"Niklas, Mira");
        expectedGroups.put(38,"Maria");
        expectedGroups.put(27,"Eugenia");
        expectedGroups.put(43,"Ivan");

        assertEquals(expectedGroups, this.m.getGroupedByAge(personList));
    }

    @Test
    public void testGetBankAccountsGroupedByPerson()
    {
        Address address1 = new Address("Musterstr.", 23);
        Address address2 = new Address("Muellerdamm", 1);
        Address address3 = new Address("Neustr.", 14);

        Person person1 = new Person("Ivan", 43, address1);
        Person person2 = new Person("Maria", 38, address2);
        Person person3 = new Person("Niklas", 16, address3);

        BankAccount ba1 = new BankAccount("12345", person1);
        BankAccount ba2 = new BankAccount("5678", person1);
        BankAccount ba3 = new BankAccount("7878788", person2);
        BankAccount ba4 = new BankAccount("9999999", person3);

        List<BankAccount> bankAccounts = Arrays.asList(ba1, ba2, ba3, ba4);

        Map<Person, String> expectedAccounts = new HashMap();
        expectedAccounts.put(person1, ba1.getIBAN() + ", " + ba2.getIBAN());
        expectedAccounts.put(person2, ba3.getIBAN());
        expectedAccounts.put(person3, ba4.getIBAN());

        assertEquals(this.m.getBankAccountsGroupedByPerson(bankAccounts), expectedAccounts);
    }

    @Test
    public void testGetObscuredIbans()
    {
        Address address1 = new Address("Musterstr.", 23);
        Address address2 = new Address("Muellerdamm", 1);
        Address address3 = new Address("Neustr.", 14);

        Person person1 = new Person("Ivan", 43, address1);
        Person person2 = new Person("Maria", 38, address2);
        Person person3 = new Person("Niklas", 16, address3);

        BankAccount ba1 = new BankAccount("12345", person1);
        BankAccount ba2 = new BankAccount("5678", person1);
        BankAccount ba3 = new BankAccount("7878788", person2);
        BankAccount ba4 = new BankAccount("9999999", person3);

        List<BankAccount> bankAccounts = Arrays.asList(ba1, ba2, ba3, ba4);

        List<String> obscuredIbansExpected = Arrays.asList("123**", "567*", "787****", "999****");
        assertEquals(this.m.getObscuredIbans(bankAccounts), obscuredIbansExpected);
    }
}
