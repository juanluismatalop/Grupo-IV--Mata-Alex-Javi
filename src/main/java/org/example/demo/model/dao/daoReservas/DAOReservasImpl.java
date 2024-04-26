package org.example.demo.model.dao.daoReservas;

import org.example.demo.model.SetUpConnection;
import org.example.demo.model.dao.daoApartamento.Apartamento;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAOReservasImpl implements DAOReservas {
    private final Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public DAOReservasImpl() throws SQLException, IOException {
        connection = SetUpConnection.getInstance().getConnection();
    }

    @Override
    public List<Reservas> getReservaPorTelefonoEId() throws SQLException {
        List<Reservas> reservas = new ArrayList<>();
        String sql = "SELECT * FROM RESERVAS;";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int Id_Alojamiento = resultSet.getInt("Id_Alojamiento");
            int Telefono = resultSet.getInt("Telefono");
            String Fecha_Entrada = resultSet.getString("Fecha_Entrada");
            String Fecha_Salida = resultSet.getString("Fecha_Salida");
            Reservas reserva = new Reservas(Id_Alojamiento, Telefono, Fecha_Entrada, Fecha_Salida);
            reservas.add(reserva);
        }
        return reservas;
    }

    @Override
    public Reservas getReservaPorTelefonoEId(Reservas reservas) throws SQLException {
        String sql = "SELECT * FROM RESERVAS WHERE Id_Alojamiento = ? AND Telefono = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, reservas.getId_alojamiento());
        preparedStatement.setInt(2, reservas.getTelefono());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int Id_Alojamiento = resultSet.getInt("Id_Alojamiento");
            int Telefono = resultSet.getInt("Telefono");
            String Fecha_Entrada = resultSet.getString("Fecha_Entrada");
            String Fecha_Salida = resultSet.getString("Fecha_Salida");
            reservas = new Reservas(Id_Alojamiento, Telefono, Fecha_Entrada, Fecha_Salida);
        }
        return reservas;
    }

    @Override
    public boolean insertReserva(Reservas reserva) throws SQLException {
        String sql = "INSERT INTO RESERVAS (Id_Alojamientos, Telefono, Fecha_Entrada, Fecha_Sañida) VALUES (?, ?, ?, ?);";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, reserva.getId_alojamiento());
        preparedStatement.setInt(2, reserva.getTelefono());
        preparedStatement.setString(3, reserva.getFechaEntrada());
        preparedStatement.setString(4, reserva.getFechaSalida());
        int rowsInserted = preparedStatement.executeUpdate();
        return rowsInserted > 0;
    }

    @Override
    public boolean deleteReservaPorTelefonoEIdAlojamiento(int telefono, int id_alojamiento) throws SQLException {
        String sql = "DELETE FROM RESERVAS WHERE Id_Alojamiento = ? AND Telefono = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id_alojamiento);
        preparedStatement.setInt(2, telefono);
        int rowsDeleted = preparedStatement.executeUpdate();
        return rowsDeleted > 0;
    }

    @Override
    public boolean updateReserva(Reservas reserva) throws SQLException {
        String sql = "UPDATE RESERVAS SET Id_Alojamiento = ?, Telefono = ?, Fecha_Entrada = ?, Fecha_Salida = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, reserva.getId_alojamiento());
        preparedStatement.setInt(2, reserva.getTelefono());
        preparedStatement.setString(3, reserva.getFechaEntrada());
        preparedStatement.setString(4, reserva.getFechaSalida());
        int rowsUpdated = preparedStatement.executeUpdate();
        return rowsUpdated > 0;
    }
}
