public class Main {

    public static void main(String[] args) {
        Customer customer1 = new Customer("Neumann", 25, new BankAccount("DE00000000000001"));
        Customer customer2 = new Customer("Mustermann", 76, new BankAccount("DE00000000002"));
        Customer customer3 = new Customer("Mueller", 15, new BankAccount("DE00000000000003"));
        Customer customer4 = new Customer("Schmidt", 34, new BankAccount("IT00000000000004"));

        Checker checker = new Checker();

        Customer[] customers = {customer1, customer2, customer3, customer4};

        for(Customer c: customers) {
            try {
                checker.check(c);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
