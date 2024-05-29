package org.example.demo.model.dao.daoUsuario;

import java.sql.SQLException;
import java.util.List;
/**
 * @author Juan Luis Mata
 * @version 1.0
 * @since 1.0
 */
public interface UsuarioDAO {
    /**
     * metodo que lista los usuarios
     * @return
     * @throws SQLException
     */
    List<Usuario> getUsuario() throws SQLException;

    /**
     * metodo que te devuelve un usuario
     * @param usuario
     * @return
     * @throws SQLException
     */
    Usuario getUsuarioByTelefono(Usuario usuario) throws SQLException;

    /**
     * metodo para insertar un usuario
     * @param usuario
     * @return
     * @throws SQLException
     */
    boolean insertUsuario(Usuario usuario) throws SQLException;

    /**
     * metodo para borrar usuarios con el valor movil
     * @param telefono
     * @return
     * @throws SQLException
     */
    boolean deleteUsuarioByTelefono(int telefono) throws SQLException;

    /**
     * metodo para actualizar usuario
     * @param usuario
     * @return
     * @throws SQLException
     */
    boolean updateUsuario(Usuario usuario) throws SQLException;

    /**
     * Metodo que te da un usuario introduciendo tu su nombre y contrasenna
     * @param nombreCompleto
     * @param contrasenna
     * @return
     * @throws SQLException
     */
    boolean getUsuarioByNombreANDContrasenna(String nombreCompleto, String contrasenna) throws SQLException;

    List<Usuario> getUsuariosFuncionClientes() throws SQLException;
    Usuario getTelefonoCliente(int Telefono) throws SQLException;
}
