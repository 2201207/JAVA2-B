import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PDFHandler {
    private String[] headers = {
            "반", "학번", "이름", "성별",
            "국어", "국어평점",
            "영어", "영어평점",
            "수학", "수학평점",
            "선택과목", "선택", "선택평점",
            "합계", "평균", "반등수", "학년등수"
    };

    public void makePDF(String file, ArrayList<Student> students) throws IOException {
        Document document = new Document(PageSize.A4.rotate(), 20, 20, 30, 30);

        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

            PdfWriter.getInstance(document, bufferedOutputStream);
            document.open();

            BaseFont baseFont = BaseFont.createFont(
                    "C:/Windows/Fonts/malgun.ttf",
                    BaseFont.IDENTITY_H,
                    BaseFont.EMBEDDED
            );

            Font titleFont = new Font(baseFont, 18, Font.BOLD, BaseColor.RED);
            Font font = new Font(baseFont, 9);
            Font headerFont = new Font(baseFont, 9, Font.BOLD);

            title(document, titleFont);

            PdfPTable table = new PdfPTable(headers.length);
            table.setWidthPercentage(100);

            header(table, headerFont);
            record(font, table, students);

            document.add(table);
            document.close();
            bufferedOutputStream.close();

            System.out.println("PDF 파일 생성 성공");

        } catch (DocumentException e) {
            System.out.println("PDF 생성 중 오류 : " + e.getMessage());
        }
    }

    private void title(Document document, Font titleFont) throws DocumentException {
        Paragraph paragraph = new Paragraph("학생 성적표", titleFont);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.setSpacingAfter(20);
        document.add(paragraph);
    }

    private void header(PdfPTable table, Font font) {
        for (int i = 0; i < headers.length; i++) {
            table.addCell(getCell(headers[i], font, BaseColor.LIGHT_GRAY));
        }
    }

    private void record(Font font, PdfPTable table, ArrayList<Student> students)
            throws DocumentException {

        ClassRoom classRoom = new ClassRoom(students);

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            table.addCell(getCell(student.getClassName(), font));
            table.addCell(getCell(student.getHakbun(), font));
            table.addCell(getCell(student.getName(), font));
            table.addCell(getCell(student.getGender(), font));

            table.addCell(getCell(String.valueOf(student.getSubject(0).getScore()), font));
            table.addCell(getCell(classRoom.getKorGrade(student), font));

            table.addCell(getCell(String.valueOf(student.getSubject(1).getScore()), font));
            table.addCell(getCell(classRoom.getEngGrade(student), font));

            table.addCell(getCell(String.valueOf(student.getSubject(2).getScore()), font));
            table.addCell(getCell(classRoom.getMathGrade(student), font));

            table.addCell(getCell(student.getSubject(3).getSubjectName(), font));
            table.addCell(getCell(String.valueOf(student.getSubject(3).getScore()), font));
            table.addCell(getCell(classRoom.getOptionGrade(student), font));

            table.addCell(getCell(String.valueOf(student.sum()), font));
            table.addCell(getCell(String.format("%.2f", student.avg()), font));

            table.addCell(getCell(
                    String.valueOf(student.getRank()),
                    font,
                    student.getGender().equals("여") ? BaseColor.PINK : BaseColor.GREEN
            ));

            table.addCell(getCell(String.valueOf(student.getGradeRank()), font));
        }
    }

    private PdfPCell getCell(String data, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(data, font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setPadding(4);
        return cell;
    }

    private PdfPCell getCell(String data, Font font, BaseColor color) {
        PdfPCell cell = getCell(data, font);
        cell.setBackgroundColor(color);
        return cell;
    }
}