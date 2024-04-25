package org.example.demo.model.dao.daoApartamento;

import org.example.demo.model.SetUpConnection;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class ApartamentoDAOImpl implements ApartamentoDAO {
    private final Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public ApartamentoDAOImpl() throws SQLException, IOException {
        connection = SetUpConnection.getInstance().getConnection();
    }

    @Override
    public List<Apartamento> getApartamento() throws SQLException {
        return null;
    }

    @Override
    public Apartamento getApartamentoYID(Apartamento apartamento) throws SQLException {
        String sql = "SELECT * FROM APARTAMENTO WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, apartamento.getId_alojamiento());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    return new Apartamento(apartamento.getId_alojamiento(), apartamento.getTipoHabitacion(), nombre, apartamento.getNumero_estrellas()/*, otros atributos */);
                }
            }
        }
        return null;
    }

    @Override
    public boolean insertApartamento(Apartamento apartamento) throws SQLException {
        String sql = "INSERT INTO APARTAMENTO (nombre /*, otros atributos */) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, apartamento.getNombre());
            int result = preparedStatement.executeUpdate();
            return result != 0;
        }
    }

    @Override
    public boolean deleteApartamentoPorID(int id_alojamiento) throws SQLException {
        String sql = "DELETE FROM APARTAMENTO WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id_alojamiento);
            int result = preparedStatement.executeUpdate();
            return result != 0;
        }
    }

    @Override
    public boolean updateUsuario(Apartamento apartamento) throws SQLException {
        String sql = "UPDATE APARTAMENTO SET nombre = ? /*, otros atributos */ WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, apartamento.getNombre());
            preparedStatement.setInt(2, apartamento.getId_alojamiento());
            int result = preparedStatement.executeUpdate();
            return result != 0;
        }

    }
}
