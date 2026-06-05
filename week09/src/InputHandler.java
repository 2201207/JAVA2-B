import java.io.IOException;
import java.util.Scanner;

public class InputHandler implements Symbolic {
    private Scanner keyboard;

    public InputHandler() {
        this.keyboard = new Scanner(System.in);
    }

    protected void inputData(Employee[] employees) throws IOException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] instanceof Temporary) {
                ((Temporary) employees[i]).setDailyPay(inputDailyPay(employees[i].getName()));
                ((Temporary) employees[i]).setWorkDay(inputWorkDay(employees[i].getName()));
                System.out.println();
            } else if (employees[i] instanceof SalesMan) {
                ((SalesMan) employees[i]).setSales(inputSales(employees[i].getName()));
                ((SalesMan) employees[i]).setRate(inputRate(employees[i].getName()));
                System.out.println();
            }
        }
    }



    private double inputRate(String name) throws IOException {
        double rate;
        while (true) {
            System.out.printf("%s님의 영업 커미션 입력 : ", name);
            rate = keyboard.nextDouble();
            if (rate >= 0.0 && rate <= 5.0)
                break;
            else
                error("영업 커미션 오류");
        }
        return rate;
    }

    private int inputSales(String name) throws IOException {
        int sales;
        while (true) {
            System.out.printf("%s님의 영업 실적 입력 : ", name);
            sales = keyboard.nextInt();
            if (sales >= 0)
                break;
            else
                error("영업 실적 오류");
        }
        return sales;
    }



    private int inputDailyPay(String name) throws IOException {
        int dailyPay;
        while (true) {
            System.out.printf("%s님의 일당 입력 : ", name);
            dailyPay = keyboard.nextInt();
            if (dailyPay >= 25000 && dailyPay <= 95000)
                break;
            else
                error("일당 오류");
        }
        return dailyPay;
    }

    private int inputWorkDay(String name) throws IOException {
        int workDay;
        while (true) {
            System.out.printf("%s님의 일한 날수 입력 : ", name);
            workDay = keyboard.nextInt();
            if (workDay >= 0 && workDay <= 31)
                break;
            else
                error("일한 날 수 오류");
        }
        return workDay;
    }
}