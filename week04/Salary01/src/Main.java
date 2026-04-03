import java.io.IOException;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) throws IOException {
        Employee[] employees = new Employee[]{
                new Employee("홍길동", "1234", new Date(1999, 3, 26), '1', '3'),
                new Employee("바기도", "1234", new Date(2009, 3, 26), '2', '4'),
                new Employee("홍길동", "1234", new Date(1999, 3, 26), '1', '1'),
                new Employee("홍길동", "1234", new Date(1999, 3, 26), '4', '3'),
                new Employee("홍길동", "1234", new Date(1999, 3, 26), '5', '2'),
                new Employee("홍길동", "1234", new Date(1999, 3, 26), '2', '4'),
                new Employee("홍길동", "1234", new Date(1999, 3, 26), '1', '5'),
                new Employee("박길동", "1234", new Date(1999, 3, 26), '3', '3'),
                new Employee("이길동", "1234", new Date(1999, 3, 26), '4', '5'),
                new Employee("정길동", "1234", new Date(1999, 3, 26), '5', '2')};

        Company company = new Company(employees);
        company.inputData();
        company.display();

    }
}