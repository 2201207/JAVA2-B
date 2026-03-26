//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar("테슬라");
        SportsCar sportsCar = new SportsCar("페라리");

        electricCar.charge();
        electricCar.start();
        electricCar.stop();
        sportsCar.start();
        sportsCar.trubo();
        sportsCar.stop();

    }
}