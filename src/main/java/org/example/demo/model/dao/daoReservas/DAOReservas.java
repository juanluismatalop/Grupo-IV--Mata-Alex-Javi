package org.example.demo.model.dao.daoReservas;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define las operaciones para acceder a los datos de las reservas de alojamiento.
 *
 * @author Alejandro Galán Herrera
 * @since 24/04/2024
 */
public interface DAOReservas {

    /**
     * Obtiene una lista de reservas por teléfono y ID de alojamiento.
     *
     * @return Una lista de objetos Reservas.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    List<Reservas> getReservaPorTelefonoEId() throws SQLException;

    /**
     * Obtiene una reserva por teléfono y ID de alojamiento.
     *
     * @param reserva El objeto Reservas que contiene el teléfono y ID de alojamiento.
     * @return La reserva encontrada, o null si no se encuentra.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    Reservas getReservaPorTelefonoEId(Reservas reserva) throws SQLException;

    /**
     * Inserta una nueva reserva en la base de datos.
     *
     * @param reserva El objeto Reservas a insertar.
     * @return true si la inserción fue exitosa, false de lo contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    boolean insertReserva(Reservas reserva) throws SQLException;

    /**
     * Elimina una reserva por teléfono y ID de alojamiento.
     *
     * @param telefono El número de teléfono asociado a la reserva.
     * @param idAlojamiento El ID del alojamiento asociado a la reserva.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    boolean deleteReservaPorTelefonoEIdAlojamiento(int telefono, int idAlojamiento) throws SQLException;

    /**
     * Actualiza la información de una reserva.
     *
     * @param reserva El objeto Reservas con la información actualizada.
     * @return true si la actualización fue exitosa, false de lo contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    boolean updateReserva(Reservas reserva) throws SQLException;
}

