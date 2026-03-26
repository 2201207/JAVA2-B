public class Navigation {
    protected String model;

    public Navigation(String model) {
        this.model = model;
    }

    public void findRoute(String start, String destination) {
        System.out.printf("%s에서 %s까지 가는 최적의 길을 찾았습니다.\n",
                start, destination);
    }

    @Override
    public String toString() {
        return String.format("%s", model);
    }
}