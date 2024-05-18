package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HotelesView {

    private Stage stage;
    private Parent root;
    private Scene scene;
    private Button buttonAtras;

    public void buttonAtras(ActionEvent actionEvent) throws IOException {
        stage = (Stage) buttonAtras.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("ventana-view.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
