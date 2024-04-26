package org.example.demo.model.dao.daoReservas;

import java.sql.SQLException;
import java.util.List;

public interface DAOReservas {
    List<Reservas> getReservaPorTelefonoEId() throws SQLException;
    Reservas getReservaPorTelefonoEId(Reservas reserva) throws SQLException;

    boolean insertReserva(Reservas reserva) throws SQLException;
    boolean deleteReservaPorTelefonoEIdAlojamiento(int telefono, int id_alojamiento) throws SQLException;
    boolean updateReserva(Reservas reserva) throws SQLException;
}
