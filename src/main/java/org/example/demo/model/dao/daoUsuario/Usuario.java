package org.example.demo.model.dao.daoUsuario;

import java.util.Objects;

/**
 * @author Juan Luis Mata
 * @version 1.0
 * @since 1.0
 */
public class Usuario {

    private int Telefono;
    private String email;
    private String contrasenna;
    private String NOMBRE_COMPLETO;
    private String Direccion;

    /**
     * Constructor de la clase Usuarios
     * @param telefono
     * @param email
     * @param contrasenna
     * @param NOMBRE_COMPLETO
     * @param direccion
     */
    public Usuario(int telefono, String email, String contrasenna, String NOMBRE_COMPLETO, String direccion) {
        Telefono = telefono;
        this.email = email;
        this.contrasenna = contrasenna;
        this.NOMBRE_COMPLETO = NOMBRE_COMPLETO;
        Direccion = direccion;
    }

    /**
     * get de el parametro Telefono
     * @return Telefono
     */
    public int getTelefono() {
        return Telefono;
    }

    /**
     * set de telefono
     * @param telefono
     */
    public void setTelefono(int telefono) {
        Telefono = telefono;
    }

    /**
     * constructor de email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * set de email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get de contrasenna
     * @return
     */
    public String getContrasenna() {
        return contrasenna;
    }

    /**
     * set de contrasenna
     * @param contrasenna
     */
    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    /**
     * get de nombre completo
     * @return
     */
    public String getNOMBRE_COMPLETO() {
        return NOMBRE_COMPLETO;
    }

    /**
     * set de nombre completo
     * @param NOMBRE_COMPLETO
     */
    public void setNOMBRE_COMPLETO(String NOMBRE_COMPLETO) {
        this.NOMBRE_COMPLETO = NOMBRE_COMPLETO;
    }

    /**
     * get de direccion
     * @return
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * set de direccion
     * @param direccion
     */
    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    /**
     * el toString que mostrara los datos con el formato csv
     * @return
     */
    @Override
    public String toString() {
        return String.format("%d, %s, %s, %s, %s", Telefono, email, contrasenna, NOMBRE_COMPLETO, Direccion);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(Telefono, usuario.Telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Telefono);
    }
}
