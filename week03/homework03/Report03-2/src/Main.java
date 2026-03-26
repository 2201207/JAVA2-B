public class Main {
    public static void main(String[] args) {

        Teacher teacher = new Teacher("영희", 24);
        Doctor doctor = new Doctor("철수", 45);
        Engineer engineer = new Engineer("민수", 35);


        teacher.introduce();
        doctor.introduce();
        engineer.introduce();

        teacher.teach();
        teacher.grade();

        doctor.treat();
        doctor.operate();

        engineer.develop();
        engineer.fixBug();
    }
}