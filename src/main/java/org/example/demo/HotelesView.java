package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HotelesView {

    public Button backButton;
    private Stage stage;
    private Parent root;
    private Scene scene;

    public void back(ActionEvent actionEvent) throws IOException {
        stage = (Stage) backButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("ventana-view.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
