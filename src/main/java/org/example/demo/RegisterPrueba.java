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
    @FXML
    public PasswordField textContrasenna;
    @FXML
    public TextField textNombreCompleto;
    @FXML
    public TextField textTelefono;
    @FXML
    public TextField textCorreoElectronico;
    @FXML
    public TextField textDireccion;
    @FXML
    public Label errorContraseña;
    @FXML
    private Label labelRegistroError;
    @FXML
    private Button buttonRegister;
    @FXML
    private Button buttonAtras;
    private Stage stage;
    private Parent root;
    private Scene scene;

    public RegisterPrueba() throws SQLException, IOException {
    }

    @FXML
    public void onClick(ActionEvent actionEvent) throws IOException {
        String nombreCompleto = textNombreCompleto.getText();
        String sTelefono = textTelefono.getText();
        String correoElectronico = textCorreoElectronico.getText();
        String direccion = textDireccion.getText();
        String contrasenna = textContrasenna.getText();

        // Validating if any fields are empty
        if (nombreCompleto.isEmpty() || sTelefono.isEmpty() || correoElectronico.isEmpty() || direccion.isEmpty() || contrasenna.isEmpty()) {
            labelRegistroError.setText("Faltan campos por rellenar");
            return;
        }

        try {
            // Validating phone number
            int telefono = Integer.parseInt(sTelefono);
            if (!esTelefonoValido(sTelefono)) {
                labelRegistroError.setText("El teléfono debe tener 9 caracteres numéricos");
                textTelefono.requestFocus();
                return;
            }

            // Validating email
            if (!esCorreoValido(correoElectronico)) {
                labelRegistroError.setText("El correo debe tener una @");
                textCorreoElectronico.requestFocus();
                return;
            }

            // Validating password
            if (!esContrasennaValida(contrasenna)) {
                errorContraseña.setText("La contraseña debe tener 8 caracteres, una mayúscula, un punto o coma y un número");
                textContrasenna.requestFocus();
                return;
            }

            // Inserting user into the database
            Usuario usuario = new Usuario(telefono, correoElectronico, contrasenna, nombreCompleto, direccion, "Administrador");
            usuarioDAO.insertUsuario(usuario);

            // Loading next scene
            stage = (Stage) buttonRegister.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("ventana-view.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (NumberFormatException e) {
            labelRegistroError.setText("El teléfono debe ser numérico");
            textTelefono.requestFocus();
        } catch (SQLException e) {
            if (e.getMessage().contains("SQLITE_CONSTRAINT_PRIMARYKEY")) {
                labelRegistroError.setText("El teléfono ya está registrado");
                textTelefono.requestFocus();
            } else {
                labelRegistroError.setText("Error de base de datos: " + e.getMessage());
            }
        } catch (IOException e) {
            labelRegistroError.setText("Error al cargar la siguiente ventana");
        }
    }

    private static boolean esTelefonoValido(String sTelefono) {
        return sTelefono.matches("\\d{9}");
    }

    private static boolean esCorreoValido(String correoElectronico) {
        return correoElectronico.contains("@");
    }

    private static boolean esContrasennaValida(String contrasenna) {
        if (contrasenna.length() < 8) {
            return false;
        }
        boolean tieneMayuscula = contrasenna.matches(".*[A-Z].*");
        boolean tienePuntoOComa = contrasenna.matches(".*[.,].*");
        boolean tieneDigito = contrasenna.matches(".*\\d.*");
        return tieneMayuscula && tienePuntoOComa && tieneDigito;
    }

    @FXML
    public void buttonAtras(ActionEvent actionEvent) throws IOException {
        stage = (Stage) buttonAtras.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("logInPrueba.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

