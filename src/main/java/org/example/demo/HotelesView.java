package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class HotelesView {
    public Button backButton;
    public Button buttonRemove;
    public TableColumn columnIdAlojamientos;
    public TableColumn columnTipoHabitacion;
    public TableColumn columnNumeroEstrellas;
    public TableColumn columnNombre;
    public Button buttonAdd;
    public TableView tableView;
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RemoveHoteles-view.fxml"));
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

}




