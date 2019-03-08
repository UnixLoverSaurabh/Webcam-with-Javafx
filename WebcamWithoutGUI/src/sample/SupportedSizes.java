package sample;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SupportedSizes {
    public static void main(String[] args) throws IOException {
        Webcam webcam = Webcam.getDefault();
        if (webcam != null) {
            System.out.println("Webcam: " + webcam.getName());



            for (Dimension supportedSizes : webcam.getViewSizes()) {
                System.out.println(supportedSizes.toString());
            }
            //webcam.setViewSize(new Dimension(640, 480));
            // or
            webcam.setViewSize(WebcamResolution.VGA.getSize());


            webcam.open();
            ImageIO.write(webcam.getImage(), "JPG", new File("third.jpg"));
        } else {
            System.out.println("No webcam detected");
        }
    }
}
