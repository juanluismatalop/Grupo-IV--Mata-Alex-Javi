package org.example.demo.model.daoApartamenta;

import org.example.demo.model.SetUpConnection;
import org.example.demo.model.daoUsuario.Usuario;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ApartamentoDAOImpl implements ApartamentoDAO {
    private final Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public ApartamentoDAOImpl() throws SQLException, IOException {
        connection = SetUpConnection.getInstance().getConnection();
    }

    @Override
    public List<Usuario> getApartamento() throws SQLException {
        return null;
    }

    @Override
    public Usuario getApartamentoYID(Apartamento apartamento) throws SQLException {
        return null;
    }

    @Override
    public boolean insertApartamento(Apartamento apartamento) throws SQLException {
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
