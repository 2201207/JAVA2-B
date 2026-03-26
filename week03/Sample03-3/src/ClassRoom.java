public class ClassRoom {
    private Student student;
    private Teacher teacher;

    public ClassRoom(Student student, Teacher teacher) {
        this.student = student;
        this.teacher = teacher;
    }

    public void startClass(Book book) {
        teacher.teach();
        student.study(book);
    }
}