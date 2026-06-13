import java.io.IOException;

public class ClassRoom {
    private Student[] students;

    public ClassRoom(Student[] students) {
        this.students = students;
    }

    protected void inputData() throws IOException {
        for (int i = 0; i < students.length; i++) {
            students[i].inputData();
            System.out.println();
        }
    }


    protected void display(int type) {
        if (type == 1) {
            System.out.println("\t\t\t\t 고등학교 성적표");
            line(50);
            System.out.printf("  학변 이름  %s  총점 성적  등수\n",
                    students[0].partsNameList());
            line(50);
            for (int i = 0; i < students.length; i++)
                System.out.println(students[i]);
            line(50);
        } else {
            System.out.println("\t\t\t\t 대학교 성적표");
            line(80);
            System.out.printf("  학변 이름  %s  성적  등수\n",
                    students[0].partsNameList());
            line(80);
            for (int i = 0; i < students.length; i++)
                System.out.println(students[i]);
            line(80);
        }
    }

    private void line(int count) {
        for (int i = 0; i < count; i++)
            System.out.print("*");
        System.out.println();
    }
}