public class NormalCustomer extends Customer {

    public NormalCustomer(String id, String name, int usage) {
        super(id, name, usage);
        calculate();
    }

    @Override
    public void calculate() {
        this.usageFee = calculateProgressiveFee(this.usage);
        this.tax = (int) (this.usageFee * 0.07);
        this.totalFee = this.usageFee + this.tax;
    }

    @Override
    public String getCustomerType() {
        return "";
    }
}