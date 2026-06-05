public class RegularEmployee extends Employee {
    private int grade;
    private int step;
    private int performancePay;
    private int stockOption;

    public RegularEmployee(String employeeID, String name, int year, int month, int day,
                           int grade, int step, int performancePay, int stockOption) {
        super(employeeID, name, year, month, day);
        this.grade = grade;
        this.step = step;
        if (performancePay > 7000000) {
            this.performancePay = 7000000;
        } else {
            this.performancePay = performancePay;
        }
        if (stockOption > 10000000) {
            this.stockOption = 10000000;
        } else {
            this.stockOption = stockOption;
        }
    }

    @Override
    public int getGrade() {
        return grade;
    }

    @Override
    public String getGradeName() {
        return getSalary().getGradeName(grade);
    }

    @Override
    public int getStep() {
        return step;
    }

    @Override
    public int getBaseSalary() {
        return getSalary().getBaseSalary(grade);
    }

    @Override
    public int getBasicAllowance() {
        return getSalary().getBasicAllowance(grade, step);
    }

    @Override
    public int getManageOrPerformancePay() {
        if (grade >= 1 && grade <= 2) {
            return performancePay;
        } else if (grade >= 3 && grade <= 4) {
            return getSalary().getManagerBonus(grade, getBaseSalary());
        }
        return 0;
    }

    @Override
    public int getStockOption() {
        if (grade >= 1 && grade <= 2) {
            return stockOption;
        }
        return 0;
    }

    @Override
    public String getEtc() {
        if (grade >= 1 && grade <= 2) {
            return "임원직";
        } else if (grade >= 3 && grade <= 4) {
            return "관리직";
        } else {
            return "정규직";
        }
    }
}