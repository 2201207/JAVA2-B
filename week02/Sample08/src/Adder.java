import java.io.IOException;
import java.util.Scanner;

public class Adder {
    private int start;
    private int last;

    public void setStart(int start) {
        this.start = start;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public int readData(String message) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        int temp;
        while (true) {
            System.out.print(message);
            temp = keyboard.nextInt();
            if (temp >= 0)
                break;
            else {
                System.err.println("오류");
                System.in.read();
            }
        }
        return temp;
    }

    private int add() {
        int sum = 0;
        for (int i = start; i <= last; i++)
            sum += i;
        return sum;
    }

    @Override
    public String toString() {
        return String.format("%d + %d +.... + %d + %d = %d",
                start, start +1, last -1, last, add());

    }
}
