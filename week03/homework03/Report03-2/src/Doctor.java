public class Doctor {
    String name;
    int age;

    public Doctor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("안녕하세요, 제 이름은 " + name + "이고 " + age + "살 입니다.");
    }

    public void treat() {
        System.out.println(name + " 의사가 환자를 진료합니다.");
    }

    public void operate() {
        System.out.println(name + " 의사가 수술도 진행합니다.");
    }
}