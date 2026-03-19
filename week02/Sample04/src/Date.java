import java.time.LocalDate;

public class Date {
    private int year;
    private int month;
    private  int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getAge() {
        int current = LocalDate.now().getYear();
        return current - year;
    }

    @Override
    public String toString() {
        return String.format("%d살", getAge());
    }
}