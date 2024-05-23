package org.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;

public class HotelesView {
    //cambios

    public Button backButton;
    public Button buttonAdd;
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
    public void buttonAdd(ActionEvent actionEvent){
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Añadir Hotel");
        dialog.setHeaderText("Añadir Hotel");
    }


}
