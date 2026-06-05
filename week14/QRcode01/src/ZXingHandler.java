import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ZXingHandler {

    protected void encoding(String data, String fileName) {
        MultiFormatWriter writer = new MultiFormatWriter();
        Map<EncodeHintType, Object> hintTypeObjectMap = new HashMap<>();
        hintTypeObjectMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hintTypeObjectMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        try {
            BitMatrix bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, 250, 250, hintTypeObjectMap);
            Path path = Paths.get(fileName);
            MatrixToImageConfig config = new MatrixToImageConfig(
                    0XFFFF0000, 0XFFFFFFFF);

            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path, config);
            System.out.println("QRCode 완성");
        } catch (WriterException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}