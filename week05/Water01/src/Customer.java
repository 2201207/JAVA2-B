import java.io.IOException;
import java.util.Scanner;

public class Customer {
    private String name;
    private String waterNo;
    private char type;
    protected float usage;
    private final int BASIC;

    public Customer(String name, String waterNo, char type) {
        this.name = name;
        this.waterNo = waterNo;
        this.type = type;
        this.usage = 0.0f;
        this.BASIC = 1200;
    }

    protected void inputUsage() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.printf("[%s] %s 님 수도 사용량 입력 : ", typeName(), name);
            usage = keyboard.nextFloat();
            if (usage >= 0.0f && usage <= 999.9f)
                break;
            else {
                System.err.print("ERROR : 사용량 오류");
                System.in.read();
            }
        }
    }

    protected int charge() {
        return BASIC + fee() + tax();
    }

    protected int tax() {
        int result = 0;
        int temp = BASIC + fee();
        switch (type) {
            case '1':
                result = (int) (temp * (5.0f / 100));
                break;
            case '2':
                result = (int) (temp * (3.5f / 100));
                break;
            case '3':
                result = (int) (temp * (2.5f / 100));
                break;
            case '4':
                result = (int) (temp * (1.5f / 100));
                break;
            case '5':
                result = 0;
                break;
        }
        result = result / 10 * 10;  // 절사
        return result;
    }

    protected int fee() {
        int result = 0;
        int temp = (int) (usage + 0.5f);
        switch (type) {
            case '1':
                result = temp * 40;
                break;
            case '2':
                result = temp * 55;
                break;
            case '3':
                result = temp * 78;
                break;
            case '4':
                result = temp * 35;
                break;
            case '5':
                result = temp * 20;
                break;
        }
        return result;
    }

    private String typeName() {
        String result = "";
        switch (type) {
            case '1':
                result = "가정용";
                break;
            case '2':
                result = "영업용";
                break;
            case '3':
                result = "공장용";
                break;
            case '4':
                result = "관공서";
                break;
            case '5':
                result = "군기관";
                break;
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format(" %4s %3s %3s %6.2f\u33A5 %,8d원 %,6d원 %,8d원 %s",
                waterNo, name, typeName(), usage, fee(), tax(), charge(),
                type == '5' ? "일괄 징수" : "");

    }
}