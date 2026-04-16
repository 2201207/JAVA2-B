public class DiscountPlan extends Plan{

    public DiscountPlan() {
        super("할인 요금제");
    }

    @Override
    int calculateFee(Customer customer) {
        int callFee = (customer.getUsageTime() / 2 +
                customer.getUsageTime() % 2 != 0 ? 1 : 0) * 5;
        int msgFee = 0;
        if (customer.getBirthday().getAge() < 80) {
            msgFee = (customer.getMessage() - 40) * 2;
        }

        return BASIC + callFee + msgFee;
    }


}