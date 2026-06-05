import java.io.IOException;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) throws IOException {
        Employee[] employees = new Employee[] {
                new Contract("홍길동", new Date(1999, 5, 8), "123456"),
                new Staff("박미경", new Date(2000, 5, 6), "234556", 1, 5),
                new Temporary("경복대", new Date(1987, 4, 20), "678901"),
                new Manager("이대한", new Date(1988, 4, 29), "345678", 5, 2),
                new SalesMan("한민국", new Date(2005, 12, 20), "345678", 4, 5)};

        InputHandler inputHandler = new InputHandler();
        inputHandler.inputData(employees);

        Company company = new Company(employees);
        company.sortByGross();

        OutputHandler outputHandler = new OutputHandler();
        outputHandler.display(employees);



    }
}