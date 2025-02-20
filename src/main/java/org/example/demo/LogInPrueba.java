package org.example.demo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.demo.model.dao.daoUsuario.UsuarioDAO;
import org.example.demo.model.dao.daoUsuario.UsuarioDAOImpl;

import java.io.IOException;
import java.sql.SQLException;

public class LogInPrueba {
    //implementacion de UsuarioDao
    private UsuarioDAOImpl usuarioDaoImp = new UsuarioDAOImpl();
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField textPassword, textLogin;
    @FXML
    private Label labelUserError;
    @FXML
    private Button buttonSubmit;
    @FXML
    private Button buttonRegister;

    public LogInPrueba() throws SQLException, IOException {
    }

    @FXML
    public void onClick(ActionEvent actionEvent) throws IOException, SQLException {
        System.out.println("pulsado boton");
        String nombreCompleto = textLogin.getText();
        String contrasenna = textPassword.getText();
        System.out.println(nombreCompleto + "--" + contrasenna);
        //hacer que se loguee siendo un usuario

        if (comprobarUsuarioYContrasenna(nombreCompleto, contrasenna) == true) {
            System.out.println("Cambiamos de ventana");
            stage = (Stage) buttonSubmit.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("ventana-view.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else{
            labelUserError.setText("Usuario incorrecto");

        }
    }
    //crear clase que nos recorra todos los usuarios con usuarioDao.getUsuario() y que lo compare
    // con el usuario y contrasenna introducidos para iniciar sesion;
    private static boolean comprobarUsuarioYContrasenna(String nombreCompleto, String contrasenna) throws SQLException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        System.out.println(usuarioDAO.getUsuarioByNombreANDContrasenna(nombreCompleto, contrasenna));
        if(usuarioDAO.getUsuarioByNombreANDContrasenna(nombreCompleto, contrasenna))
            return true;
        else
            return false;

    }

    public void buttonRegis(ActionEvent actionEvent) throws IOException {
        stage = (Stage) buttonRegister.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("registerPrueba.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
