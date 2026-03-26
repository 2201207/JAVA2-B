public class Main {
    public static void main(String[] args) {
        Navigation navigation = new Navigation("아이 나비");
        Car car = new Car("소나타");

        car.drive();
        car.findRoute(navigation, "경복대", "서율역");
        car.stop();

    }
}