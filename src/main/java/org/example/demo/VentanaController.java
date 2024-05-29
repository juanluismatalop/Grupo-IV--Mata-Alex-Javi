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
    @FXML
    private Button buttonCerrarSesion;
    @FXML
    private Button buttonHoteles;
    @FXML
    private Button buttonReservas;
    @FXML
    private Button buttonApartamento;
    private Stage stage;

    // Método para cambiar la escena
    private void changeScene(String fxmlFile, Button button) throws IOException {
        stage = (Stage) button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Boton pulsado");
    }
    @FXML
    public void buttonCerrarSesion(ActionEvent actionEvent) throws IOException {
        changeScene("logInPrueba.fxml", buttonCerrarSesion);
    }
    @FXML
    public void buttonHoteles(ActionEvent actionEvent) throws IOException {
        changeScene("Hoteles-view.fxml", buttonHoteles);
    }
    @FXML
    public void buttonReservas(ActionEvent actionEvent) throws IOException {
        changeScene("Reservas-view.fxml", buttonReservas);
    }
    @FXML
    public void buttonApartamento(ActionEvent actionEvent) throws IOException {
        changeScene("ApartamentosTuristicos-view.fxml", buttonApartamento);
    }
}
