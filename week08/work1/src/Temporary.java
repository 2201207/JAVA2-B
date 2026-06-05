public class Temporary extends Employee {
    int dailyWage;
    int days;

    public Temporary() {
        super();
        this.jobType = "일당제";
    }

    public Temporary(String empId, String name, Date birthday) {
        super(empId, name, birthday, "일당제");
    }

    public void setWorkData(int dailyWage, int days) {
        this.dailyWage = dailyWage;
        this.days = days;
    }

    @Override
    public void calculatePay() {
        basePay = dailyWage * days;
        totalPay = basePay;
        tax = (int) (totalPay * 0.066);
        netPay = totalPay - tax;
    }
}