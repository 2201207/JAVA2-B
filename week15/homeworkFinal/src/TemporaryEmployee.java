public class TemporaryEmployee extends Employee {
    private int workDay;
    private int dailyPay;

    public TemporaryEmployee(String employeeID, String name, int year, int month, int day,
                             int workDay, int dailyPay) {
        super(employeeID, name, year, month, day);
        this.workDay = workDay;

        if (dailyPay < 25000) {
            this.dailyPay = 25000;
        } else if (dailyPay > 95000) {
            this.dailyPay = 95000;
        } else {
            this.dailyPay = dailyPay;
        }
    }
    @Override
    public int getWorkDay() {
        return workDay;
    }
    @Override
    public int getDailyPay() {
        return dailyPay;
    }
    @Override
    public int getBaseSalary() {
        return workDay * dailyPay;
    }
    @Override
    public String getEtc() {
        return "일당제";
    }
}