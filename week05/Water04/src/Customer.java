import java.io.IOException;
import java.util.Scanner;

public class Customer extends Person {
    private String waterNo;
    protected Type type;
    protected float usage;
    private final int BASIC;

    public Customer(String name, String waterNo) {
        super(name);
        this.waterNo = waterNo;
        this.usage = 0.0f;
        this.BASIC = 1200;
    }

    protected void inputUsage() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.printf("[%s] %s 님 수도 사용량 입력 : ", type.typeName, super.name);
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
        int temp = BASIC + fee();
        int result = (int) (temp * (type.taxRate / 100));
        return result / 10 * 10;  // 절사

    }

    protected int fee() {
        int temp = (int) (usage + 0.5f);
        return temp * type.unitPrice;
    }


    @Override
    public String toString() {
        return String.format(" %4s %s %3s %6.2f\u33A5 %,8d원 %,6d원 %,8d원 %s",
                waterNo, super.toString(), type.typeName, usage, fee(), tax(), charge(),
                type.typeName.equals("군기관") ? "일괄 징수" : "");

    }
}