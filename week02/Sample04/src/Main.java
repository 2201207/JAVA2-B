//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Person kim = new Person("김철수", 183, 65.7f,
                new Date(2000, 7, 20), new Address("경기도", "남양주시", "234 번지"));

        System.out.println(kim);
    }
}
