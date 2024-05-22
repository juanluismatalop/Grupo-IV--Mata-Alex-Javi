package org.example.demo.model.dao.daoApartamento;

import org.example.demo.model.SetUpConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz ApartamentoDAO que proporciona métodos para acceder a los datos de los apartamentos en la base de datos.
 *
 * @author Javier Segovia Martinez
 * @since 22/05/2024
 * @version 0.1
 */
public class ApartamentoDAOImpl implements ApartamentoDAO {

    /**
     * La conexión a la base de datos.
     */
    private final Connection connection;

    /**
     * Una declaración SQL para ejecutar consultas simples.
     */
    private Statement statement;

    /**
     * Una declaración SQL precompilada para ejecutar consultas parametrizadas.
     */
    private PreparedStatement preparedStatement;

    /**
     * Constructor que inicializa la conexión a la base de datos.
     *
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     * @throws IOException  Si ocurre un error al leer el archivo de configuración.
     */

    public ApartamentoDAOImpl() throws SQLException, IOException {
        connection = SetUpConnection.getInstance().getConnection();
    }

    /**
     * Obtiene una lista de todos los apartamentos.
     *
     * @return Una lista de objetos {@link Apartamento}.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    @Override
    public List<Apartamento> getApartamento() throws SQLException {
        List<Apartamento> apartamentos = new ArrayList<>();
        String sql = "SELECT * FROM AP_TURISTICOS;";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id_alojamiento = resultSet.getInt("Id_Alojamiento");
            String nombre = resultSet.getString("Nombre");
            double distancia_Centro_Km = resultSet.getDouble("Distancia_Centro_Km");
            Apartamento apartamento = new Apartamento(id_alojamiento, nombre, distancia_Centro_Km);
            apartamentos.add(apartamento);
        }
        return apartamentos;
    }

    /**
     * Obtiene un apartamento por su identificador.
     *
     * @param apartamento El objeto {@link Apartamento} con el identificador a buscar.
     * @return El objeto {@link Apartamento} encontrado, o null si no se encuentra.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    @Override
    public Apartamento getApartamentoYID(Apartamento apartamento) throws SQLException {
        String sql = "SELECT * FROM AP_TURISTICOS WHERE Id_Alojamiento = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, apartamento.getIdAlojamiento());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int id_alojamiento = resultSet.getInt("Id_Alojamiento");
            String nombre = resultSet.getString("Nombre");
            double distancia_Centro_Km = resultSet.getDouble("Distancia_Centro_Km");
            apartamento = new Apartamento(id_alojamiento, nombre, distancia_Centro_Km);
        }
        return apartamento;
    }

    /**
     * Inserta un nuevo apartamento en la base de datos.
     *
     * @param apartamento El objeto {@link Apartamento} a insertar.
     * @return {@code true} si la inserción fue exitosa, {@code false} de lo contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    @Override
    public boolean insertApartamento(Apartamento apartamento) throws SQLException {
        String sql = "INSERT INTO AP_TURISTICOS (Id_Alojamiento, Nombre, Distancia_Centro_Km) VALUES (?, ?, ?);";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, apartamento.getIdAlojamiento());
        preparedStatement.setString(2, apartamento.getNombre());
        preparedStatement.setDouble(3, apartamento.getDistanciaCentroKm());
        int rowsInserted = preparedStatement.executeUpdate();
        return rowsInserted > 0;
    }

    /**
     * Elimina un apartamento por su identificador.
     *
     * @param id_alojamiento El identificador del apartamento a eliminar.
     * @return {@code true} si la eliminación fue exitosa, {@code false} de lo contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    @Override
    public boolean deleteApartamentoPorID(int id_alojamiento) throws SQLException {
        String sql = "DELETE FROM AP_TURISTICOS WHERE Id_Alojamiento = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id_alojamiento);
        int rowsDeleted = preparedStatement.executeUpdate();
        return rowsDeleted > 0;
    }

    /**
     * Actualiza los datos de un apartamento existente en la base de datos.
     *
     * @param apartamento El objeto {@link Apartamento} con los datos actualizados.
     * @return {@code true} si la actualización fue exitosa, {@code false} de lo contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    @Override
    public boolean updateApartamento(Apartamento apartamento) throws SQLException {
        String sql = "UPDATE AP_TURISTICOS SET Nombre = ?, Distancia_Centro_Km = ? WHERE Id_Alojamiento = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, apartamento.getNombre());
        preparedStatement.setDouble(2, apartamento.getDistanciaCentroKm());
        preparedStatement.setInt(3, apartamento.getIdAlojamiento());
        int rowsUpdated = preparedStatement.executeUpdate();
        return rowsUpdated > 0;
    }
}