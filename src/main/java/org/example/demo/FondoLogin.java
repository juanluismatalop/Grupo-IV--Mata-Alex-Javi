package org.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FondoLogin extends Application {
        private final Image bgImage = new Image("file:src/main/resources/Imagen/Embalse-del-Tranco.jpg");
        private final StackPane container = new StackPane();

        @Override
        public void start(Stage stage) throws Exception {
            stage.setTitle("Prueba imagen de fondo");
            stage.setMinHeight(240);
            stage.setMinWidth(320);
            ImageView imageView = new ImageView();
            imageView.setImage(bgImage);
            imageView.setFitHeight(240);
            imageView.setFitWidth(320);
            container.getChildren().add(imageView);
        }

    }
