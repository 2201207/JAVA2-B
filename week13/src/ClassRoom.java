import java.util.ArrayList;

public class ClassRoom {
    private ArrayList<Student> students;

    public ClassRoom(ArrayList<Student> students) {
        this.students = students;
    }

    protected void sortByGenderAndSum() {
        Student student;
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).getGender().compareTo(students.get(j).getGender()) > 0) {
                    student = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, student);
                }
            }
        }

        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).getGender().equals(students.get(j).getGender())) {
                    if (students.get(i).sum() > students.get(j).sum()) {
                        student = students.get(i);
                        students.set(i, students.get(j));
                        students.set(j, student);
                    }
                }
            }
        }
    }
    protected int getGenderRank(String gender, int index) {
        int rank = 1;
        int sum = students.get(index).sum();
        for (int i = 0; i < students.size(); i++)
            if (students.get(i).getGender().equals(gender) &&
                    students.get(i).sum() > sum)
                rank++;

        return rank;
    }

    protected int getRank(int index) {
        int rank = 1;
        int sum = students.get(index).sum();
        for (int i = 0; i < students.size(); i++)
            if (students.get(i).sum() > sum)
                rank++;

        return rank;
    }
}