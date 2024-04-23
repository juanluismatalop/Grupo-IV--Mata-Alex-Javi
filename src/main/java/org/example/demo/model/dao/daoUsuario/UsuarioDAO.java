package org.example.demo.model.dao.daoUsuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {
    List<Usuario> getUsuario() throws SQLException;
    Usuario getUsuarioByTelefono(Usuario usuario) throws SQLException;

    boolean insertUsuario(Usuario usuario) throws SQLException;
    boolean deleteUsuarioByTelefono(int telefono) throws SQLException;
    boolean updateUsuario(Usuario usuario) throws SQLException;

}
