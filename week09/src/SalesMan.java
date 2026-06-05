import java.io.IOException;
import java.util.Scanner;

public class SalesMan extends Regular {
    private int sales;
    private double rate;

    public SalesMan(String name, Date birthDay, String employeeID, int grade, int step) {
        super(name, birthDay, employeeID, grade, step);
        this.sales = 0;
        this.rate = 0.0;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public int bonus() {
        return (int) (sales * (rate / 100));
    }

    @Override
    public String toString() {
        return  String.format("%s %,9d원 %,9d원 %,7d원 %,9d원 %s",
                super.toString(), bonus(), salary(), tax(), gross(), "영업수당");

    }
}