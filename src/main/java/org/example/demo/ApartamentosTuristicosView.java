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

    @FXML
    private TableColumn<Apartamento, Integer> columnIdAlojamientos;
    @FXML
    private TableColumn<Apartamento, String> columnNombre;
    @FXML
    private TableColumn<Apartamento, Double> columnDistanciaCentroKm;
    @FXML
    private Button backButton;

    @FXML
    private Button buttonAdd;

    @FXML
    private TableView<Apartamento> tableView;

    private ObservableList<Apartamento> apartamentoData;

    @FXML
    public void initialize() {
        columnIdAlojamientos.setCellValueFactory(new PropertyValueFactory<>("idAlojamiento"));
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnDistanciaCentroKm.setCellValueFactory(new PropertyValueFactory<>("distanciaCentroKm"));

        updateTableView();
    }

    public void updateTableView() {
        ApartamentoDAO apartamentoDAO;
        try {
            apartamentoDAO = new ApartamentoDAOImpl();
            List<Apartamento> apartamentos = apartamentoDAO.getApartamento();
            apartamentoData = FXCollections.observableArrayList(apartamentos);
            tableView.setItems(apartamentoData);
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddApartamentos-view.fxml"));
        Parent root = fxmlLoader.load();
        AddApartamentoView addApartamentoView = fxmlLoader.getController();
        addApartamentoView.setApartamentosViewController(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Añadir Apartamento");
        stage.show();
    }
    @FXML
    public void buttonRemove(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RemoveApartamentos-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Eliminar Apartamento");
        stage.show();
    }
}
