public class Manager extends Regular {
    int allowance;

    public Manager() { super(); this.jobType = "점장직"; }

    public Manager(String empId, String name, Date birthday, int grade, int step) {
        super(empId, name, birthday, grade, step, "점장직");
    }

    @Override
    public void calculatePay() {
        super.calculatePay();
        if (basePay <= 1800000) allowance = (int) (basePay * 0.06);
        else if (basePay <= 2400000) allowance = (int) (basePay * 0.05);
        else allowance = (int) (basePay * 0.04);
        totalPay = basePay + allowance;
        calculateTax();
    }
}