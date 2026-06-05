import java.io.IOException;
import java.util.Scanner;

public class Temporary extends Employee{
    private int workDay;
    private int dailyPay;

    public Temporary(String name, Date birthDay, String employeeID) {
        super(name, birthDay, employeeID);
        this.workDay = 0;
        this.dailyPay = 0;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    public void setDailyPay(int dailyPay) {
        this.dailyPay = dailyPay;
    }

    @Override
    public int basicSalary() {
        return workDay * dailyPay;
    }

    @Override
    public int bonus() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s %c급-%c호 %2d %,6d원 %,9d원 %,9d원 %,9d원 %,7d원 %,9d원 %s",
                super.toString(), 'X', 'X', workDay, dailyPay, basicSalary(), bonus(),salary(), tax(), gross(), "일당제");

    }
}