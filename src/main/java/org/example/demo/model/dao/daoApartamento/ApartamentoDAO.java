package org.example.demo.model.dao.daoApartamento;

import java.sql.SQLException;
import java.util.List;

public interface ApartamentoDAO {
    List<Apartamento> getApartamento() throws SQLException;
    Apartamento getApartamentoYID(Apartamento apartamento) throws SQLException;

    boolean insertApartamento(Apartamento apartamento) throws SQLException;
    boolean deleteApartamentoPorID(int idAlojamiento) throws SQLException;
    boolean updateApartamento(Apartamento apartamento) throws SQLException;
}
