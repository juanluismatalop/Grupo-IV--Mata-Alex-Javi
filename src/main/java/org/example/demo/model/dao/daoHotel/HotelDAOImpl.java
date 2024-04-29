package org.example.demo.model.dao.daoHotel;

import org.example.demo.model.SetUpConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAOImpl implements HotelDAO {
    private final Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public HotelDAOImpl() throws SQLException, IOException {
        connection = SetUpConnection.getInstance().getConnection();
    }

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

    @Override
    public boolean insertHotel(Hotel hotel) throws SQLException {
        return false;
    }


    public boolean insertHote(Hotel hotel) throws SQLException {
        String sql = "INSERT INTO HOTELES (Id_Alojamiento, Tipo_Habitacion, Nombre, Numero_Estrellas) VALUES (?, ?, ?,?);";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, hotel.getId_Alojamiento());
        preparedStatement.setString(2, hotel.getTipo_habitacion());
        preparedStatement.setString(3, hotel.getNombre());
        preparedStatement.setInt(4,hotel.getNumeroEstrellas());
        int rowsInserted = preparedStatement.executeUpdate();
        return rowsInserted > 0;
    }

    @Override
    public boolean deleteHotelById(int Id_Alojamiento) throws SQLException {
        String sql = "DELETE FROM HOTELES WHERE Id_Alojamiento = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, Id_Alojamiento);
        int rowsDeleted = preparedStatement.executeUpdate();
        return rowsDeleted > 0;
    }

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
