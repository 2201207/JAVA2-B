public class Main {
    public static void main(String[] args) {
        // 1. 기존 TV 객체 생성
        TV oldTv = new TV("Samsung", 2017, 55, "LED");
        oldTv.showInfo();

        // 2. "오늘 TV를 새로 구입하면?" 조건에 대한 객체 생성
        TV newTv = new TV("LG", 2026, 65, "OLED");
        System.out.print("오늘 새로 구입한 ");
        newTv.showInfo();
    }
}