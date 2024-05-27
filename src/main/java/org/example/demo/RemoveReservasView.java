package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.demo.model.dao.daoHotel.HotelDAO;
import org.example.demo.model.dao.daoHotel.HotelDAOImpl;
import org.example.demo.model.dao.daoReservas.DAOReservas;
import org.example.demo.model.dao.daoReservas.DAOReservasImpl;

import java.io.IOException;
import java.sql.SQLException;

public class RemoveReservasView {

    private ReservasView reservasViewController;
    public void setReservasViewController(ReservasView reservasViewController) {
        this.reservasViewController = reservasViewController;
    }

    @FXML
    private TextField idField;

    @FXML
    private TextField telefonoField;

    @FXML
    public void delete(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(idField.getText());
            int telefono = Integer.parseInt(telefonoField.getText());
            DAOReservas daoReservas = new DAOReservasImpl();
            boolean success = daoReservas.deleteReservaPorTelefonoEIdAlojamiento(id, telefono);

            Alert alert;
            if (success) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setHeaderText(null);
                alert.setContentText("Reserva eliminado correctamente.");
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("No se encontró el Reserva con el ID proporcionado.");
            }

            alert.showAndWait();

            // Close the current window
            Stage stage = (Stage) idField.getScene().getWindow();
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
            alert.setContentText("Error al eliminar el hotel de la base de datos.");
            alert.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}