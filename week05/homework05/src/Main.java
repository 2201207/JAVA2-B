import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ids = {"12345", "92345", "12345", "12345", "12345", "12345", "92345", "92345", "12345", "12345"};
        String[] names = {"정상진", "일본인", "홍길동", "한국인", "고길동", "이대한", "이기동", "박종호", "이니나", "윤상열"};

        Customer[] customers = new Customer[10];


        for (int i = 0; i < 10; i++) {
            System.out.print(names[i] + " 고객의 사용량 입력 : ");
            int usage = scanner.nextInt();
            customers[i] = new Customer(ids[i], names[i], usage);
        }


        Arrays.sort(customers);


        System.out.println("\n************************************************************************");
        System.out.println("   번호     이름    사용량    사용요금      세금      납부금액    기타");
        System.out.println("************************************************************************");

        for (Customer c : customers) {
            String discountStr = c.isDiscount ? "지원가구" : "";
            System.out.printf("  %-7s %-4s %,5dKw %,10d원 %,8d원 %,10d원  %s\n",
                    c.id, c.name, c.usage, c.usageFee, c.tax, c.totalFee, discountStr);
        }

        System.out.println("************************************************************************");
        scanner.close();
    }
}