package org.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HotelesView {

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
    public void buttonAdd(ActionEvent actionEvent) throws IOException {
//        stage = (Stage) buttonAdd.getScene().getWindow();
//        root = FXMLLoader.load(getClass().getResource("Annadir-Hotel-view.fxml"));
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
        FXMLLoader fxmlLoader = new FXMLLoader(HotelesView.class.getResource("Annadir-Hotel-view.fxml"));
        Scene scene2 = new Scene(fxmlLoader.load(), 600, 450);
        scene2 = new Scene(root);
        stage.setScene(scene2);
        stage.show();
    }


}
