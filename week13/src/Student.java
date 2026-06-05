import java.util.ArrayList;

public class Student extends Person{
    private String studentID;
    private ArrayList<Subject> subjects;

    public Student(String name, String gender, String studentID) {
        super(name, gender);
        this.studentID = studentID;
        subjects = new ArrayList<>();
        subjects.add(new Subject("국어", 0));
        subjects.add(new Subject("영어", 0));
        subjects.add(new Subject("수학", 0));
        if (gender.equals("남"))
            subjects.add(new Subject("기술", 0));
        else
            subjects.add(new Subject("가정", 0));
    }

    public String getStudentID() {
        return studentID;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public Subject getSubject(int index) {
        return subjects.get(index);
    }


    public void setSubject(int index, Subject subject) {
        this.subjects.add(index, subject);
    }

    protected int sum() {
        int sum = 0;
        for (int i = 0; i < subjects.size(); i++)
            sum += subjects.get(i).getScore();
        return sum;

    }

    protected double avg() {
        return (double) sum() / subjects.size();
    }
}