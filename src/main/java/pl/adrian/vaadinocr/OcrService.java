package pl.adrian.vaadinocr;

import java.awt.image.BufferedImage;
import java.net.URL;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import org.springframework.stereotype.Service;

@Service
public class OcrService {

    @Value("${datapath}")
    private String datapath;

    public String doOCR(String url) {
        try {
            URL imageFile = new URL(url);
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            ITesseract instance = new Tesseract();
            instance.setDatapath(datapath);
            instance.setLanguage("pol");
            return instance.doOCR(bufferedImage);
        } catch (Exception e) {
            // TODO Exception handler
            e.printStackTrace();
        }
        return "";
    }
}
