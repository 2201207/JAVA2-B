public class Researcher extends Regular {
    int researchAllowance;

    public Researcher() {
        super();
        this.jobType = "연구직";
        this.researchAllowance = 300000;
    }

    public Researcher(String empId, String name, Date birthday, int grade, int step) {
        super(empId, name, birthday, grade, step, "연구직");
        this.researchAllowance = 300000;
    }

    @Override
    public void calculatePay() {
        super.calculatePay();

        totalPay += researchAllowance;
        netPay += researchAllowance;
    }
}