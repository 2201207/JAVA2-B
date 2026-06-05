public class Regular extends Employee {
    int grade;
    int step;

    public Regular() {
        super();
        this.jobType = "정규직";
        this.grade = 1;
        this.step = 1;
    }

    public Regular(String empId, String name, Date birthday, int grade, int step) {
        super(empId, name, birthday, "정규직");
        this.grade = grade;
        this.step = step;
    }

    protected Regular(String empId, String name, Date birthday, int grade, int step, String jobType) {
        super(empId, name, birthday, jobType);
        this.grade = grade;
        this.step = step;
    }

    @Override
    public void calculatePay() {
        int[][] baseTable = {
                {2600000, 2650000, 2700000, 2750000, 2800000},
                {2800000, 2860000, 2920000, 2980000, 3040000},
                {3100000, 3170000, 3240000, 3310000, 3380000},
                {3400000, 3480000, 3560000, 3640000, 3720000},
                {3800000, 3890000, 3980000, 4070000, 4160000}
        };
        basePay = baseTable[grade - 1][step - 1];
        totalPay = basePay;
        calculateTax();
    }
}