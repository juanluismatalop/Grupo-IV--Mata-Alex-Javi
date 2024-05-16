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

public class RegisterPrueba {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField textNombreCompleto, textCorreoElectronico, textDireccion, textContrasenna, textTelefono;
    @FXML
    private Label labelUserError;
    @FXML
    private Button buttonRegister;
    @FXML
    public void onClick(ActionEvent actionEvent) throws IOException {
        String nombreCompleto = textNombreCompleto.getText();
        int telefono = Integer.parseInt(textTelefono.getText());
        String correoElectronico = textCorreoElectronico.getText();
        String direccion = textDireccion.getText();
        String contrasenna = textContrasenna.getText();
        //si todos los camnos estan rellenos pasamos a ventana-view si no nos saldra un error de campos incorrectos
        if (checkNombreCompleto(nombreCompleto) == true && checkTelefono(telefono) == true) {
            labelUserError.setText("Faltan Campos");
        } else {
            stage = (Stage) buttonRegister.getScene().getWindow();
            try {
                root = FXMLLoader.load(getClass().getResource("ventana-view.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    private boolean checkNombreCompleto(String nombreCompleto){
        if (nombreCompleto == null)
            return false;
        else
            return true;
    }
    private  boolean checkTelefono(int telefono){
       if (telefono == Integer.parseInt(null))
           return false;
       else
           return true;
    }

    private boolean checkCorreoElectronico (String correoElectronico){
        if (correoElectronico == null)
            return false;
        else
            return true;
    }
    private boolean checkDireccion (String direccion){
        if (direccion==null)
            return false;
        else
            return true;
    }
    private boolean checkContrasenna (String contrasenna){
        if (contrasenna == null)
            return false;
        else
            return true;
    }
}
