public class Customer implements Comparable<Customer> {
    String id;
    String name;
    int usage;
    int usageFee;
    int tax;
    int totalFee;
    boolean isDiscount;

    public Customer(String id, String name, int usage) {
        this.id = id;
        this.name = name;
        this.usage = usage;
        calculate();
    }

    public void setUsage(int usage) {
        this.usage = usage;
        calculate();
    }

    private void calculate() {
        isDiscount = id.startsWith("9");
        int targetUsage = usage;


        if (isDiscount) {
            targetUsage -= 100;
            if (targetUsage < 0) {
                targetUsage = 0;
            }
        }

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

        usageFee = (int) fee;
        tax = (int) (usageFee * 0.07);
        totalFee = usageFee + tax;
    }

    @Override
    public int compareTo(Customer o) {
        return Integer.compare(o.totalFee, this.totalFee); // 내림차순 정렬
    }
}
