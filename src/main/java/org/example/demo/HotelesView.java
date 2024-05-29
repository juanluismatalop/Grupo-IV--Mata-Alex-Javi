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



public class HotelesView {
    public Button backButton;
    public Button buttonRemove;
    @FXML
    private TableView<Hotel> tableView;

    @FXML
    private TableColumn<Hotel, Integer> columnIdAlojamientos;

    @FXML
    private TableColumn<Hotel, String> columnTipoHabitacion;

    @FXML
    private TableColumn<Hotel, Integer> columnNumeroEstrellas;

    @FXML
    private TableColumn<Hotel, String> columnNombre;

    private HotelDAO hotelDAO;
    public Button buttonAdd;

    public void initialize() {
        try {
            hotelDAO = new HotelDAOImpl();
        } catch (SQLException e) {
            System.out.println("Hay un error");;
        } catch (IOException e) {
            System.out.println("Hay un error");;
        }
        columnIdAlojamientos.setCellValueFactory(new PropertyValueFactory<>("idAlojamiento"));
        columnTipoHabitacion.setCellValueFactory(new PropertyValueFactory<>("tipoHabitacion"));
        columnNumeroEstrellas.setCellValueFactory(new PropertyValueFactory<>("numeroEstrellas"));
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        loadHotels();
    }

    private void loadHotels() {
        try {
            ObservableList<Hotel> hoteles = FXCollections.observableArrayList(hotelDAO.getHotel());
            tableView.setItems(hoteles);
        } catch (SQLException e) {
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
        Stage primaryStage = (Stage) backButton.getScene().getWindow();
        stage.initOwner(primaryStage);
        primaryStage.setOnCloseRequest(event -> stage.close());
        stage.show();
    }

    @FXML
    public void buttonRemove(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RemoveHotel-view.fxml"));
        Parent root = fxmlLoader.load();
        RemoveHotel removeHotel = fxmlLoader.getController();
        removeHotel.setHotelesViewController(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Añadir Hotel");
        Stage primaryStage = (Stage) backButton.getScene().getWindow();
        stage.initOwner(primaryStage);
        primaryStage.setOnCloseRequest(event -> stage.close());
        stage.show();
    }

}




