public class Car {
    protected String model;

    public Car(String model) {
        this.model = model;
    }

    public void drive() {
        System.out.printf("%s 자동차가 시작 합니다/\n", model);
    }

    public void findRoute(Navigation navigation, String start, String destnation) {
        navigation.findRoute(start, destnation);
    }

    public void stop() {
        System.out.printf("%s 자동차가 정지 합니다.\n", model);
    }
}