package org.example.demo.model.dao.daoReservas;

import org.example.demo.model.dao.daoApartamento.Apartamento;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase que representa una reserva de alojamiento.
 *
 * @author Alejandro Galán Herrera
 * @since 24/04/2024
 * @version 1.0
 */
public class Reservas {
    private int idAlojamiento;
    private int telefono;
    private String fechaEntrada;
    private String fechaSalida;

    /**
     * Constructor de la clase Reservas.
     *
     * @param idAlojamiento El ID del alojamiento reservado.
     * @param telefono El número de teléfono del cliente que realiza la reserva.
     * @param fechaEntrada La fecha de entrada de la reserva.
     * @param fechaSalida La fecha de salida de la reserva.
     */
    public Reservas(int idAlojamiento, int telefono, String fechaEntrada, String fechaSalida) {
        this.idAlojamiento = idAlojamiento;
        this.telefono = telefono;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    /**
     * Obtiene el ID del alojamiento reservado.
     *
     * @return El ID del alojamiento reservado.
     */
    public int getId_alojamiento() {
        return idAlojamiento;
    }

    /**
     * Establece el ID del alojamiento reservado.
     *
     * @param id_alojamiento El ID del alojamiento reservado.
     */
    public void setId_alojamiento(int id_alojamiento) {
        this.idAlojamiento = id_alojamiento;
    }

    /**
     * Obtiene el número de teléfono del cliente que realiza la reserva.
     *
     * @return El número de teléfono del cliente.
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del cliente que realiza la reserva.
     *
     * @param telefono El número de teléfono del cliente.
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la fecha de entrada de la reserva.
     *
     * @return La fecha de entrada de la reserva.
     */
    public String getFechaEntrada() {
        return fechaEntrada;
    }

    /**
     * Establece la fecha de entrada de la reserva.
     *
     * @param fechaEntrada La fecha de entrada de la reserva.
     */
    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    /**
     * Obtiene la fecha de salida de la reserva.
     *
     * @return La fecha de salida de la reserva.
     */
    public String getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Establece la fecha de salida de la reserva.
     *
     * @param fechaSalida La fecha de salida de la reserva.
     */
    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }


    /**
     * Devuelve una representación de cadena de este objeto.
     *
     * @return Una representación de cadena de este objeto.
     */
    @Override
    public String toString() {
        return String.format("%d,%d,%s,%s",idAlojamiento, telefono, fechaEntrada, fechaEntrada);
    }

    /**
     * Indica si algún otro objeto es "igual" a este.
     *
     * @param o El objeto con el que se debe comparar.
     * @return true si este objeto es igual al objeto dado; false, de lo contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservas reservas= (Reservas) o;
        return Objects.equals(idAlojamiento, reservas.idAlojamiento);
    }

    /**
     * Devuelve un valor de hash para este objeto.
     *
     * @return Un valor de hash para este objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idAlojamiento);
    }
}
