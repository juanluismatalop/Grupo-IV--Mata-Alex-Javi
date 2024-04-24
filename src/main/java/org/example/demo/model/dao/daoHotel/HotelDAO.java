package org.example.demo.model.dao.daoHotel;


import java.sql.SQLException;
import java.util.List;

public interface HotelDAO {

    List<Hotel> getHotel() throws SQLException;
    Hotel getHotelByID(Hotel hotel) throws SQLException;

    boolean insertHote(Hotel hotel) throws SQLException;
    boolean deleteHotelById(int Id_Alojamiento) throws SQLException;
    boolean updateHotel(Hotel hotel) throws SQLException;

}
