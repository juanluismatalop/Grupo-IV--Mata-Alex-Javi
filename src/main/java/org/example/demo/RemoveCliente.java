package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.demo.model.dao.daoApartamento.ApartamentoDAO;
import org.example.demo.model.dao.daoApartamento.ApartamentoDAOImpl;
import org.example.demo.model.dao.daoUsuario.Usuario;
import org.example.demo.model.dao.daoUsuario.UsuarioDAO;
import org.example.demo.model.dao.daoUsuario.UsuarioDAOImpl;

import java.io.IOException;
import java.sql.SQLException;

public class RemoveCliente {

    private ClientesView clientesViewController;
    public void setClientesViewController(ClientesView clientesViewController) {
        this.clientesViewController = clientesViewController;
    }

    @FXML
    private TextField telefonoField;

    @FXML
    public void delete(ActionEvent actionEvent) {
        try {
            int telefono = Integer.parseInt(telefonoField.getText());
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
            boolean success = usuarioDAO.deleteUsuarioByTelefono(telefono);

            Alert alert;
            if (success) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setHeaderText(null);
                alert.setContentText("Usuario eliminado correctamente.");
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("No se encontró el apartamento con el ID proporcionado.");
            }

            alert.showAndWait();

            // Close the current window
            Stage stage = (Stage) telefonoField.getScene().getWindow();
            stage.close();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, ingrese un ID válido.");
            alert.showAndWait();
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error al eliminar el Usuario de la base de datos.");
            alert.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
