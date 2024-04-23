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
        String sql = " INSERT INTO USUARIO VALUES(" + usuario.getTelefono() +" ," + usuario.getEmail() + " ," + usuario.getContrasenna() + " ," + usuario.getNOMBRE_COMPLETO() + " ," + usuario.getDireccion() + ");";
        Statement statement = connection.createStatement();
        int result = statement.executeUpdate(sql);
        return result != 0;
    }

    @Override
    public boolean deleteUsuarioByTelefono(int telefono) throws SQLException {
        String sql = "DELETE FROM USUARIO WHERE Telefono = " + telefono +";";
        Statement statement = connection.createStatement();
        int result = statement.executeUpdate(sql);
        return  result != 0;
    }

    @Override
    public boolean updateUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE USUARIO SET " + usuario.getEmail() + ", " + usuario.getContrasenna() + ", " + usuario.getNOMBRE_COMPLETO() +", " + usuario.getDireccion() + " WHERE Telefono = " + usuario.getTelefono() + ";";
        Statement statement = connection.createStatement();
        int result = statement.executeUpdate(sql);
        return  result != 0;
    }
}
