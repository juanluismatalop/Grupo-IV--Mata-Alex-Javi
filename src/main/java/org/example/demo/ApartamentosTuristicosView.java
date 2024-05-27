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
import org.example.demo.model.dao.daoApartamento.Apartamento;
import org.example.demo.model.dao.daoApartamento.ApartamentoDAO;
import org.example.demo.model.dao.daoApartamento.ApartamentoDAOImpl;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ApartamentosTuristicosView {

    public Button backButton;
    public Button buttonRemove;
    @FXML
    private TableView<Apartamento> tableView;
    @FXML
    private TableColumn<Apartamento, Integer> columnIdAlojamientos;
    @FXML
    private TableColumn<Apartamento, String> columnNombre;
    @FXML
    private TableColumn<Apartamento, Double> columnDistanciaCentroKm;

    private ApartamentoDAO apartamentoDAO;
    public Button buttonAdd;

    public void initialize() {
        try {
            apartamentoDAO = new ApartamentoDAOImpl();
        } catch (SQLException e) {
            System.out.println("Hay un error");;
        } catch (IOException e) {
            System.out.println("Hay un error");;
        }
        columnIdAlojamientos.setCellValueFactory(new PropertyValueFactory<>("idAlojamiento"));
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnDistanciaCentroKm.setCellValueFactory(new PropertyValueFactory<>("distanciaCentroKm"));
        loadApartamentos();
    }

    private void loadApartamentos() {
        try {
            ObservableList<Apartamento> apartamentos = FXCollections.observableArrayList(apartamentoDAO.getApartamento());
            tableView.setItems(apartamentos);
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddApartamentos-view.fxml"));
        Parent root = fxmlLoader.load();
        AddApartamentoView addApartamentoView = fxmlLoader.getController();
        addApartamentoView.setApartamentosViewController(this);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Añadir Apartamento");
        Stage primaryStage = (Stage) backButton.getScene().getWindow();
        stage.initOwner(primaryStage);
        primaryStage.setOnCloseRequest(event -> stage.close());
        stage.show();
    }
    @FXML
    public void buttonRemove(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RemoveApartamentos-view.fxml"));
        Parent root = fxmlLoader.load();
        RemoveApartamentosView removeApartamentosView = fxmlLoader.getController();
        removeApartamentosView.setApartamentosViewController(this);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Añadir Apartamento");
        Stage primaryStage = (Stage) backButton.getScene().getWindow();
        stage.initOwner(primaryStage);
        primaryStage.setOnCloseRequest(event -> stage.close());
        stage.show();
    }
}