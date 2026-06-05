public class Salesman extends Regular {
    long sales;
    double commRate;
    int commission;

    public Salesman() { super(); this.jobType = "영업직"; }

    public Salesman(String empId, String name, Date birthday, int grade, int step) {
        super(empId, name, birthday, grade, step, "영업직");
    }

    public void setSalesData(long sales, double commRate) {
        this.sales = sales;
        this.commRate = commRate;
    }

    @Override
    public void calculatePay() {
        super.calculatePay();
        commission = (int) (sales * (commRate / 100));
        totalPay = basePay + commission;
        calculateTax();
    }
}