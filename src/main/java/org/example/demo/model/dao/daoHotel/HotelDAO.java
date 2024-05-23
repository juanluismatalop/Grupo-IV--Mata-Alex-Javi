package org.example.demo.model.dao.daoHotel;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define las operaciones para acceder a los datos de los hoteles.
 *
 * @author Alejandro Galán Herrera
 * @since 23/04/2024
 */
public interface HotelDAO {

    /**
     * Obtiene una lista de todos los hoteles.
     *
     * @return Una lista de objetos Hotel.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    List<Hotel> getHotel() throws SQLException;

    /**
     * Obtiene un hotel por su identificador.
     *
     * @param hotel El objeto Hotel que contiene el ID del hotel a buscar.
     * @return El hotel encontrado, o null si no se encuentra.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    Hotel getHotelByID(Hotel hotel) throws SQLException;

    /**
     * Inserta un nuevo hotel en la base de datos.
     *
     * @param hotel El objeto Hotel a insertar.
     * @return true si la inserción fue exitosa, false de lo contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    boolean insertHotel(Hotel hotel) throws SQLException;

    /**
     * Elimina un hotel por su identificador.
     *
     * @param Id_Alojamiento El ID del hotel a eliminar.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    boolean deleteHotelById(int Id_Alojamiento) throws SQLException;

    /**
     * Actualiza la información de un hotel.
     *
     * @param hotel El objeto Hotel con la información actualizada.
     * @return true si la actualización fue exitosa, false de lo contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    boolean updateHotel(Hotel hotel) throws SQLException;

    boolean deleteHotel(int id) throws SQLException;
}

