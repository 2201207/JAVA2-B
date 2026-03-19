public class Main {
    public static void main(String[] args) {
        FastFood pizza = new FastFood("경복 피자", 14);

        FastFood donut = new FastFood();
        donut.setName("맛있는 도넛");
        donut.setRadius(6);

        System.out.println(pizza);
        System.out.println(donut);

    }
}