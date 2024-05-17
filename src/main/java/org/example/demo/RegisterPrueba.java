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
    private Label labelRegistroError;
    @FXML
    private Button buttonRegister;
    @FXML
    private Button buttonAtras;
    @FXML
    public void onClick(ActionEvent actionEvent) throws IOException {
        String nombreCompleto = textNombreCompleto.getText();
        String sTelefono = textTelefono.getText();
        System.out.println("telefono: " + sTelefono);
        System.out.println(sTelefono.equals(""));
        int telefono = Integer.parseInt(sTelefono);
        String correoElectronico = textCorreoElectronico.getText();
        String direccion = textDireccion.getText();
        String contrasenna = textContrasenna.getText();

        //si todos los camnos estan rellenos pasamos a ventana-view si no nos saldra un error de campos incorrectos
        if (checkNombreCompleto(nombreCompleto)==false&&checkTelefono(telefono)==false&&checkCorreoElectronico(correoElectronico)==false&&checkDireccion(direccion)==false&&checkContrasenna(contrasenna)==false)
            labelRegistroError.setText("Usuario incorrecto");
        else
            stage = (Stage) buttonRegister.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("ventana-view.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

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

    public void buttonAtras(ActionEvent actionEvent) throws IOException {
        stage = (Stage) buttonAtras.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("logInPrueba.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
