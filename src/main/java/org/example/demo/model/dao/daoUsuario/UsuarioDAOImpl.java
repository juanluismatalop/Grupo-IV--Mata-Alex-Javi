package org.example.demo.model.dao.daoUsuario;

import org.example.demo.model.SetUpConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO{
    private final Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public UsuarioDAOImpl() throws SQLException, IOException {
        connection = SetUpConnection.getInstance().getConnection();
    }
    @Override
    public List<Usuario> getUsuario() throws SQLException {
        List<Usuario> usuario = new ArrayList<>();
        String sql = " SELECT * FROM USUARIO;";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        Usuario usuario1 = null;
        while (resultSet.next()){
            int Telefono = resultSet.getInt("Telefono");
            String Email = resultSet.getString("Email");
            String Contrasenna = resultSet.getString("Contrasenna");
            String NOMBRE_COMPLETO = resultSet.getString("NOMBRE_COMPLETO");
            String Direccion = resultSet.getString("Direccion");
            usuario1 = new Usuario(Telefono, Email, Contrasenna, NOMBRE_COMPLETO, Direccion);
            usuario.add(usuario1);
        }
        return usuario;
    }

    @Override
    public Usuario getUsuarioByTelefono(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM USUSARIO WHERE Telefono = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,usuario.getTelefono());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int Telefono = resultSet.getInt("Telefono");
            String Email = resultSet.getString("Email");
            String Contrasenna = resultSet.getString("Contrasenna");
            String NOMBRE_COMPLETO = resultSet.getString("NOMBRE_COMPLETO");
            String Direccion = resultSet.getString("Direccion");
            usuario = new Usuario(Telefono, Email, Contrasenna, NOMBRE_COMPLETO, Direccion);
        }
        return usuario;
    }

    @Override
    public boolean insertUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO AP_TURISTICOS (Telefono, Email, Contrasenna, NOMBRE_COMPLETO, Direccion) VALUES (?, ?, ?, ?, ?);";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, usuario.getTelefono());
        preparedStatement.setString(2, usuario.getEmail());
        preparedStatement.setString(3, usuario.getContrasenna());
        preparedStatement.setString(4, usuario.getNOMBRE_COMPLETO());
        preparedStatement.setString(5, usuario.getDireccion());
        int rowsInserted = preparedStatement.executeUpdate();
        return rowsInserted > 0;
    }

    @Override
    public boolean deleteUsuarioByTelefono(int telefono) throws SQLException {
        String sql = "DELETE FROM USUARIO WHERE Telefono = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, telefono);
        int rowsDeleted = preparedStatement.executeUpdate();
        return rowsDeleted > 0;
    }

    @Override
    public boolean updateUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE USUARIO SET Telefono = ?, Email = ?, Contrasenna = ?, NOMBRE_COMPLETO = ?, Direccion = ? WHERE Telefono = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, usuario.getTelefono());
        preparedStatement.setString(2, usuario.getEmail());
        preparedStatement.setString(3, usuario.getContrasenna());
        preparedStatement.setString(4, usuario.getNOMBRE_COMPLETO());
        preparedStatement.setString(5, usuario.getDireccion());
        int rowsUpdated = preparedStatement.executeUpdate();
        return rowsUpdated > 0;
    }
}
