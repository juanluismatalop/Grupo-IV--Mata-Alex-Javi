module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.xerial.sqlitejdbc;

    opens org.example.demo.model.dao.daoHotel to javafx.base;
    opens org.example.demo.model.dao.daoApartamento to javafx.base;
    opens org.example.demo.model.dao.daoReservas to javafx.base;
    opens org.example.demo.model.dao.daoUsuario to javafx.base;

    opens org.example.demo to javafx.fxml;
    exports org.example.demo;
    exports org.example.demo.controller;
    opens org.example.demo.controller to javafx.fxml;
}