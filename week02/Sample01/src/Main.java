//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Person person = new Person();

        person.setName("홍길동");
        person.setAge(30);
        person.setGender(true);
        person.setMaried(true);
        person.setChildren(5);

        System.out.println(person);
        System.out.println();
        Person hong = new Person("홍길동", 30, true, true, 5);
        System.out.println(hong);
    }
}
