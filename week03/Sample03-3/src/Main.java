public class Main {
    public static void main(String[] args) {
        Book book = new Book("국어의 정석");
        Student student = new Student("홍길동");
        Teacher teacher = new Teacher("김홍도", "국어");
        ClassRoom classRoom = new ClassRoom(student, teacher);

        classRoom.startClass(book);

    }
}