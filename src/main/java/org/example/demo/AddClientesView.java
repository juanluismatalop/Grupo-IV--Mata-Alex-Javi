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
            String funcion = funcionField.getText().trim();
            String direccion = direccionField.getText().trim();
            String email = emailField.getText().trim();
            String nombre = nombreField.getText().trim();


            // Crea un nuevo objeto Hotel
            Usuario newUsuario = new Usuario(telefono, contrasenna, funcion, direccion, email, nombre);

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
            labelError.setText("Formato de ID o número de estrellas inválido.");
        } catch (SQLException e) {
            labelError.setText("Error de base de datos: " + e.getMessage());
        } catch (IOException e) {
            labelError.setText("Error de IO: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}



