import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Helmut", new Address("Musterstr.", 12)));
        personList.add(new Person("Anna", new Address("Neustr.", 3)));
        personList.add(new Person("Moritz", new Address("Langstr.", 44)));

        AddressExtractor addressExtractor = new AddressExtractor();
        List<Address> addresses = addressExtractor.getAddresses(personList);

        for (int i = 0; i < addresses.size(); i++) {
            System.out.println(addresses.get(i));
        }
    }
}
