module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.xerial.sqlitejdbc;


    opens org.example.demo to javafx.fxml;
    exports org.example.demo;
}