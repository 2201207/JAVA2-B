public class Contract extends Employee {
    public Contract() {
        super();
        this.jobType = "계약직";
    }

    public Contract(String empId, String name, Date birthday) {
        super(empId, name, birthday, "계약직");
    }

    @Override
    public void calculatePay() {
        basePay = 2000000;
        totalPay = basePay;
        calculateTax();
    }
}