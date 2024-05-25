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

    @FXML
    private TableColumn<Hotel, Integer> columnIdAlojamientos;
    @FXML
    private TableColumn<Hotel, String> columnTipoHabitacion;
    @FXML
    private TableColumn<Hotel, Integer> columnNumeroEstrellas;
    @FXML
    private TableColumn<Hotel, String> columnNombre;
    @FXML
    private Button backButton;

    @FXML
    private Button buttonAdd;

    @FXML
    private TableView<Hotel> tableView;

    private ObservableList<Hotel> hotelData;

    @FXML
    public void initialize() {
        columnIdAlojamientos.setCellValueFactory(new PropertyValueFactory<>("idAlojamiento"));
        columnTipoHabitacion.setCellValueFactory(new PropertyValueFactory<>("tipoHabitacion"));
        columnNumeroEstrellas.setCellValueFactory(new PropertyValueFactory<>("numeroEstrellas"));
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        updateTableView();
    }

    public void updateTableView() {
        HotelDAO hotelDAO;
        try {
            hotelDAO = new HotelDAOImpl();
            List<Hotel> hotels = hotelDAO.getHotel();
            hotelData = FXCollections.observableArrayList(hotels);
            tableView.setItems(hotelData);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void back(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ventana-view.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void buttonAdd(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddHoteles-view.fxml"));
        Parent root = fxmlLoader.load();
        AddHotelesView addHotelesView = fxmlLoader.getController();
        addHotelesView.setHotelesViewController(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Añadir Hotel");
        stage.show();
    }
    @FXML
    public void buttonRemove(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RemoveHotel-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Eliminar Hotel");
        stage.show();
    }
}



