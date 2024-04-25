package org.example.demo.model.dao.daoApartamento;

import org.example.demo.model.SetUpConnection;
import org.example.demo.model.dao.daoUsuario.Usuario;

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
        Apartamento apartamento1 = null;
        while (resultSet.next()){
            int id_alojamiento = resultSet.getInt("Id_Alojamiento");
            String nombre = resultSet.getString("Nombre");
            double distancia_Centro_Km = resultSet.getDouble("Distancia_Centro_Km");
            apartamento1 = new Apartamento(id_alojamiento, nombre, distancia_Centro_Km);
            apartamentos.add(apartamento1);
        }
        return apartamentos;
    }

    @Override
    public Apartamento getApartamentoYID(Apartamento apartamento) throws SQLException {
        String sql = "SELECT * FROM AP_TURISTICOs WHERE Id_Alojamiento = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,apartamento.getId_alojamiento());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id_alojamiento = resultSet.getInt("Id_Alojamiento");
            String nombre = resultSet.getString("Nombre");
            double distancia_Centro_Km = resultSet.getDouble("Distancia_Centro_Km");
            apartamento = new Apartamento(id_alojamiento, nombre, distancia_Centro_Km);
        }
        return apartamento;
    }

    @Override
    public boolean insertApartamento(Apartamento apartamento) throws SQLException {
        String sql = "INSERT INTO AP_TURISTICOS VALUES(?, ?, ?);";
        preparedStatement = connection.prepareStatement(sql);

        return false;
    }

    @Override
    public boolean deleteApartamentoPorID(int id_alojamiento) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUsuario(Apartamento apartamento) throws SQLException {
        return false;
    }
}
