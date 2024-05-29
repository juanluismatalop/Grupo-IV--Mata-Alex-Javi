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
import org.example.demo.model.dao.daoUsuario.Usuario;
import org.example.demo.model.dao.daoUsuario.UsuarioDAO;
import org.example.demo.model.dao.daoUsuario.UsuarioDAOImpl;

import java.io.IOException;
import java.sql.SQLException;

public class ClientesView {

    public Button backButton;
    public Button buttonRemove;
    @FXML
    private TableView<Usuario> tableView;

    @FXML
    private TableColumn<Usuario, Integer> columnTelefono;

    @FXML
    private TableColumn<Usuario, String> columnEmail;

    @FXML
    private TableColumn<Usuario, String> columnContrasenna;

    @FXML
    private TableColumn<Usuario, String> columnNombre;

    @FXML
    private TableColumn<Usuario, String> columnDireccion;

    @FXML
    private TableColumn<Usuario, String> columnFuncion;

    private UsuarioDAO usuarioDAO;
    public Button buttonAdd;

    public void initialize() {
        try {
            usuarioDAO = new UsuarioDAOImpl();
        } catch (SQLException e) {
            System.out.println("Hay un error");;
        } catch (IOException e) {
            System.out.println("Hay un error");;
        }
        columnTelefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnContrasenna.setCellValueFactory(new PropertyValueFactory<>("contrasenna"));
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("NOMBRE_COMPLETO"));
        columnDireccion.setCellValueFactory(new PropertyValueFactory<>("Direccion"));
        columnFuncion.setCellValueFactory(new PropertyValueFactory<>("Funcion"));
        loadUsuarios();
    }

    private void loadUsuarios() {
        try {
            ObservableList<Usuario> usuarios = FXCollections.observableArrayList(usuarioDAO.getUsuario());
            tableView.setItems(usuarios);
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddClientesView.fxml"));
        Parent root = fxmlLoader.load();
        AddClientesView addClientesView = fxmlLoader.getController();
        addClientesView.setClientesViewController(this);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Añadir Cliente");
        Stage primaryStage = (Stage) backButton.getScene().getWindow();
        stage.initOwner(primaryStage);
        primaryStage.setOnCloseRequest(event -> stage.close());
        stage.show();
    }

    @FXML
    public void buttonRemove(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RemoveClientes-view.fxml"));
        Parent root = fxmlLoader.load();
        RemoveCliente removeCliente = fxmlLoader.getController();
        removeCliente.setClientesViewController(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Borrar Usuario");
        Stage primaryStage = (Stage) backButton.getScene().getWindow();
        stage.initOwner(primaryStage);
        primaryStage.setOnCloseRequest(event -> stage.close());
        stage.show();
    }
}
