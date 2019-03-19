package sample;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Label simpleLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ThreadToUpdateScene();
        for (int i = 0; i < 15; i++) {
            System.out.println("Its a initialisation method");
        }
    }

    private void ThreadToUpdateScene() {
        Task<Void> task = new Task<Void>() {

            @Override
            protected Void call() {
                while (true) {
                    UpdateScene(); //repaint every 25 ms

                    try {
                        Thread.sleep(2500); //sleep 25 ms
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }

    private void UpdateScene() {
        System.out.println("This is title from UpdateScene");
        simpleLabel.setText("This is title from UpdateScene");
    }
}
