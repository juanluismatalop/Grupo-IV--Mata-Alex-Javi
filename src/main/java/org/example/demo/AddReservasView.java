package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.demo.model.dao.daoReservas.Reservas;
import org.example.demo.model.dao.daoReservas.DAOReservas;
import org.example.demo.model.dao.daoReservas.DAOReservasImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;


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

    @FXML
    public void add() {
        // Limpia los mensajes de error/correcto antes de comenzar
        labelError.setText("");
        labelCorrect.setText("");

        try {
            // Validar los campos de entrada
            if (idField.getText().isEmpty() || !idField.getText().matches("\\d+")) {
                labelError.setText("Por favor ingrese un ID válido.");
                return;
            }

            if (telefonoField.getText().isEmpty() || !telefonoField.getText().matches("\\d{9}")) {
                labelError.setText("Por favor ingrese un número de teléfono válido de 9 dígitos.");
                return;
            }

            // Parse y valida los campos de entrada
            int id = Integer.parseInt(idField.getText());
            int telefono = Integer.parseInt(telefonoField.getText());
            String fechaEntrada = fechaEntradaField.getText().trim();
            String fechaSalida = fechaSalidaField.getText().trim();

            // Validar las fechas
            if (fechaEntrada.isEmpty() || !isValidDate(fechaEntrada)) {
                labelError.setText("Por favor ingrese una fecha de entrada válida en formato YYYY-MM-DD.");
                return;
            }

            if (fechaSalida.isEmpty() || !isValidDate(fechaSalida)) {
                labelError.setText("Por favor ingrese una fecha de salida válida en formato YYYY-MM-DD.");
                return;
            }

            // Crea un nuevo objeto Reserva
            Reservas newReserva = new Reservas(id, telefono, fechaEntrada, fechaSalida);

            // Inserta el nuevo Reserva en la base de datos
            DAOReservas daoReservas = new DAOReservasImpl();
            daoReservas.insertReserva(newReserva);

            // Actualiza la vista de la tabla en el controlador principal
            if (reservasViewController != null) {
                reservasViewController.updateTableView();
            }

            // Proporciona retroalimentación al usuario
            labelCorrect.setText("Reserva agregada exitosamente.");

            // Limpiar los campos
            idField.clear();
            telefonoField.clear();
            fechaEntradaField.clear();
            fechaSalidaField.clear();

            // Cierra la ventana actual si se agregó exitosamente
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

    private boolean isValidDate(String dateStr) {
        // Método para validar la fecha en formato YYYY-MM-DD
        try {
            LocalDate.parse(dateStr);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
