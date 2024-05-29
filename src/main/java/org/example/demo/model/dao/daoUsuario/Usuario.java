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
    private String Funcion;

    public Usuario(int telefono, String email, String contrasenna, String NOMBRE_COMPLETO, String direccion, String funcion) {
        Telefono = telefono;
        this.email = email;
        this.contrasenna = contrasenna;
        this.NOMBRE_COMPLETO = NOMBRE_COMPLETO;
        Direccion = direccion;
        Funcion = funcion;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int telefono) {
        Telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getNOMBRE_COMPLETO() {
        return NOMBRE_COMPLETO;
    }

    public void setNOMBRE_COMPLETO(String NOMBRE_COMPLETO) {
        this.NOMBRE_COMPLETO = NOMBRE_COMPLETO;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getFuncion() {
        return Funcion;
    }

    public void setFuncion(String funcion) {
        Funcion = funcion;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %s, %s, %s, %s", Telefono, email, contrasenna, NOMBRE_COMPLETO, Direccion, Funcion);
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
