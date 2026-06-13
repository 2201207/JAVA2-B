import java.util.ArrayList;

public class ClassRoom {
    private ArrayList<Student> students;
    private Grade grade;

    public ClassRoom(ArrayList<Student> students) {
        this.students = students;
        this.grade = new Grade();
    }


    public void rank() {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            int rank = 1;
            int gradeRank = 1;

            for (int j = 0; j < students.size(); j++) {
                Student other = students.get(j);

                if (student.getClassName().equals(other.getClassName())) {
                    if (student.sum() < other.sum()) {
                        rank++;
                    }
                }

                if (student.sum() < other.sum()) {
                    gradeRank++;
                }
            }

            student.setRank(rank);
            student.setGradeRank(gradeRank);
        }
    }

    public void sortByClassAndRank() {
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                Student first = students.get(i);
                Student second = students.get(j);

                if (change(first, second)) {
                    students.set(i, second);
                    students.set(j, first);
                }
            }
        }
    }

    private boolean change(Student first, Student second) {
        int classCompare = first.getClassName().compareTo(second.getClassName());

        if (classCompare > 0) {
            return true;
        } else if (classCompare == 0) {
            if (first.getRank() > second.getRank()) {
                return true;
            } else if (first.getRank() == second.getRank()) {
                return first.getName().compareTo(second.getName()) > 0;
            }
        }

        return false;
    }

    public String getKorGrade(Student student) {
        return grade.korGrade(student.getSubject(0).getScore());
    }

    public String getEngGrade(Student student) {
        return grade.engMathGrade(student.getSubject(1).getScore());
    }

    public String getMathGrade(Student student) {
        return grade.engMathGrade(student.getSubject(2).getScore());
    }

    public String getOptionGrade(Student student) {
        return grade.optionGrade(student.getSubject(3).getScore());
    }
}