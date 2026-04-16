public abstract class Customer implements Billable, Comparable<Customer> {
    String id;
    String name;
    int usage;
    int usageFee;
    int tax;
    int totalFee;

    public Customer(String id, String name, int usage) {
        this.id = id;
        this.name = name;
        this.usage = usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
        calculate();
    }
    protected int calculateProgressiveFee(int targetUsage) {
        double fee = 1660.0;
        double[] rates = {184.1, 223.8, 278.3, 353.6, 466.4, 643.9};
        int[] limits = {100, 100, 100, 100, 100, Integer.MAX_VALUE};

        int remaining = targetUsage;
        for (int i = 0; i < rates.length; i++) {
            int tierUsage = Math.min(remaining, limits[i]);
            fee += tierUsage * rates[i];
            remaining -= tierUsage;
            if (remaining <= 0) {
                break;
            }
        }
        return (int) fee;
    }

    public abstract String getCustomerType();

    @Override
    public int compareTo(Customer o) {
        return Integer.compare(o.totalFee, this.totalFee);
    }
}