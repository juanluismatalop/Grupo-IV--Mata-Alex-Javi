package org.example.demo;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.demo.model.dao.daoHotel.Hotel;
import org.example.demo.model.dao.daoHotel.HotelDAO;
import org.example.demo.model.dao.daoHotel.HotelDAOImpl;

import java.io.IOException;
import java.sql.SQLException;

public class AddHotelesView {

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
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String roomType = roomTypeChoiceBox.getValue();
            int stars = starsChoiceBox.getValue();

            Hotel newHotel = new Hotel(id, name, roomType, stars);
            HotelDAO hotelDAO = new HotelDAOImpl();
            hotelDAO.insertHotel(newHotel);

            hotelesViewController.updateTableView();

            // Close the current window
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
