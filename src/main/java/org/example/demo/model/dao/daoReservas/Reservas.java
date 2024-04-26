package org.example.demo.model.dao.daoReservas;

import org.example.demo.model.dao.daoApartamento.Apartamento;

import java.time.LocalDate;
import java.util.Objects;

public class Reservas {
    private int id_alojamiento;
    private int telefono;
    private String fechaEntrada;
    private String fechaSalida;

    public Reservas(int id_alojamiento, int telefono, String fechaEntrada, String fechaSalida) {
        this.id_alojamiento = id_alojamiento;
        this.telefono = telefono;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public int getId_alojamiento() {
        return id_alojamiento;
    }

    public void setId_alojamiento(int id_alojamiento) {
        this.id_alojamiento = id_alojamiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public String toString() {
        return String.format("%d,%d,%s,%s",id_alojamiento, telefono, fechaEntrada, fechaEntrada);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservas reservas= (Reservas) o;
        return Objects.equals(id_alojamiento, reservas.id_alojamiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_alojamiento);
    }
}
