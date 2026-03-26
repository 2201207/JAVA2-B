public class Teacher {
    String name;
    int age;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("안녕하세요, 제 이름은 " + name + "이고 " + age + "살 입니다.");
    }

    public void teach() {
        System.out.println(name + " 선생님이 수업을 합니다.");
    }

    public void grade() {
        System.out.println(name + " 선생님이 과제를 채점합니다.");
    }
}