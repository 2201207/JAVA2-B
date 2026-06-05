import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;
import java.util.ArrayList;

public class PDFHandler {
    String[] headers = {"학번", "이름", "성별", "국어", "영어", "수학", "선택", "합계", "평균", "성별등수", "학급등수"};


    protected ArrayList<Student> readPDF(String fileName) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            PdfReader reader = new PdfReader(fileName);
            StringBuilder builder = new StringBuilder();
            //     System.out.printf(reader.getNumberOfPages() + " ");
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                String pageText = PdfTextExtractor.getTextFromPage(reader, i);
                builder.append(pageText).append("\n");
            }
            reader.close();
            makeData(builder.toString(), students);
            if (students.isEmpty()) {
                System.out.println("데이터가 없습니다");
                System.exit(-1);
            } else {
                System.out.printf("%d개의 데이터를 읽었습니다.\n", students.size());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    private void makeData(String text, ArrayList<Student> students) {
        String[] lines = text.split("\\r?\\n");
        for (int i = 0; i < lines.length; i++) {
            String fixedLine = lines[i].replaceAll("^(\\d{7})([가-힣]+)", "$1 $2");
            System.out.printf("%d: %s\n", i + 1, fixedLine.trim());
            if (fixedLine.matches("^\\d{7}\\s+.*")) {
                String[] tokens = fixedLine.trim().split("\\s+");
                if (tokens.length >= 7) {
                    String studentID = tokens[0];
                    String name = tokens[1];
                    String gender = tokens[2];
                    Student student = new Student(name, gender, studentID);
                    for (int j = 0; j < student.getSubjects().size(); j++) {
                        student.getSubject(j).setScore(Integer.parseInt(tokens[j +3]));
                    }
                    students.add(student);
                }
            }
        }
    }

    public void makePDF(String fileName, ArrayList<Student> students) {
        Document document = new Document();

        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            PdfWriter.getInstance(document, bufferedOutputStream);
            document.open();
            BaseFont baseFont = BaseFont.createFont("C:/Windows/Fonts/malgun.ttf",
                    BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(baseFont, 8);
            PdfPTable table = new PdfPTable(headers.length);
            title(document, baseFont, font, table);
            record(font, table, students);
            document.add(table);
            System.out.println("PDF 파일 생성 완료");
        } catch (DocumentException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            document.close();
        }
    }

    private void record(Font font, PdfPTable table, ArrayList<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            table.addCell(getCell(student.getStudentID(), font));
            table.addCell(getCell(student.getName(), font));
            table.addCell(getCell(student.getGender(), font));
            for (int j = 0; j < student.getSubjects().size(); j++) {
                table.addCell(getCell(String.valueOf(student.getSubject(j).getScore()), font));
            }
            table.addCell(getCell(String.valueOf(student.sum()), font));
            table.addCell(getCell(String.valueOf(student.avg()), font));
            ClassRoom classRoom = new ClassRoom(students);
            table.addCell(getCell(String.valueOf(classRoom.getGenderRank(student.getGender(), i)), font,
                    student.getGender().equals("여") ? BaseColor.PINK : BaseColor.GREEN));
            table.addCell(getCell(String.valueOf(classRoom.getRank(i)), font));

        }

    }

    private void title(Document document, BaseFont baseFont, Font font, PdfPTable table) throws DocumentException {
        Font titleFont = new Font(baseFont, 16, Font.BOLD, BaseColor.RED);
        Paragraph title = new Paragraph("학생 성적표", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        document.add(new Paragraph("\n"));
        for (int i = 0; i < headers.length; i++) {
            table.addCell(getCell(headers[i], font, BaseColor.YELLOW));
        }
    }

    private PdfPCell getCell(String data, Font font) {
        PdfPCell cell = new PdfPCell(new Paragraph(data, font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        return cell;
    }

    private PdfPCell getCell(String data, Font font, BaseColor color) {
        PdfPCell cell = new PdfPCell(new Paragraph(data, font));
        cell.setBackgroundColor(color);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        return cell;
    }
}