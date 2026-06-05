public class Subject {
    private String subjectName;
    private int score;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
        this.score = 0;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}