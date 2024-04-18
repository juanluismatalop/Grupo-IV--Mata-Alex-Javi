package org.example.demo.model.daoUsuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {
    List<Usuario> getUsuario() throws SQLException;
    Usuario getUsuarioByTelefono(int telefono);
    boolean insertUsuario(Usuario usuario);
    boolean deleteUsuarioByTelefono(int telefono);
    boolean updateUsuario(Usuario usuario);

}
