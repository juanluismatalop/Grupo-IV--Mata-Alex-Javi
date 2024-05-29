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

import org.example.demo.model.dao.daoReservas.DAOReservas;
import org.example.demo.model.dao.daoReservas.DAOReservasImpl;
import org.example.demo.model.dao.daoReservas.Reservas;

import java.io.IOException;
import java.sql.SQLException;

public class ReservasView {

    public Button backButton;
    public Button buttonRemove;
    @FXML
    private TableView<Reservas> tableView;
    @FXML
    private TableColumn<Reservas, Integer> columnIdAlojamientos;
    @FXML
    private TableColumn<Reservas, Integer> columnTelefono;
    @FXML
    private TableColumn<Reservas, String> columnFechaEntrada;
    @FXML
    private TableColumn<Reservas, String> columnFechaSalida;

    private DAOReservas daoReservas;
    public Button buttonAdd;

    public void initialize() {
        try {
            daoReservas = new DAOReservasImpl();
        } catch (SQLException e) {
            System.out.println("Hay un error");;
        } catch (IOException e) {
            System.out.println("Hay un error");;
        }
        columnIdAlojamientos.setCellValueFactory(new PropertyValueFactory<>("idAlojamiento"));
        columnTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        columnFechaEntrada.setCellValueFactory(new PropertyValueFactory<>("fechaEntrada"));
        columnFechaSalida.setCellValueFactory(new PropertyValueFactory<>("fechaSalida"));
        loadReservas();
    }

    private void loadReservas() {
        try {
            ObservableList<Reservas> reservas = FXCollections.observableArrayList(daoReservas.getReserva());
            tableView.setItems(reservas);
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddReservas-view.fxml"));
        Parent root = fxmlLoader.load();
        AddReservasView addReservasView = fxmlLoader.getController();
        addReservasView.setReservasViewController(this);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Añadir Reserva");
        Stage primaryStage = (Stage) backButton.getScene().getWindow();
        stage.initOwner(primaryStage);
        primaryStage.setOnCloseRequest(event -> stage.close());
        stage.show();
    }
    @FXML
    public void buttonRemove(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RemoveReservas-view.fxml"));
        Parent root = fxmlLoader.load();
        RemoveReservasView removeReservasView = fxmlLoader.getController();
        removeReservasView.setReservasViewController(this);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Añadir Reserva");
        Stage primaryStage = (Stage) backButton.getScene().getWindow();
        stage.initOwner(primaryStage);
        primaryStage.setOnCloseRequest(event -> stage.close());
        stage.show();
    }

    public void updateTableView() {
        loadReservas();
    }
}
