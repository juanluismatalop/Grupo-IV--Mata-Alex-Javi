package org.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.demo.model.dao.daoHotel.Hotel;
import org.example.demo.model.dao.daoHotel.HotelDAO;
import org.example.demo.model.dao.daoHotel.HotelDAOImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class HotelesView {
    //cambios

    @FXML
    private Button backButton;

    @FXML
    private Button buttonAdd;

    @FXML
    private TableView<Hotel> tableView;

    @FXML
    private TableColumn<Hotel, Integer> idColumn;

    @FXML
    private TableColumn<Hotel, String> roomTypeColumn;

    @FXML
    private TableColumn<Hotel, Integer> starsColumn;

    @FXML
    private TableColumn<Hotel, String> nameColumn;

    private Stage stage;
    private Parent root;
    private Scene scene;

    private HotelDAO hotelDAO = new HotelDAOImpl();

    public HotelesView() throws SQLException, IOException {
    }

    @FXML
    public void initialize() {
        // Configurar las columnas del TableView para que muestren los datos apropiadamente
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        roomTypeColumn.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        starsColumn.setCellValueFactory(new PropertyValueFactory<>("stars"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Obtener los datos de la base de datos
        try {
            List<Hotel> hotels = hotelDAO.getHotel();
            // Convertir la lista a un ObservableList
            ObservableList<Hotel> hotelData = FXCollections.observableArrayList(hotels);
            // Mostrar los datos en el TableView
            tableView.setItems(hotelData);
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de errores, por ejemplo, mostrar un mensaje de error al usuario
        }
    }

    @FXML
    public void back(ActionEvent actionEvent) throws IOException {
        stage = (Stage) backButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("ventana-view.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void buttonAdd(ActionEvent actionEvent) throws SQLException, IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddHoteles-view.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setTitle("Añadir Hotel");
        stage.show();
    }
}

