package org.example.demo.model.daoUsuario;

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
    public Usuario getUsuarioByTelefono(int telefono) {
        return null;
    }

    @Override
    public boolean insertUsuario(Usuario usuario) {
        return false;
    }

    @Override
    public boolean deleteUsuarioByTelefono(int telefono) {
        return false;
    }

    @Override
    public boolean updateUsuario(Usuario usuario) {
        return false;
    }
}
