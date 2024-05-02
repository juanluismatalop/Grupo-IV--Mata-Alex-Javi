package org.example.demo.model.dao.daoReservas;

import org.example.demo.model.SetUpConnection;
import org.example.demo.model.dao.daoApartamento.Apartamento;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz DAOReservas que proporciona métodos para acceder a los datos de las reservas de alojamiento en la base de datos.
 *
 * @author Alejandro Galán Herrera
 * @since 25/04/2024
 */
public class DAOReservasImpl implements DAOReservas {
    private final Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    /**
     * Constructor de la clase DAOReservasImpl que inicializa la conexión a la base de datos.
     *
     * @throws SQLException Si ocurre un error al establecer la conexión.
     * @throws IOException Si ocurre un error al leer la configuración de la conexión.
     */
    public DAOReservasImpl() throws SQLException, IOException {
        connection = SetUpConnection.getInstance().getConnection();
    }

    /**
     * Obtiene una lista de reservas de alojamiento.
     *
     * @return Una lista de objetos Reservas.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    @Override
    public List<Reservas> getReservaPorTelefonoEId() throws SQLException {
        List<Reservas> reservas = new ArrayList<>();
        String sql = "SELECT * FROM RESERVAS;";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int idAlojamiento = resultSet.getInt("Id_Alojamiento");
            int Telefono = resultSet.getInt("Telefono");
            String Fecha_Entrada = resultSet.getString("Fecha_Entrada");
            String Fecha_Salida = resultSet.getString("Fecha_Salida");
            Reservas reserva = new Reservas(idAlojamiento, Telefono, Fecha_Entrada, Fecha_Salida);
            reservas.add(reserva);
        }
        return reservas;
    }

    /**
     * Obtiene una reserva de alojamiento por teléfono y ID de alojamiento.
     *
     * @param reservas El objeto Reservas que contiene el teléfono y ID de alojamiento.
     * @return La reserva encontrada, o null si no se encuentra.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    @Override
    public Reservas getReservaPorTelefonoEId(Reservas reservas) throws SQLException {
        String sql = "SELECT * FROM RESERVAS WHERE Id_Alojamiento = ? AND Telefono = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, reservas.getId_alojamiento());
        preparedStatement.setInt(2, reservas.getTelefono());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int idAlojamiento = resultSet.getInt("Id_Alojamiento");
            int Telefono = resultSet.getInt("Telefono");
            String Fecha_Entrada = resultSet.getString("Fecha_Entrada");
            String Fecha_Salida = resultSet.getString("Fecha_Salida");
            reservas = new Reservas(idAlojamiento, Telefono, Fecha_Entrada, Fecha_Salida);
        }
        return reservas;
    }

    /**
     * Inserta una nueva reserva de alojamiento en la base de datos.
     *
     * @param reserva El objeto Reservas a insertar.
     * @return true si la inserción fue exitosa, false de lo contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
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

    /**
     * Elimina una reserva de alojamiento por teléfono y ID de alojamiento.
     *
     * @param telefono El número de teléfono asociado a la reserva.
     * @param idAlojamiento El ID del alojamiento asociado a la reserva.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    @Override
    public boolean deleteReservaPorTelefonoEIdAlojamiento(int telefono, int idAlojamiento) throws SQLException {
        String sql = "DELETE FROM RESERVAS WHERE Id_Alojamiento = ? AND Telefono = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idAlojamiento);
        preparedStatement.setInt(2, telefono);
        int rowsDeleted = preparedStatement.executeUpdate();
        return rowsDeleted > 0;
    }

    /**
     * Actualiza la información de una reserva de alojamiento.
     *
     * @param reserva El objeto Reservas con la información actualizada.
     * @return true si la actualización fue exitosa, false de lo contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
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

