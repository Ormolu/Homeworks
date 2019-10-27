import java.util.ArrayList;
import java.util.List;

public class AddressExtractor {
    public List<Address> getAddresses(List<Person> persons) {
        List<Address> result = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            result.add(persons.get(i).getAddress());
        }
        return result;
    }
}
