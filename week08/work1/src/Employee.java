public abstract class Employee extends Person implements Comparable<Employee> {
    String empId;
    int basePay;
    int totalPay;
    int tax;
    int netPay;
    String jobType;

    public Employee() {
        super();
        this.empId = "000000";
        this.jobType = "미정";
    }

    public Employee(String empId, String name, Date birthday, String jobType) {
        super(name, birthday);
        this.empId = empId;
        this.jobType = jobType;
    }

    public abstract void calculatePay();

    public void calculateTax() {
        if (totalPay <= 2000000) tax = (int) (totalPay * 0.066);
        else if (totalPay <= 4000000) tax = (int) (totalPay * 0.073);
        else tax = (int) (totalPay * 0.085);
        netPay = totalPay - tax;
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(o.netPay, this.netPay);
    }
}