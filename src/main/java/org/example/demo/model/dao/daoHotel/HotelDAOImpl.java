package org.example.demo.model.dao.daoHotel;

import org.example.demo.model.SetUpConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
        return List.of();
    }

    @Override
    public Hotel getHotelByID(Hotel hotel) throws SQLException {
        return null;
    }

    @Override
    public boolean insertHote(Hotel hotel) throws SQLException {
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
