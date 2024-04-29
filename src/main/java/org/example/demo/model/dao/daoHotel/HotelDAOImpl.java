package org.example.demo.model.dao.daoHotel;

import org.example.demo.model.SetUpConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz HotelDAO que proporciona métodos para acceder a los datos de los hoteles en la base de datos.
 *
 * @author Alejandro Galán Herrera
 * @since 23/04/2024
 */
public class HotelDAOImpl implements HotelDAO {
    private final Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    /**
     * Constructor de la clase HotelDAOImpl que inicializa la conexión a la base de datos.
     *
     * @throws SQLException Si ocurre un error al establecer la conexión.
     * @throws IOException Si ocurre un error al leer la configuración de la conexión.
     */
    public HotelDAOImpl() throws SQLException, IOException {
        connection = SetUpConnection.getInstance().getConnection();
    }

    /**
     * Obtiene una lista de todos los hoteles en la base de datos.
     *
     * @return Una lista de objetos Hotel.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    @Override
    public List<Hotel> getHotel() throws SQLException {
        List<Hotel> hoteles = new ArrayList<>();
        String sql = "SELECT * FROM HOTELES;";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int Id_Alojamiento = resultSet.getInt("Id_Alojamiento");
            String Tipo_Habitacion = resultSet.getString("Tipo_Habitacion");
            String Nombre = resultSet.getString("Nombre");
            int Numero_Estrellas = resultSet.getInt("Numero_Estrellas");
            Hotel hotel = new Hotel(Id_Alojamiento, Tipo_Habitacion, Nombre, Numero_Estrellas);
            hoteles.add(hotel);
        }
        return hoteles;
    }

    /**
     * Obtiene un hotel por su identificador.
     *
     * @param hotel El objeto Hotel que contiene el ID del hotel a buscar.
     * @return El hotel encontrado, o null si no se encuentra.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    @Override
    public Hotel getHotelByID(Hotel hotel) throws SQLException {
        String sql = "SELECT * FROM HOTELES WHERE Id_Alojamiento = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, hotel.getId_Alojamiento());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            int Id_Alojamiento = resultSet.getInt("Id_Alojamiento");
            String Tipo_Habitacion = resultSet.getString("Tipo_Habitacion");
            String Nombre = resultSet.getString("Nombre");
            int Numero_Estrellas = resultSet.getInt("Numero_Estrellas");
            hotel = new Hotel(Id_Alojamiento, Tipo_Habitacion, Nombre, Numero_Estrellas);
        }
        return hotel;
    }

    /**
     * Inserta un nuevo hotel en la base de datos.
     *
     * @param hotel El objeto Hotel a insertar.
     * @return true si la inserción fue exitosa, false de lo contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    @Override
    public boolean insertHotel(Hotel hotel) throws SQLException {
        String sql = "INSERT INTO HOTELES (Id_Alojamiento, Tipo_Habitacion, Nombre, Numero_Estrellas) VALUES (?, ?, ?,?);";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, hotel.getId_Alojamiento());
        preparedStatement.setString(2, hotel.getTipo_habitacion());
        preparedStatement.setString(3, hotel.getNombre());
        preparedStatement.setInt(4,hotel.getNumeroEstrellas());
        int rowsInserted = preparedStatement.executeUpdate();
        return rowsInserted > 0;
    }

    /**
     * Elimina un hotel por su identificador.
     *
     * @param Id_Alojamiento El ID del hotel a eliminar.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    @Override
    public boolean deleteHotelById(int Id_Alojamiento) throws SQLException {
        String sql = "DELETE FROM HOTELES WHERE Id_Alojamiento = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, Id_Alojamiento);
        int rowsDeleted = preparedStatement.executeUpdate();
        return rowsDeleted > 0;
    }

    /**
     * Actualiza la información de un hotel en la base de datos.
     *
     * @param hotel El objeto Hotel con la información actualizada.
     * @return true si la actualización fue exitosa, false de lo contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    @Override
    public boolean updateHotel(Hotel hotel) throws SQLException {
        String sql = "UPDATE HOTELES SET Nombre = ?, Distancia_Centro_Km = ? WHERE Id_Alojamiento = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, hotel.getId_Alojamiento());
        preparedStatement.setString(2, hotel.getTipo_habitacion());
        preparedStatement.setString(3, hotel.getNombre());
        preparedStatement.setInt(4,hotel.getNumeroEstrellas());
        int rowsUpdated = preparedStatement.executeUpdate();
        return rowsUpdated > 0;
    }
}

