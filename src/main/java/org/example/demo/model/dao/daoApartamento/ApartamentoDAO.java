package org.example.demo.model.dao.daoApartamento;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define las operaciones para acceder a los datos de los apartamentos.
 *
 * @author Javier Segovia Martinez
 * @since 22/05/2024
 * @version 0.1
 */
public interface ApartamentoDAO {

    /**
     * Obtiene una lista de todos los apartamentos.
     *
     * @return Una lista de objetos {@link Apartamento}.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    List<Apartamento> getApartamento() throws SQLException;

    /**
     * Obtiene un apartamento por su identificador.
     *
     * @param apartamento El objeto {@link Apartamento} con el identificador a buscar.
     * @return El objeto {@link Apartamento} encontrado.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    Apartamento getApartamentoYID(Apartamento apartamento) throws SQLException;

    /**
     * Inserta un nuevo apartamento en la base de datos.
     *
     * @param apartamento El objeto {@link Apartamento} a insertar.
     * @return {@code true} si la inserción fue exitosa, {@code false} de lo contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    boolean insertApartamento(Apartamento apartamento) throws SQLException;

    /**
     * Elimina un apartamento por su identificador.
     *
     * @param idAlojamiento El identificador del apartamento a eliminar.
     * @return {@code true} si la eliminación fue exitosa, {@code false} de lo contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    boolean deleteApartamentoPorID(int idAlojamiento) throws SQLException;

    /**
     * Actualiza los datos de un apartamento existente en la base de datos.
     *
     * @param apartamento El objeto {@link Apartamento} con los datos actualizados.
     * @return {@code true} si la actualización fue exitosa, {@code false} de lo contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    boolean updateApartamento(Apartamento apartamento) throws SQLException;
}