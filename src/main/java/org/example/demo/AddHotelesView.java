package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.example.demo.model.dao.daoHotel.Hotel;
import org.example.demo.model.dao.daoHotel.HotelDAO;
import org.example.demo.model.dao.daoHotel.HotelDAOImpl;

import java.io.IOException;
import java.sql.SQLException;


public class AddHotelesView {
    @FXML
    private Button addButton;
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private ChoiceBox<String> roomTypeChoiceBox;
    @FXML
    private ChoiceBox<Integer> starsChoiceBox;

    private HotelDAO hotelDAO = new HotelDAOImpl();

    public AddHotelesView() throws SQLException, IOException {
    }

    @FXML
    public void initialize() {
        // Configuración de ChoiceBox para el tipo de habitación
        roomTypeChoiceBox.getItems().addAll("1 persona", "2 personas", "3 personas", "4 personas");

        // Configuración de ChoiceBox para el número de estrellas
        starsChoiceBox.getItems().addAll(1, 2, 3, 4, 5);
    }

    @FXML
    public void add(ActionEvent actionEvent) {
        String idText = idField.getText();
        String name = nameField.getText();
        String roomType = roomTypeChoiceBox.getValue();
        Integer stars = starsChoiceBox.getValue();

        // Verifica si el ID es numérico
        if (!idText.matches("\\d+")) {
            showAlert("El ID debe ser numérico.");
            return;
        }

        // Convierte el ID a un entero
        int id = Integer.parseInt(idText);

        // Crea un objeto Hotel con los datos ingresados
        Hotel hotel = new Hotel(id, name, roomType, stars);

        // Intenta agregar el hotel a la base de datos
        try {
            hotelDAO.insertHotel(hotel);
            showAlert("Hotel agregado exitosamente.");
        } catch (Exception e) {
            showAlert("Error al agregar el hotel: " + e.getMessage());
        }
    }
    // Método auxiliar para mostrar alertas
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
