import java.io.File;
import java.util.ArrayList;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        String path = ".\\data\\";
        String fileName = "student.pdf";
        String outputFile = "report.pdf";
        ArrayList<Student> students;


        File file = new File(path + fileName);
        if (file.exists()) {
            PDFHandler handler = new PDFHandler();

            students = handler.readPDF(path + fileName);
            ClassRoom classRoom = new ClassRoom(students);
            classRoom.sortByGenderAndSum();

            handler.makePDF(path + outputFile, students);


        } else {
            System.out.printf("%s File이 존재하지 않아요.\n", path + fileName);
        }
    }
}