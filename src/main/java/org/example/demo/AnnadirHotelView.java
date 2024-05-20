package org.example.demo;

import org.example.demo.model.dao.daoHotel.HotelDAO;
import org.example.demo.model.dao.daoHotel.HotelDAOImpl;

import java.io.IOException;
import java.sql.SQLException;

public class AnnadirHotelView {
    private HotelDAO hotelDAO = new HotelDAOImpl();


    public AnnadirHotelView() throws SQLException, IOException {

        //hotelDAO.insertHotel()
    }
}
