package org.example.demo;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.demo.model.dao.daoHotel.Hotel;
import org.example.demo.model.dao.daoHotel.HotelDAO;
import org.example.demo.model.dao.daoHotel.HotelDAOImpl;

import java.io.IOException;
import java.sql.SQLException;

public class AddHotelesView {

    @FXML
    private Label labelCorrect;
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private ChoiceBox<String> roomTypeChoiceBox;
    @FXML
    private ChoiceBox<Integer> starsChoiceBox;
    @FXML
    private Button addButton;

    private HotelesView hotelesViewController;

    @FXML
    public void initialize() {
        roomTypeChoiceBox.setItems(FXCollections.observableArrayList("Unica", "Doble", "Triple", "Cuadruple"));
        starsChoiceBox.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5));
    }

    public void setHotelesViewController(HotelesView hotelesViewController) {
        this.hotelesViewController = hotelesViewController;
    }

    @FXML
    public void add() {
        try {
            // Parse y valida los campos de entrada
            int idAlojamiento = Integer.parseInt(idField.getText());
            String nombre = nameField.getText();
            String tipo_habitacion = roomTypeChoiceBox.getValue();
            Integer stars = starsChoiceBox.getValue();

            if (nombre == null || tipo_habitacion == null || stars == null) {
                labelCorrect.setText("Por favor, completa todos los campos.");
                return;
            }

            // Imprimir los valores seleccionados para depuración
            System.out.println("ID Alojamiento: " + idAlojamiento);
            System.out.println("Nombre: " + nombre);
            System.out.println("Tipo de habitación: " + tipo_habitacion);
            System.out.println("Número de estrellas: " + stars);

            // Crea un nuevo objeto Hotel
            Hotel newHotel = new Hotel(idAlojamiento, nombre, tipo_habitacion, stars);

            // Inserta el nuevo hotel en la base de datos
            HotelDAO hotelDAO = new HotelDAOImpl();
            hotelDAO.insertHotel(newHotel);

            // Actualiza la vista de la tabla en el controlador principal
            if (hotelesViewController != null) {
                //hotelesViewController.updateTableView();
            }

            // Proporciona retroalimentación al usuario
            labelCorrect.setText("Hotel agregado exitosamente.");

            // Cierra la ventana actual
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();

        } catch (NumberFormatException e) {
            labelCorrect.setText("Formato de ID inválido.");
        } catch (SQLException e) {
            // Manejo específico de la violación de la restricción CHECK
            if (e.getMessage().contains("CHECK constraint failed: CK_3")) {
                labelCorrect.setText("Tipo de habitación inválido. Debe ser 'Unica', 'Doble', 'Triple' o 'Cuadruple'.");
            } else if (e.getMessage().contains("CHECK constraint failed: CK_2")) {
                labelCorrect.setText("Número de estrellas inválido. Debe ser un valor entre 1 y 5.");
            } else {
                labelCorrect.setText("Error de base de datos: " + e.getMessage());
            }
        } catch (IOException e) {
            labelCorrect.setText("Error de IO: " + e.getMessage());
        } catch (Exception e) {
            labelCorrect.setText("Ocurrió un error: " + e.getMessage());
        }
    }
}
