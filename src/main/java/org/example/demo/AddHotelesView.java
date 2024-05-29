package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.demo.model.dao.daoHotel.Hotel;
import org.example.demo.model.dao.daoHotel.HotelDAO;
import org.example.demo.model.dao.daoHotel.HotelDAOImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class AddHotelesView {

    @FXML
    private TextField tipoHabitacion;
    @FXML
    private Label labelError;
    @FXML
    private TextField numeroEstrellas;
    @FXML
    private Label labelCorrect;
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private Button addButton;

    private HotelesView hotelesViewController;

    private final List<String> validRoomTypes = Arrays.asList("Unica", "Doble", "Triple", "Cuadruple");
    private final List<Integer> validStars = Arrays.asList(1, 2, 3, 4, 5);

    public void setHotelesViewController(HotelesView hotelesViewController) {
        this.hotelesViewController = hotelesViewController;
    }

    @FXML
    public void add() {
        labelError.setText("");
        labelCorrect.setText("");
        try {
            int idAlojamiento = Integer.parseInt(idField.getText());
            String nombre = nameField.getText().trim();
            String tipo_habitacion = tipoHabitacion.getText().trim();
            int stars = Integer.parseInt(numeroEstrellas.getText());
            if (nombre.isEmpty() || tipo_habitacion.isEmpty()) {
                labelError.setText("Por favor, completa todos los campos.");
                return;
            }
            if (!validRoomTypes.contains(tipo_habitacion)) {
                labelError.setText("Tipo de habitación inválido. Debe ser 'Unica', 'Doble', 'Triple' o 'Cuadruple'.");
                return;
            }
            if (!validStars.contains(stars)) {
                labelError.setText("Número de estrellas inválido. Debe ser un valor entre 1 y 5.");
                return;
            }
            Hotel newHotel = new Hotel(idAlojamiento, nombre, tipo_habitacion, stars);
            HotelDAO hotelDAO = new HotelDAOImpl();
            hotelDAO.insertHotel(newHotel);
            if (hotelesViewController != null) {
            }
            labelCorrect.setText("Hotel agregado exitosamente.");
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

