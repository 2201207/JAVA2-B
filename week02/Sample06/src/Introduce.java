public class Introduce {
    private String name;
    private int age;

    public Introduce(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.printf("안녕하세요! 저는 %s이고, 나이는 %d살입니다.", name, age);
    }
}