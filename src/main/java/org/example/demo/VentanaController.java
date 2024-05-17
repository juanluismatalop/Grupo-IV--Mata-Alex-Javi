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
    public Button buttonHoteles;
    public Button buttonReservas;
    public Button buttonApartamento;
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
        System.out.println("Boton pulsado");
    }
    @FXML
    public void buttonHoteles(ActionEvent actionEvent) throws IOException {
        stage = (Stage) buttonHoteles.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Hoteles-view.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Boton pulsado");
    }
    @FXML
    public void buttonReservas(ActionEvent actionEvent) throws IOException {
        stage = (Stage) buttonReservas.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Reservas-view.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Boton pulsado");
    }
    @FXML
    public void buttonApartamento(ActionEvent actionEvent) throws IOException {
        stage = (Stage) buttonApartamento.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("ApartamentosTuristicos-view.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Boton pulsado");
    }
}
