import java.io.IOException;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) throws IOException {
        Customer[] customers = new Customer[] {
                new Home("홍길동", "1234"),
                new Business("홍길동", "1234"),
                new Factory("홍길동", "1234"),
                new Gorvernment( "홍길동", "1234"),
                new Army("홍길동", "1234"),
                new School("경복대", "2345")
        };

        WaterOffice office = new WaterOffice(customers);
        office.inputData();
        office.display();
    }
}