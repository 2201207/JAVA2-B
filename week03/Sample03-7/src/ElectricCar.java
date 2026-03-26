public class ElectricCar extends Car{

    public ElectricCar(String model) {
        super(model);
    }

    public void charge(){
        System.out.println(model + "가 충전중입니다.");
    }

    @Override
    public String toString() {
        return String.format("%s", model);
    }
}