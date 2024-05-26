package org.example.demo;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.demo.model.dao.daoApartamento.Apartamento;
import org.example.demo.model.dao.daoApartamento.ApartamentoDAO;
import org.example.demo.model.dao.daoApartamento.ApartamentoDAOImpl;

import java.io.IOException;
import java.sql.SQLException;

public class AddApartamentoView {
    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private Button addButton;

    private ApartamentosTuristicosView apartamentosViewController;

    public void setApartamentosViewController(ApartamentosTuristicosView apartamentosViewController) {
        this.apartamentosViewController = apartamentosViewController;
    }


    @FXML
    public void add() {
        try {
            int id = Integer.parseInt(idField.getText());
            String nombre = nameField.getText();
            double distanciaCentroKm = Double.parseDouble(nameField.getText());

            Apartamento newApartamento = new Apartamento(id, nombre, distanciaCentroKm);
            ApartamentoDAO apartamentoDAO = new ApartamentoDAOImpl();
            apartamentoDAO.insertApartamento(newApartamento);

            apartamentosViewController.updateTableView();

            // Close the current window
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
