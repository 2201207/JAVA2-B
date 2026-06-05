import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class iTextHandler {

    protected void makePDF(Book[] books, String fileName) {
        try {
            Document document = new Document();
            FileOutputStream outputStream = new FileOutputStream(fileName);
            PdfWriter.getInstance(document, outputStream);
            document.open();
            XMLWorkerFontProvider fontProvider = new XMLWorkerFontProvider(
                    XMLWorkerFontProvider.DONTLOOKFORFONTS);
            fontProvider.register("c:\\windows\\Fonts\\malgun.ttf", "MyFont");
            Font titleFont = fontProvider.getFont("MyFont", 18, Font.BOLD, BaseColor.BLACK);
            Font normalFont = fontProvider.getFont("MyFont",12);

            Paragraph title = new Paragraph("도서 납품서", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(Chunk.NEWLINE);
            for (int i = 0; i < books.length; i++) {
                document.add(new Paragraph("도서명 : " + books[i].getTitle(), normalFont));
                document.add(new Paragraph("수량 : " + books[i].getQty(), normalFont));
                document.add(new Paragraph("단가 : " + books[i].getPrice(), normalFont));
                String qrData = books[i].getTitle() + " | ISBN : " + books[i].getIsbn();
                BarcodeQRCode qrCode = new BarcodeQRCode(qrData, 150, 150, null);
                Image qrimage = qrCode.getImage();
                qrimage.scalePercent(50);
                document.add(new Paragraph("도서정보 QR CODE "));
                document.add(qrimage);
                LineSeparator separator = new LineSeparator();
                separator.setLineColor(BaseColor.LIGHT_GRAY);
                document.add(new Chunk(separator));
                document.add(Chunk.NEWLINE);
            }
            document.close();
            System.out.println("PDF 생성 완료");
        } catch (FileNotFoundException | DocumentException e) {
            System.out.println(e.getMessage());
        }
    }
}