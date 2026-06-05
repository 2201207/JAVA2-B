import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class Date implements Symbolic {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.of(year, month, day);
        return today.getYear() - birthDate.getYear() -
                (today.getDayOfYear() < birthDate.getDayOfYear() ? 1 : 0);
    }


    @Override
    public String toString() {
        return String.format("(%2d세)", getAge());

    }
}