package org.example.demo.model;

import org.example.demo.model.dao.daoUsuario.Usuario;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDB {

//    private Connection connection;
//
//    public UsuarioDB() throws SQLException, IOException {
//        connection = SetUpConnection.getInstance().getConnection();
//    }
//
//    //Añadir personas
//
//    public boolean insertUsuario(Usuario usuario) throws SQLException {
//        String sql = " INSERT INTO usuario VALUES ('" + usuario.getTelefono() + "', '"
//                + usuario.getEmail() + "','" + usuario.getContrasenna() + "', '"
//                + usuario.getNOMBRE_COMPLETO() + "', '" + usuario.getDireccion() + "' );";
//
//        System.out.printf("SENTENCIA A EJECUTAR: %s%n", sql);
//        Statement statement = connection.createStatement();
//        int result = statement.executeUpdate(sql);
//        return result != 0;
//    }
//
//    //Borrar personas
//
//    public boolean deleteUsuario(int Telefono) throws SQLException {
//        String sql = "DELETE FROM usuario WHERE Telefono = '" + Telefono + "';";
//
//        System.out.printf("SENTENCIA A EJECUTAR: %s%n", sql);
//        Statement statement = connection.createStatement();
//        int result = statement.executeUpdate(sql);
//        return result != 0;
//    }
//
//
//    public boolean updateUsuarioPorTelefono (Usuario usuario) throws SQLException {
//        String sql = "UPDATE usuario SET email = ?, direccion = ?, contrasenna = ?, nombre = ? WHERE telefono = ? ;";
//
//        try (PreparedStatement statement = connection.prepareStatement(sql)){
//
//            statement.setString(1, usuario.getEmail());
//            statement.setString(2, usuario.getDireccion());
//            statement.setString(3, usuario.getContrasenna());
//            statement.setString(4, usuario.getNOMBRE_COMPLETO());
//            statement.setInt(5, usuario.getTelefono());
//
//            int result = statement.executeUpdate(sql);
//            return result != 0;
//
//        } catch (SQLException e) {
//            e.printStackTrace(); // Manejo del error
//            return false; // Retornamos false en caso de error
//        }
//
//    }
//
//    public List<Usuario> getUsuarios() throws SQLException {
//        List<Usuario> usuarios = new ArrayList<>();
//        String sql = "SELECT * FROM mobile ;";
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//        Usuario usuario = null;
//        while (resultSet.next()) {
//            int Telefono = resultSet.getInt("Telefono");
//            String email = resultSet.getString("Email");
//            String contrasenna = resultSet.getString("Contrasenna");
//            String NOMBRE_COMPLETO = resultSet.getString("NOMBRE_COMPLETO");
//            String direccion = resultSet.getString("Direccion");
//
//            usuario = new Usuario(Telefono, email, contrasenna, NOMBRE_COMPLETO, direccion);
//            usuarios.add(usuario);
//        }
//        return usuarios;
//
//    }
//
//    public Usuario getMobileByTelefonoEnhaced (int Telefono) throws SQLException {
//        String sql = "SELECT * FROM usuario WHERE Telefono = ?;";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setInt(1, Telefono);
//        ResultSet resultSet =  statement.executeQuery();
//        Usuario usuario = null;
//        while (resultSet.next()) {
//            String email = resultSet.getString("Email");
//            System.out.println(email);
//            String contrasenna = resultSet.getString("Contrasenna");
//            String NOMBRE_COMPLETO = resultSet.getString("NOMBRE_COMPLETO");
//            String direccion = resultSet.getString("Direccion");
//
//            usuario = new Usuario(Telefono, email, contrasenna, NOMBRE_COMPLETO, direccion);
//
//        }
//        return usuario;
//    }

}
