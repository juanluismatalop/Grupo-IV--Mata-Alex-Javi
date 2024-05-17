package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaController {
    public Button buttonCerrarSesion;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void buttonCerrarSesion(ActionEvent actionEvent) throws IOException {
        stage = (Stage) buttonCerrarSesion.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("logInPrueba.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
