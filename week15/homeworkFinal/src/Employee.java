public abstract class Employee extends Person {
    private String employeeID;
    private int year;
    private int month;
    private int day;
    private Salary salary;

    public Employee(String employeeID, String name, int year, int month, int day) {
        super(name);
        this.employeeID = employeeID;
        this.year = year;
        this.month = month;
        this.day = day;
        this.salary = new Salary();
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public Salary getSalary() {
        return salary;
    }

    public int getGrade() {
        return 0;
    }

    public String getGradeName() {
        return "";
    }

    public int getStep() {
        return 0;
    }

    public int getWorkDay() {
        return 0;
    }

    public int getDailyPay() {
        return 0;
    }

    public int getBasicAllowance() {
        return 0;
    }

    public int getManageOrPerformancePay() {
        return 0;
    }

    public int getStockOption() {
        return 0;
    }

    public abstract int getBaseSalary();

    public int getPayment() {
        return getBaseSalary() + getBasicAllowance()
                + getManageOrPerformancePay() + getStockOption();
    }

    public int getTax() {
        return salary.getTax(getPayment());
    }
    public int getRealPayment() {
        return getPayment() - getTax();
    }
    public int getSortGrade() {
        if (getGrade() == 0) return 99;
        return getGrade();
    }
    public abstract String getEtc();
}