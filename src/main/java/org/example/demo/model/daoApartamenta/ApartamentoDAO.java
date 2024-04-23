package org.example.demo.model.daoApartamenta;

import org.example.demo.model.daoUsuario.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface ApartamentoDAO {
    List<Usuario> getApartamento() throws SQLException;
    Usuario getApartamentoYID(Apartamento apartamento) throws SQLException;

    boolean insertApartamento(Apartamento apartamento) throws SQLException;
    boolean deleteApartamentoPorID(int id_alojamiento) throws SQLException;
    boolean updateUsuario(Apartamento apartamento) throws SQLException;
}
