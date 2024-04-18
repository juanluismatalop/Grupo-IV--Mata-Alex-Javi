package org.example.demo.model;

import org.example.demo.model.daoUsuario.Usuario;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDB {

    private Connection connection;

    public UsuarioDB() throws SQLException, IOException {
        connection = SetUpConnection.getInstance().getConnection();;
    }

    public boolean insertUsuario (Usuario usuario) throws SQLException {
        String sql = " INSERT INTO usuario VALUES ('" + usuario.getTelefono() + "', '"
                + usuario.getEmail() + "'," + usuario.getContrasenna() + "', '"
                + usuario.getNOMBRE_COMPLETO() + "', " + usuario.getDireccion() + " );";

        System.out.printf("SENTENCIA A EJECUTAR: %s%n", sql);
        Statement statement = connection.createStatement();
        int result = statement.executeUpdate(sql);
        return result != 0;
    }

    public boolean deleteUsuario (int Telefono) throws SQLException {
        String sql = "DELETE FROM usuario WHERE Telefono = '" + Telefono + "';";

        System.out.printf("SENTENCIA A EJECUTAR: %s%n", sql);
        Statement statement = connection.createStatement();
        int result = statement.executeUpdate(sql);
        return result != 0;
    }



}
