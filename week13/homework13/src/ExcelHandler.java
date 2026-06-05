import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class ExcelHandler {
    private DataFormatter formatter;

    public ExcelHandler() {
        formatter = new DataFormatter();
    }

    public ArrayList<Student> readExcel(String file) {
        ArrayList<Student> students = new ArrayList<>();

        try {
            InputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            XSSFWorkbook workbook = new XSSFWorkbook(bufferedInputStream);

            for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
                XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
                String className = sheet.getSheetName();

                for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                    XSSFRow row = sheet.getRow(i);

                    if (row == null) {
                        continue;
                    }

                    String hakbun = readData(row, 0);
                    String name = readData(row, 1);
                    String gender = readData(row, 2);

                    if (hakbun.equals("") || name.equals("") || gender.equals("")) {
                        continue;
                    }

                    Student student = new Student(name, gender);
                    student.setHakbun(hakbun);
                    student.setClassName(className);

                    for (int j = 0; j < student.getSubjects().size(); j++) {
                        student.getSubject(j).setScore(readScore(row, j + 3));
                    }

                    students.add(student);
                }
            }

            workbook.close();
            bufferedInputStream.close();
            System.out.printf("%d명의 데이터를 읽었습니다.\n", students.size());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return students;
    }

    private String readData(XSSFRow row, int index) {
        XSSFCell cell = row.getCell(index);

        if (cell == null) {
            return "";
        }

        return formatter.formatCellValue(cell).trim();
    }

    private int readScore(XSSFRow row, int index) {
        String data = readData(row, index);

        if (data.equals("")) {
            return 0;
        }

        return Integer.parseInt(data);
    }
}