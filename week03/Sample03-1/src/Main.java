public class Main {
    public static void main(String[] args) {
        Book book = new Book("자바의 정석");
        Student student = new Student("김영희");
        Teacher teacher = new Teacher("JAVA", "김철수");
        teacher.teach();
        student.study(book);
    }
}