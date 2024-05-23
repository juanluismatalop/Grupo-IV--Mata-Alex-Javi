package org.example.demo.model.dao.daoApartamento;

import java.util.Objects;

/**
 * Clase que representa un apartamento.
 *
 * @author Javier Segovia Martinez
 * @since 22/05/2024
 * @version 0.1
 */
public class Apartamento {

    /**
     * El identificador del alojamiento.
     */
    private int idAlojamiento;

    /**
     * El nombre del apartamento.
     */
    private String nombre;

    /**
     * La distancia del apartamento al centro en kilómetros.
     */
    private double distanciaCentroKm;

    /**
     * Constructor para crear una instancia de Apartamento.
     *
     * @param idAlojamiento El identificador del alojamiento.
     * @param nombre        El nombre del apartamento.
     * @param distanciaCentroKm La distancia del apartamento al centro en kilómetros.
     */

    public Apartamento(int idAlojamiento, String nombre, double distanciaCentroKm) {
        this.idAlojamiento = idAlojamiento;
        this.nombre = nombre;
        this.distanciaCentroKm = distanciaCentroKm;
    }

    /**
     * Obtiene el identificador del alojamiento.
     *
     * @return El identificador del alojamiento.
     */

    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    /**
     * Establece el identificador del alojamiento.
     *
     * @param idAlojamiento El nuevo identificador del alojamiento.
     */

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    /**
     * Obtiene el nombre del apartamento.
     *
     * @return El nombre del apartamento.
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del apartamento.
     *
     * @param nombre El nuevo nombre del apartamento.
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la distancia del apartamento al centro en kilómetros.
     *
     * @return La distancia del apartamento al centro en kilómetros.
     */

    public double getDistanciaCentroKm() {
        return distanciaCentroKm;
    }

    /**
     * Establece la distancia del apartamento al centro en kilómetros.
     *
     * @param distanciaCentroKm La nueva distancia del apartamento al centro en kilómetros.
     */

    public void setDistanciaCentroKm(double distanciaCentroKm) {
        this.distanciaCentroKm = distanciaCentroKm;
    }

    /**
     * Devuelve una representación en cadena del objeto Apartamento.
     *
     * @return Una cadena con el identificador del alojamiento, nombre y distancia al centro.
     */

    @Override
    public String toString() {
        return String.format("%d,%s,%s,%f", idAlojamiento, nombre, distanciaCentroKm);
    }

    /**
     * Compara este objeto Apartamento con otro objeto para determinar si son iguales.
     *
     * @param o El objeto a comparar.
     * @return {@code true} si los objetos son iguales, {@code false} de lo contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartamento apartamento = (Apartamento) o;
        return Objects.equals(idAlojamiento, apartamento.idAlojamiento);
    }

    /**
     * Calcula el código hash para el objeto Apartamento.
     *
     * @return El código hash del objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idAlojamiento);
    }
}