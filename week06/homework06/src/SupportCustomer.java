public class SupportCustomer extends Customer {

    public SupportCustomer(String id, String name, int usage) {
        super(id, name, usage);
        calculate();
    }
    @Override
    public void calculate() {
        int targetUsage = Math.max(0, this.usage - 100);
        this.usageFee = calculateProgressiveFee(targetUsage);
        this.tax = (int) (this.usageFee * 0.07);
        this.totalFee = this.usageFee + this.tax;
    }
    @Override
    public String getCustomerType() {
        return "지원가구";
    }
}