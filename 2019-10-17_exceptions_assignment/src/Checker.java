public class Checker {
    public void check(Customer customer) throws Exception {
        if(customer.getAge() < 17) {
            throw new TooYoungException("The customer's age is below 17. " + customer);
        }

        if(customer.getAccount().getIban().length() != 16 ) {
            throw new WrongIbanLengthException("The length of the IBAN is wrong. " + customer);
        }

        if(!customer.getAccount().getIban().substring(0,2).equals("DE")) {
            throw new WrongIbanPrefixException("Wrong prefix. " + customer);
        }
    }
}
