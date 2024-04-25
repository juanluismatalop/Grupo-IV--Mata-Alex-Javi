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
        Hotel hotel1 = null;
        while (resultSet.next()) {
            int id_alojamiento = resultSet.getInt("Id_Alojamiento");
            String tipo_habitacion = resultSet.getString("Tipo_habitacion");
            String nombre = resultSet.getString("Nombre");
            int numero_estrellas = resultSet.getInt("Numero_Estrellas");
            hotel1 = new Hotel(id_alojamiento, tipo_habitacion, nombre, numero_estrellas);
            hoteles.add(hotel1);
        }
        return hoteles;
    }

    @Override
    public Hotel getHotelByID(Hotel hotel) throws SQLException {
        String sql = "SELECT * FROM HOTELES WHERE Id_Alojamiento = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,hotel.getId_Alojamiento());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id_alojamiento = resultSet.getInt("Id_Alojamiento");
            String tipo_habitacion = resultSet.getString("Tipo_habitacion");
            String nombre = resultSet.getString("Nombre");
            int numero_estrellas = resultSet.getInt("Numero_Estrellas");
            hotel = new Hotel(id_alojamiento, tipo_habitacion, nombre, numero_estrellas);
        }
        return hotel;
    }

    @Override
    public boolean insertHotel(Hotel hotel) throws SQLException {
        String sql = "INSERT INTO HOTELES VALUES(?, ?, ?, ?);";
        preparedStatement = connection.prepareStatement(sql);

        return false;
    }

    @Override
    public boolean deleteHotelById(int Id_Alojamiento) throws SQLException {
        return false;
    }

    @Override
    public boolean updateHotel(Hotel hotel) throws SQLException {
        return false;
    }
}
