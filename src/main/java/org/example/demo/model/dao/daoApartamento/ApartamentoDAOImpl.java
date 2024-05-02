package org.example.demo.model.dao.daoApartamento;

import org.example.demo.model.SetUpConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
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

    @Override
    public boolean deleteApartamentoPorID(int id_alojamiento) throws SQLException {
        String sql = "DELETE FROM AP_TURISTICOS WHERE Id_Alojamiento = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id_alojamiento);
        int rowsDeleted = preparedStatement.executeUpdate();
        return rowsDeleted > 0;
    }

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
