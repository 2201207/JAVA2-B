import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ZXingHandler {

    protected void decoding(File file) {
        MultiFormatReader reader = new MultiFormatReader();
        try {
            FileInputStream inputStream = new FileInputStream(file);
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            HybridBinarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, String> hintTypeStringMap = new HashMap<>();
            hintTypeStringMap.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            Result result = reader.decode(binaryBitmap, hintTypeStringMap);
            System.out.println("QR Code : " + result.getText());
            System.out.println("Code Foramt : " + result.getBarcodeFormat());
        } catch (IOException | NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}