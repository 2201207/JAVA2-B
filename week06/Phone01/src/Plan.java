abstract public class Plan {   // 추산 클래스
    private String name;
    final int NETWORK = 3200;
    final int BASIC = 1000;

    public Plan(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract int calculateFee(Customer customer);  // 추상 메소드

    protected int tax(Customer customer) {
        int tax = 0;
        if (customer.getBirthday().getAge() > 19) {
            int total = NETWORK + calculateFee(customer);
            tax = (int) (total * (6.5 / 100));
        }
        return tax;
    }
}