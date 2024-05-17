package org.example.demo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInPrueba {
    //correcto
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField textPassword, textLogin;
    @FXML
    private Label labelUserError;
    @FXML
    private Button buttonSubmit;
    @FXML
    private Button buttonRegister;

    @FXML
    public void onClick(ActionEvent actionEvent) throws IOException {
        System.out.println("pulsado boton");
        String login = textLogin.getText();
        String password = textPassword.getText();
        System.out.println(login + "--" + password);
        if (login.equals("manuel") && password.equals("1234")) {
            System.out.println("Cambiamos de ventana");
            stage = (Stage) buttonSubmit.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("ventana-view.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else if (login.equals("") && password.equals("")) {
            stage = (Stage) buttonRegister.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("registerPrueba.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            labelUserError.setText("Usuario incorrecto");

        }
    }
}
