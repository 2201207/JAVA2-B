public class DiscountPlan implements Plan {
    @Override
    public String getName() {
        return "";
    }

    @Override
    public int calculateFee(Customer customer) {
        int callFee = (customer.getUsageTime() / 2 +
                customer.getUsageTime() % 2 != 0 ? 1 : 0) * 5;
        int msgFee = 0;
        if (isOld(customer.getBirthday().getAge())) {
            msgFee = (customer.getMessage() - 40) * 2;
        }

        return BASIC + callFee + msgFee;
    }


}