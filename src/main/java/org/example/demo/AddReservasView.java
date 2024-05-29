package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.demo.model.dao.daoReservas.Reservas;
import org.example.demo.model.dao.daoReservas.DAOReservas;
import org.example.demo.model.dao.daoReservas.DAOReservasImpl;
import org.example.demo.model.dao.daoUsuario.UsuarioDAO;
import org.example.demo.model.dao.daoUsuario.UsuarioDAOImpl;
import java.io.IOException;
import java.sql.SQLException;

public class AddReservasView {
    @FXML
    private Label labelError;
    @FXML
    private Label labelCorrect;
    @FXML
    private TextField idField;
    @FXML
    private TextField telefonoField;
    @FXML
    private TextField fechaEntradaField;
    @FXML
    private TextField fechaSalidaField;
    @FXML
    private Button addButton;
    private ReservasView reservasViewController;
    public void setReservasViewController(ReservasView reservasViewController) {
        this.reservasViewController = reservasViewController;
    }
    public void add() {
        labelError.setText("");
        labelCorrect.setText("");
        try {
            // Validar el campo ID
            if (idField.getText().isEmpty() || !idField.getText().matches("\\d+")) {
                labelError.setText("Por favor ingrese un ID válido.");
                return;
            }
            String telefonoText = telefonoField.getText();
            if (telefonoText.isEmpty() || !telefonoText.matches("\\d+")) {
                labelError.setText("Por favor ingrese un número de teléfono válido.");
                return;
            }
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
            if (usuarioDAO.getTelefonoCliente(Integer.parseInt(telefonoText)) == null) {
                labelError.setText("El número de teléfono no pertenece a ningún cliente.");
                return;
            }
            int id = Integer.parseInt(idField.getText());
            int telefono = Integer.parseInt(telefonoText);
            String fechaEntrada = fechaEntradaField.getText().trim();
            String fechaSalida = fechaSalidaField.getText().trim();
            Reservas newReserva = new Reservas(id, telefono, fechaEntrada, fechaSalida);
            DAOReservas daoReservas = new DAOReservasImpl();
            daoReservas.insertReserva(newReserva);
            if (reservasViewController != null) {
                reservasViewController.updateTableView();
            }
            labelCorrect.setText("Reserva agregada exitosamente.");
            idField.clear();
            telefonoField.clear();
            fechaEntradaField.clear();
            fechaSalidaField.clear();
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        } catch (NumberFormatException e) {
            labelError.setText("Formato de ID o teléfono inválido.");
        } catch (SQLException e) {
            labelError.setText("Error de base de datos: " + e.getMessage());
        } catch (IOException e) {
            labelError.setText("Error de IO: " + e.getMessage());
        } catch (Exception e) {
            labelError.setText("Ocurrió un error: " + e.getMessage());
        }
    }
}

