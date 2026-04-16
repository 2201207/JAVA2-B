abstract public class Plan {
    private String name;
    final int NETWORK = 3200;
    final int BASIC = 1000;

    public Plan(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract int calculateFee(Customer customer);

    protected int tax(Customer customer) {
        int tax = 0;
        if (customer.getBirthday().getAge() > 19) {
            int total = NETWORK + calculateFee(customer);
            tax = (int) (total * (6.5 / 100));
        }
        return tax;
    }
}