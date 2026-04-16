import java.io.IOException;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) throws IOException {
        Customer[] customers = new Customer[] {
                new Customer("홍길동", new Date(2000, 7, 12),
                        "010-2345-5678", new DiscountPlan()),
                new Customer("박길동", new Date(2007, 7, 12),
                        "010-2345-5678", new BasicPlan()),
                new Customer("정길동", new Date(1930, 7, 12),
                        "010-2345-5678", new BasicPlan())
        };

        PhoneOffice office = new PhoneOffice(customers);
        office.inputData();
        office.display();

    }
}