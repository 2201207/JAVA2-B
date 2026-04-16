public interface Plan {
    int NETWORK = 3200;
    int BASIC = 1000;

    int calculateFee(Customer customer);
    String getName();

    default boolean isOld(int age) {
        return (age >= 80);
    }

    default boolean isYoung(int age) {
        return (age >= 19);
    }

    default int tax(Customer customer) {
        int tax = 0;
        if (isYoung(customer.getBirthday().getAge())) {
            int total = NETWORK + calculateFee(customer);
            tax = (int) (total * (6.5 / 100));
        }
        return tax;
    }

}