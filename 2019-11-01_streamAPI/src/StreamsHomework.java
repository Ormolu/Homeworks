import java.util.*;
import java.util.stream.Collectors;

public class StreamsHomework {

    public List<Address> getAddressesOfAdults(List<Person> personList){
        return personList.stream()
                .filter(p -> p.getAge() > 17)
                .map(p -> p.getAddress())
                .collect(Collectors.toList());
    }

    public List<String> getUniqueNames(List<String> namesList) {
        return namesList.stream().distinct().collect(Collectors.toList());
    }

    public Map<Integer, String> getGroupedByAge(List<Person> personList){
        return personList.stream().collect(
                Collectors.toMap(Person::getAge, Person::getName, (name1, name2) -> (name1 + ", " + name2)));
    }

    public Map<Person, String> getBankAccountsGroupedByPerson(List<BankAccount> bankAccounts){
        return bankAccounts.stream().collect(
                Collectors.toMap(BankAccount::getOwner, BankAccount::getIBAN, (iban1, iban2) -> (iban1 + ", " + iban2)));
    }

    public List<String> getObscuredIbans(List<BankAccount> bankAccounts) {
        return bankAccounts.stream().map(iban -> iban.getIBAN().substring(0, 3) + iban.getIBAN().replaceAll(".", "*").substring(3)).collect(Collectors.toList());
    }

}