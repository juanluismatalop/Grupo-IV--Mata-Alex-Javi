package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.demo.model.dao.daoApartamento.Apartamento;
import org.example.demo.model.dao.daoApartamento.ApartamentoDAO;
import org.example.demo.model.dao.daoApartamento.ApartamentoDAOImpl;

import java.io.IOException;
import java.sql.SQLException;


public class AddApartamentoView {
    @FXML
    private Label labelError;
    @FXML
    private Label labelCorrect;
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField distanciaField;
    @FXML
    private Button addButton;

    private ApartamentosTuristicosView apartamentosViewController;

    public void setApartamentosViewController(ApartamentosTuristicosView apartamentosViewController) {
        this.apartamentosViewController = apartamentosViewController;
    }


    @FXML
    public void add() {

        labelError.setText("");
        labelCorrect.setText("");

        try {
            int id = Integer.parseInt(idField.getText());
            String nombre = nameField.getText().trim();
            double distanciaCentroKm = Double.valueOf(distanciaField.getText());

            // Validar los campos de entrada
            if (nombre.isEmpty()) {
                labelError.setText("Por favor, completa todos los campos.");
                return;
            }

            if (distanciaCentroKm <= 0 ) {
                labelError.setText("La distancia al centro debe ser un número positivo.");
                return;
            }


            // Crea un nuevo objeto Apartamento
            Apartamento newApartamento = new Apartamento(id, nombre, distanciaCentroKm);

            // Inserta el nuevo Apartamento en la base de datos
            ApartamentoDAO apartamentoDAO = new ApartamentoDAOImpl();
            apartamentoDAO.insertApartamento(newApartamento);

            // Actualiza la vista de la tabla en el controlador principal
            if (apartamentosViewController != null) {
                //apartamentosViewController.updateTableView();
            }

            // Proporciona retroalimentación al usuario
            labelCorrect.setText("Apartamento turisticos agregado exitosamente.");

            // Cierra la ventana actual si se agregó exitosamente
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();
        } catch (NumberFormatException e) {
            labelError.setText("Formato de ID inválido.");
        } catch (SQLException e) {
            labelError.setText("Error de base de datos: " + e.getMessage());
        } catch (IOException e) {
            labelError.setText("Error de IO: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}