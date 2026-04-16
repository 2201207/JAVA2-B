import java.io.IOException;
import java.util.Scanner;

public class Customer extends Person{
    private String phoneNo;
    private int usageTime;
    private int message;
    private Plan plan;

    public Customer(String name, Date birthday, String phoneNo, Plan plan) {
        super(name, birthday);
        this.phoneNo = phoneNo;
        this.usageTime = 0;
        this.message = 0;
        this.plan = plan;
        if (this.getBirthday().getAge() >= 80)
            this.plan = new DiscountPlan();
    }

    public int getMessage() {
        return message;
    }

    public int getUsageTime() {
        return usageTime;
    }

    protected void inputUsageTime() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.printf("%s님의 통화 시간 입력 : ", super.getName());
            usageTime = keyboard.nextInt();
            if (usageTime >= 0)
                break;
            else {
                System.err.print("ERROR : 통화 시간 오류");
                System.in.read();
            }
        }
    }

    protected void inputMessage() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.printf("%s님의 문자 건수 입력 : ", super.getName());
            message = keyboard.nextInt();
            if (message >= 0)
                break;
            else {
                System.err.print("ERROR : 문자 건수 오류");
                System.in.read();
            }
        }
    }

    private int fee() {
        int fee;
        if (plan instanceof BasicPlan)
            fee = ((BasicPlan) plan).calculateFee(this);
        else
            fee = ((DiscountPlan) plan).calculateFee(this);
        return fee;
    }

    private int tax(){
        int tax;
        if (plan instanceof BasicPlan)
            tax = ((BasicPlan) plan).tax(this);
        else
            tax = ((DiscountPlan) plan).tax(this);
        return tax;
    }

    private int charge() {
        return fee() + tax();
    }

    @Override
    public String toString() {
        return String.format("%s %13s %,6d초 %,6d건 %6s %,10d원 %,8d원 %,10d원",
                super.toString(), phoneNo, usageTime, message, plan.getName(),
                fee(), tax(), charge());

    }
}