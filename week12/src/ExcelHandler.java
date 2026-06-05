import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class ExcelHandler {

    protected ArrayList<Student> readExcel(File file) {
        ArrayList<Student> students = new ArrayList<>();

        try {
            InputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            XSSFWorkbook workbook = new XSSFWorkbook(bufferedInputStream);
            XSSFSheet sheet = workbook.getSheet("학생성적");
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                XSSFRow row = sheet.getRow(i);
                String studentID = readData(row, 0);
                String name = readData(row, 1);
                String gender = readData(row, 2);
                Student student = new Student(name, gender, studentID);
                for (int j = 0; j < student.getSubjects().size(); j++) {
                    student.setSubject(j,
                            Integer.parseInt(readData(row, j + 3)));
                }
                students.add(student);
            }
            if (students.isEmpty()) {
                System.out.println("데이터가 없습니다");
                System.exit(-1);
            }else {
                System.out.printf("%d개의 데이터를 읽었습니다.\n", students.size());
            }
            workbook.close();
            bufferedInputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    private String readData(XSSFRow row, int index) {
        XSSFCell cell = row.getCell(index);
        String value = "";
        switch (cell.getCellType()) {
            case STRING :
                value = cell.getStringCellValue();
                break;
            case NUMERIC:
                value = (int) cell.getNumericCellValue() + "";
        }
        return value;
    }

    public void writeExcel(String fileName, ArrayList<Student> students) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("학생성적 처리");
        header(workbook, sheet, students);
        record(workbook, sheet, students);

        try {
            OutputStream outputStream = new FileOutputStream(fileName);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            workbook.write(bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            workbook.close();
            System.out.println("엑셀 파일 생성 성공");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void record(XSSFWorkbook workbook, XSSFSheet sheet, ArrayList<Student> students) {
        CellStyle femaleStyle = getCellStyle(workbook, IndexedColors.PINK);
        CellStyle maleStyle = getCellStyle(workbook, IndexedColors.GREEN);
        for (int i = 0; i < students.size(); i++) {
            XSSFRow row = sheet.createRow(i + 1);
            Student student = students.get(i);
            CellStyle style = student.getGender().equals("여") ? femaleStyle : maleStyle;
            XSSFCell cell = row.createCell(0);
            cell.setCellValue(student.getStudentID());
            cell= row.createCell(1);
            cell.setCellValue(student.getName());
            cell= row.createCell(2);
            cell.setCellValue(student.getGender());
            for (int j = 0; j < student.getSubjects().size(); j++) {
                cell= row.createCell(3 + j);
                cell.setCellValue(student.getSubject(j).getScore());
            }
            cell= row.createCell(7);
            cell.setCellValue(student.sum());

            cell= row.createCell(8);
            cell.setCellValue(String.format("%.2f", student.average()));
            ClassRoom classRoom = new ClassRoom(students);
            cell= row.createCell(9);
            cell.setCellValue(classRoom.getGenderRank(student.getGender(), i));
            cell.setCellStyle(style);

            cell= row.createCell(10);
            cell.setCellValue(classRoom.getRank(i));


        }
    }


    private void header(XSSFWorkbook workbook, XSSFSheet sheet, ArrayList<Student> students) {
        CellStyle titleStyle = getCellStyle(workbook, IndexedColors.YELLOW);
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("학번");
        cell.setCellStyle(titleStyle);
        cell = row.createCell(1);
        cell.setCellValue("이름");
        cell.setCellStyle(titleStyle);
        cell = row.createCell(2);
        cell.setCellValue("성별");
        cell.setCellStyle(titleStyle);
        for (int i = 0; i < students.get(0).getSubjects().size() - 1; i++) {
            cell = row.createCell(i + 3);
            cell.setCellValue(students.get(0).getSubject(i).getSubjectName());
            cell.setCellStyle(titleStyle);
        }
        cell = row.createCell(6);
        cell.setCellValue("선택");
        cell.setCellStyle(titleStyle);
        cell = row.createCell(7);
        cell.setCellValue("합계");
        cell.setCellStyle(titleStyle);
        cell = row.createCell(8);
        cell.setCellValue("평균");
        cell.setCellStyle(titleStyle);
        cell = row.createCell(9);
        cell.setCellValue("성별 등수");
        cell.setCellStyle(titleStyle);
        cell = row.createCell(10);
        cell.setCellValue("전체 등수");
        cell.setCellStyle(titleStyle);



    }

    private CellStyle getCellStyle(XSSFWorkbook workbook, IndexedColors color) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(color.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        return cellStyle;
    }
}