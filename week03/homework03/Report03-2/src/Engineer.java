public class Engineer {
    String name;
    int age;

    public Engineer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("안녕하세요, 제 이름은 " + name + "이고 " + age + "살 입니다.");
    }

    public void develop() {
        System.out.println(name + " 엔지니어가 프로그램을 개발합니다.");
    }

    public void fixBug() {
        System.out.println(name + " 엔지니어가 프로젝트의 버그를 수정합니다.");
    }
}
