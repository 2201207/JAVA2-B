public class BasicPlan implements Plan {

    public int calculateFee(Customer customer) {
        int callFee = (customer.getUsageTime() / 2 +
                customer.getUsageTime() % 2 != 0 ? 1 : 0) * 10;
        int msgFee = (customer.getMessage() - 20) * 2;

        return callFee + msgFee;
    }

    @Override
    public String getName() {
        return "기본 요금제";
    }
}