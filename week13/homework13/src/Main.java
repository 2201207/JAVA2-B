import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        final String path = ".\\data\\";
        final String datafile = "student.xlsx";
        final String pdf = "student.pdf";

        ArrayList<Student> students;
        File file = new File(path + datafile);

        if (file.exists()) {
            ExcelHandler excelHandler = new ExcelHandler();
            students = excelHandler.readExcel(path + datafile);

            if (!students.isEmpty()) {
                ClassRoom classRoom = new ClassRoom(students);
                classRoom.rank();
                classRoom.sortByClassAndRank();

                PDFHandler pdfHandler = new PDFHandler();
                pdfHandler.makePDF(path + pdf, students);
            } else {
                System.out.println("데이터가 없습니다.");
            }
        } else {
            System.out.printf("%s 데이터 파일이 없습니다.\n", path + datafile);
        }
    }
}