import java.util.ArrayList;

public class Student extends Person {
    private String studentID;
    private ArrayList<Subject> subjects;

    public Student(String name, String gender, String studentID) {
        super(name, gender);
        this.studentID = studentID;

        this.subjects = new ArrayList<>();
        subjects.add(new Subject("국어", 0));
        subjects.add(new Subject("영어", 0));
        subjects.add(new Subject("수학", 0));
        if (getGender().equals("남"))
            subjects.add(new Subject("기술", 0));
        else
            subjects.add(new Subject("가정", 0));
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
    public Subject getSubject(int index) {
        return subjects.get(index);
    }

    public String getStudentID() {
        return studentID;
    }

    public void setSubject(int index, int score) {
        this.subjects.set(index,
                new Subject(getSubject(index).getSubjectName(), score));
    }

    protected int sum() {
        int sum = 0;
        for (int i = 0; i < subjects.size(); i++ )
            sum += subjects.get(i).getScore();
        return sum;
    }

    protected double average() {
        return (double) sum() / subjects.size();
    }

}