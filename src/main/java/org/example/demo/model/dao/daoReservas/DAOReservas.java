package org.example.demo.model.dao.daoReservas;

import org.example.demo.model.dao.daoApartamento.Apartamento;

import java.sql.SQLException;
import java.util.List;

public interface DAOReservas {
    List<Apartamento> getReserva() throws SQLException;
    Apartamento getReserva(Apartamento apartamento) throws SQLException;

    boolean insertReserva(Apartamento apartamento) throws SQLException;
    boolean deleteReservaPorTelefonoEIdAlojamiento(int telefono, int id_alojamiento) throws SQLException;
    boolean updateReserva(Apartamento apartamento) throws SQLException;
}
