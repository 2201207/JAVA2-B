import java.util.ArrayList;

public class Student extends Person {
    private String hakbun;
    private String className;
    private ArrayList<Subject> subjects;
    private int rank;
    private int gradeRank;

    public Student(String name, String gender) {
        super(name, gender);

        subjects = new ArrayList<>();
        subjects.add(new Subject("국어"));
        subjects.add(new Subject("영어"));
        subjects.add(new Subject("수학"));

        if (getGender().equals("남")) {
            subjects.add(new Subject("기술"));
        } else {
            subjects.add(new Subject("가정"));
        }

        rank = 0;
        gradeRank = 0;
    }

    public void setHakbun(String hakbun) {
        this.hakbun = hakbun;
    }

    public String getHakbun() {
        return hakbun;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public Subject getSubject(int index) {
        return subjects.get(index);
    }

    public int sum() {
        int sum = 0;

        for (int i = 0; i < subjects.size(); i++) {
            sum += subjects.get(i).getScore();
        }

        return sum;
    }

    public double avg() {
        return sum() / (double) subjects.size();
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void setGradeRank(int gradeRank) {
        this.gradeRank = gradeRank;
    }

    public int getGradeRank() {
        return gradeRank;
    }
}