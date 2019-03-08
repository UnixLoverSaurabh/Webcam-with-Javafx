package sample;

import com.github.sarxos.webcam.Webcam;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Webcam webcam = Webcam.getDefault();
        if (webcam != null) {
            System.out.println("Webcam: " + webcam.getName());
            webcam.open();
            ImageIO.write(webcam.getImage(), "JPG", new File("first.jpg"));
        } else {
            System.out.println("No webcam detected");
        }
    }
}