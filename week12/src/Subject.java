public class Subject {
    private String subjectName;
    private int score;

    public Subject(String subjectName, int score) {
        this.subjectName = subjectName;
        this.score = score;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getScore() {
        return score;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setScore(int score) {
        this.score = score;
    }
}