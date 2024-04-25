package org.example.demo.model.dao.daoReservas;

import org.example.demo.model.SetUpConnection;
import org.example.demo.model.dao.daoApartamento.Apartamento;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DAOReservasImpl implements DAOReservas {
    private final Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public DAOReservasImpl() throws SQLException, IOException {
        connection = SetUpConnection.getInstance().getConnection();
    }

    @Override
    public List<Apartamento> getReserva() throws SQLException {
        return null;
    }

    @Override
    public Apartamento getReserva(Apartamento apartamento) throws SQLException {
        return null;
    }

    @Override
    public boolean insertReserva(Apartamento apartamento) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteReservaPorTelefonoEIdAlojamiento(int telefono, int id_alojamiento) throws SQLException {
        return false;
    }

    @Override
    public boolean updateReserva(Apartamento apartamento) throws SQLException {
        return false;
    }
}
