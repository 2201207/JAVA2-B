public class Student {

    String name;
    int rollno;
    String depart;
    String birthday; // YYYYMMDD 형식으로 입력받음


    public Student(String name, int rollno, String depart, String birthday) {
        this.name = name;
        this.rollno = rollno;
        this.depart = depart;
        this.birthday = birthday;
    }

    public void printAge() {
        int birthYear = Integer.parseInt(birthday.substring(0, 4));
        int currentYear = 2026;
        int age = currentYear - birthYear;

        System.out.println("이름: " + name);
        System.out.println("학번: " + rollno);
        System.out.println("학과: " + depart);
        System.out.println("생년월일: " + birthday);
        System.out.println("=> 나이 산출 결과: " + age + "세");
    }
}