package org.example.demo.model.dao.daoUsuario;

import org.example.demo.model.SetUpConnection;
import org.example.demo.model.dao.daoReservas.DAOReservas;
import org.example.demo.model.dao.daoReservas.DAOReservasImpl;
import org.example.demo.model.dao.daoReservas.Reservas;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Juan Luis Mata
 * @version 1.0
 * @since 1.0
 */
public class UsuarioDAOImpl implements UsuarioDAO{
    private final Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    /**
     * constructor para implementar el coneection
     * @throws SQLException
     * @throws IOException
     */

    public UsuarioDAOImpl() throws SQLException, IOException {
        connection = SetUpConnection.getInstance().getConnection();
    }

    /**
     * metodo que lista los usuarios
     * @return
     * @throws SQLException
     */
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
            String Funcion = resultSet.getString("Funcion");
            usuario1 = new Usuario(Telefono, Email, Contrasenna, NOMBRE_COMPLETO, Direccion, Funcion);
            usuario.add(usuario1);
        }
        return usuario;
    }
    /**
     * metodo que te devuelve un usuario
     * @param usuario
     * @return
     * @throws SQLException
     */
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
            String Funcion = resultSet.getString("Funcion");
            usuario = new Usuario(Telefono, Email, Contrasenna, NOMBRE_COMPLETO, Direccion, Funcion);
        }
        return usuario;
    }
    /**
     * metodo para insertar un usuario
     * @param usuario
     * @return
     * @throws SQLException
     */
    @Override
    public boolean insertUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO USUARIO (Telefono, Email, Contrasenna, NOMBRE_COMPLETO, Direccion, Funcion) VALUES (?, ?, ?, ?, ?, ?);";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, usuario.getTelefono());
        preparedStatement.setString(2, usuario.getEmail());
        preparedStatement.setString(3, usuario.getContrasenna());
        preparedStatement.setString(4, usuario.getNOMBRE_COMPLETO());
        preparedStatement.setString(5, usuario.getDireccion());
        preparedStatement.setString(6, usuario.getFuncion());
        int rowsInserted = preparedStatement.executeUpdate();
        return rowsInserted > 0;
    }
    /**
     * metodo para borrar usuarios con el valor movil
     * @param telefono
     * @return
     * @throws SQLException
     */
    @Override
    public boolean deleteUsuarioByTelefono(int telefono) throws SQLException {
        String sql = "DELETE FROM USUARIO WHERE Telefono = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, telefono);
        int rowsDeleted = preparedStatement.executeUpdate();
        return rowsDeleted > 0;
    }
    /**
     * metodo para actualizar usuario
     * @param usuario
     * @return
     * @throws SQLException
     */
    @Override
    public boolean updateUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE USUARIO SET Telefono = ?, Email = ?, Contrasenna = ?, NOMBRE_COMPLETO = ?, Direccion = ?, Funcion = ? WHERE Telefono = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, usuario.getTelefono());
        preparedStatement.setString(2, usuario.getEmail());
        preparedStatement.setString(3, usuario.getContrasenna());
        preparedStatement.setString(4, usuario.getNOMBRE_COMPLETO());
        preparedStatement.setString(5, usuario.getDireccion());
        int rowsUpdated = preparedStatement.executeUpdate();
        return rowsUpdated > 0;
    }
    /**
     * Metodo que te da un usuario introduciendo tu su nombre y contrasenna
     * @param nombreCompleto
     * @param contrasenna
     * @return
     * @throws SQLException
     */
    @Override
    public boolean getUsuarioByNombreANDContrasenna(String nombreCompleto, String contrasenna) throws SQLException {
        Usuario usuario = null;
        String sql = "SELECT * FROM USUARIO WHERE NOMBRE_COMPLETO = ? AND Contrasenna = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, nombreCompleto);
        preparedStatement.setString(2, contrasenna);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){

            int Telefono = resultSet.getInt("Telefono");
            String Email = resultSet.getString("Email");
            String Direccion = resultSet.getString("Direccion");
            String Funcion = resultSet.getString("Funcion");
            usuario = new Usuario(Telefono, Email, contrasenna, nombreCompleto, Direccion, Funcion);
            return true;

        }
        return false;
    }

    @Override
    public List<Usuario> getUsuariosFuncionClientes() throws SQLException {
        List<Usuario> usuario = new ArrayList<>();
        String sql = " SELECT * FROM USUARIO WHERE Funcion = 'Clientes';";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        Usuario usuario1 = null;
        while (resultSet.next()){
            int Telefono = resultSet.getInt("Telefono");
            String Email = resultSet.getString("Email");
            String Contrasenna = resultSet.getString("Contrasenna");
            String NOMBRE_COMPLETO = resultSet.getString("NOMBRE_COMPLETO");
            String Direccion = resultSet.getString("Direccion");
            String Funcion = resultSet.getString("Funcion");
            usuario1 = new Usuario(Telefono, Email, Contrasenna, NOMBRE_COMPLETO, Direccion, Funcion);
            usuario.add(usuario1);
        }
        return usuario;
    }

    public static void main(String[] args) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
            Usuario usuario;
            System.out.println("se muestras los usuarios");
            System.out.println(usuarioDAO.getUsuario());
            System.out.println("añadimos un usuario");
            usuario = new Usuario(678543123, "hola@gmail.com", "Holahola2.", "Pepe", "Jaen", "Administrador");
            usuarioDAO.insertUsuario(usuario);
            System.out.println("Introducido correctamente");
            System.out.println(usuarioDAO.getUsuario());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
