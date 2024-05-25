package org.example.demo.model.dao.daoHotel;

import java.util.Objects;

/**
 * Clase que representa un hotel.
 *
 * @author Alejandro Galán Herrera
 * @since 23/04/2024
 * @version 0.1
 */
public class Hotel {

    private int idAlojamiento;
    private String tipoHabitacion;
    private String nombre;
    private int numeroEstrellas;

    /**
     * Constructor de la clase Hotel.
     *
     * @param idAlojamiento El identificador del alojamiento.
     * @param tipo_habitacion El tipo de habitación del hotel.
     * @param nombre El nombre del hotel.
     * @param numeroEstrellas El número de estrellas del hotel.
     */
    public Hotel(int idAlojamiento, String tipo_habitacion, String nombre, int numeroEstrellas) {
        this.idAlojamiento = idAlojamiento;
        tipoHabitacion = tipo_habitacion;
        this.nombre = nombre;
        this.numeroEstrellas = numeroEstrellas;
    }

    /**
     * Obtiene el identificador del alojamiento.
     *
     * @return identificador del alojamiento.
     */
    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    /**
     * Establece el identificador del alojamiento.
     *
     * @param idAlojamiento identificador del alojamiento.
     */
    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    /**
     * Obtiene el tipo de habitación del hotel.
     *
     * @return tipo de habitación del hotel.
     */
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    /**
     * Establece el tipo de habitación del hotel.
     *
     * @param tipoHabitacion  tipo de habitación del hotel.
     */
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    /**
     * Obtiene el nombre del hotel.
     *
     * @return  nombre del hotel.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del hotel.
     *
     * @param nombre  nombre del hotel.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de estrellas del hotel.
     *
     * @return número de estrellas del hotel.
     */
    public int getNumeroEstrellas() {
        return numeroEstrellas;
    }

    /**
     * Establece el número de estrellas del hotel.
     *
     * @param numeroEstrellas número de estrellas del hotel.
     */
    public void setNumeroEstrellas(int numeroEstrellas) {
        this.numeroEstrellas = numeroEstrellas;
    }

    /**
     * Devuelve una representación de cadena de este objeto.
     *
     * @return representación de cadena de este objeto.
     */
    @Override
    public String toString() {
        return String.format("%d, %s, %s, %d%n", idAlojamiento, tipoHabitacion, nombre, numeroEstrellas);
    }

    /**
     * Indica si algún otro objeto es "igual" a este.
     *
     * @param o objeto con el que se debe comparar.
     * @return true si este objeto es igual al objeto dado; false si es lo contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(idAlojamiento, hotel.idAlojamiento);
    }

    /**
     * Devuelve un valor de hash para este objeto.
     *
     * @return valor de hash para este objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idAlojamiento);
    }
}
