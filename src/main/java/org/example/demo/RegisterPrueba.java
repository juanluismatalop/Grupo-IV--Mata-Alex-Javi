package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.demo.model.dao.daoUsuario.Usuario;
import org.example.demo.model.dao.daoUsuario.UsuarioDAO;
import org.example.demo.model.dao.daoUsuario.UsuarioDAOImpl;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterPrueba {
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
    public PasswordField textContrasenna;
    public TextField textNombreCompleto;
    public TextField textTelefono;
    public TextField textCorreoElectronico;
    public TextField textDireccion;
    public Label errorContraseña;
    private Stage stage;
    private Scene scene;
    private Parent root;
    /*@FXML
    private TextField textNombreCompleto, textCorreoElectronico, textDireccion, textContrasenna, textTelefono;*/
    @FXML
    private Label labelRegistroError;
    @FXML
    private Button buttonRegister;
    @FXML
    private Button buttonAtras;

    public RegisterPrueba() throws SQLException, IOException {
    }

    @FXML
    public void onClick(ActionEvent actionEvent) throws IOException {
        String nombreCompleto = textNombreCompleto.getText();
        String sTelefono = textTelefono.getText();
        System.out.println("telefono: " + sTelefono);
        System.out.println(sTelefono.equals(""));
        //int telefono = Integer.parseInt(sTelefono);
        String correoElectronico = textCorreoElectronico.getText();
        String direccion = textDireccion.getText();
        String contrasenna = textContrasenna.getText();

        //si todos los camnos estan rellenos pasamos a ventana-view si no nos saldra un error de campos incorrectos
        if (nombreCompleto.equals("")||sTelefono.equals("")||correoElectronico.equals("")||direccion.equals("")||contrasenna.equals(""))
            labelRegistroError.setText("Faltan campos por rellenar");
        else {

            try {
                int telefono = Integer.parseInt(sTelefono);
                if (esTelefonoValido(sTelefono) == false){
                    textTelefono.setText("Deben ser 9 caracteres numericos");
                    textTelefono.requestFocus();
                } else if (esCorreoValido(correoElectronico) == false) {
                    textCorreoElectronico.setText("El correo debe tener una @");
                    textContrasenna.requestFocus();
                } else if (esContrasennaValida(contrasenna) == false) {
                    errorContraseña.setText("La contraseña debe tener 8 caracteres una mayuscula un . o , y un numero");
                } else {
                    Usuario usuario = new Usuario(telefono, correoElectronico, contrasenna, nombreCompleto, direccion);
                    usuarioDAO.insertUsuario(usuario);
                    stage = (Stage) buttonRegister.getScene().getWindow();
                    root = FXMLLoader.load(getClass().getResource("ventana-view.fxml"));
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }

            } catch (NumberFormatException e) {
                textTelefono.setText("Deben ser caracteres numericos");
                textTelefono.requestFocus();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
    private static boolean esTelefonoValido(String sTelefono) {
        // Usar expresión regular para verificar si la cadena contiene exactamente 9 dígitos
        return sTelefono.matches("\\d{9}");
    }
    private static boolean esCorreoValido(String sTelefono) {
        // Verificar si la cadena contiene el carácter '@'
        return sTelefono.contains("@");
    }
    private static boolean esContrasennaValida(String contrasenna) {
        // Verificar que la longitud sea al menos 8
        if (contrasenna.length() < 8) {
            return false;
        }
        boolean tieneMayuscula = contrasenna.matches(".*[A-Z].*");
        boolean tienePuntoOComa = contrasenna.matches(".*[.,].*");
        boolean tieneDigito = contrasenna.matches(".*\\d.*");
        return tieneMayuscula && tienePuntoOComa && tieneDigito;
    }
    public void buttonAtras(ActionEvent actionEvent) throws IOException {
        stage = (Stage) buttonAtras.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("logInPrueba.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
