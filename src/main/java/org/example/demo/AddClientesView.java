package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.demo.model.dao.daoUsuario.Usuario;
import org.example.demo.model.dao.daoUsuario.UsuarioDAO;
import org.example.demo.model.dao.daoUsuario.UsuarioDAOImpl;

import java.io.IOException;
import java.sql.SQLException;

public class AddClientesView {

    @FXML
    private TextField telefonoField;
    @FXML
    private Label labelError;
    @FXML
    private TextField contrasennaField;
    @FXML
    private Label labelCorrect;
    @FXML
    private TextField funcionField;
    @FXML
    private TextField direccionField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField nombreField;

    @FXML
    private Button addButton;

    private ClientesView clientesViewController;


    public void setClientesViewController(ClientesView clientesViewController) {
        this.clientesViewController = clientesViewController;
    }

    @FXML
    public void add() {
        // Limpia los mensajes de error/correcto antes de comenzar
        labelError.setText("");
        labelCorrect.setText("");

        try {


            // Parse y valida los campos de entrada
            int telefono = Integer.parseInt(telefonoField.getText());
            String contrasenna = contrasennaField.getText().trim();
            String direccion = direccionField.getText().trim();
            String email = emailField.getText().trim();
            String nombre = nombreField.getText().trim();

            if (!esTelefonoValido(String.valueOf(telefono))) {
                labelError.setText("El teléfono debe tener 9 caracteres numéricos");
                return;
            }

            // Validating email
            if (!esCorreoValido(email)) {
                labelError.setText("El correo debe tener una @");
                return;
            }

            // Validating password
            if (!esContrasennaValida(contrasenna)) {
                labelError.setText("La contraseña debe tener 8 caracteres, una mayúscula, un punto o coma y un número");
                return;
            }

            if (nombre.isEmpty()) {
                labelError.setText("Por favor, completa el campo de nombre.");
                return;
            }

            if (direccion.isEmpty()) {
                labelError.setText("Por favor, completa el campo de direccion.");
                return;
            }


            // Crea un nuevo objeto Hotel
            Usuario newUsuario = new Usuario(telefono, email, contrasenna, nombre, direccion, "Clientes");

            // Inserta el nuevo hotel en la base de datos
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
            usuarioDAO.insertUsuario(newUsuario);

            // Actualiza la vista de la tabla en el controlador principal
            if (clientesViewController != null) {
                //hotelesViewController.updateTableView();
            }

            // Proporciona retroalimentación al usuario
            labelCorrect.setText("Usuario agregado exitosamente.");

            // Cierra la ventana actual si se agregó exitosamente
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();

        } catch (NumberFormatException e) {
            labelError.setText("Formato invalido.");
        } catch (SQLException e) {
            labelError.setText("Error de base de datos: " + e.getMessage());
        } catch (IOException e) {
            labelError.setText("Error de IO: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
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
}



