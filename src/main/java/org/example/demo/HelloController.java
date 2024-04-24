package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

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
    public void onClick(ActionEvent actionEvent) throws IOException {
        String login = textLogin.getText();
        String password = textPassword.getText();
        System.out.println(login + "--" + password);
        //consultamos a la BD y para Manuel la contraseña es 1234
        //SI CORRECTO, CAMBIAR DE VENTANA
        if (login.equals("manuel") && password.equals("1234")) {
            System.out.println("Cambiamos de ventana");
            stage = (Stage) buttonSubmit.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("ventana-view.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else labelUserError.setText("Usuario incorrecto");
        //SINO MENSAJE DE ERROR
    }
}