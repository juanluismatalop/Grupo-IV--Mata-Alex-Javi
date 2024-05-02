package org.example.demo.model.dao.daoApartamento;

import java.util.Objects;

public class Apartamento {
    private int idAlojamiento;
    private String nombre;
    private double distanciaCentroKm;

    public Apartamento(int idAlojamiento, String nombre, double distanciaCentroKm) {
        this.idAlojamiento = idAlojamiento;
        this.nombre = nombre;
        this.distanciaCentroKm = distanciaCentroKm;
    }

    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDistanciaCentroKm() {
        return distanciaCentroKm;
    }

    public void setDistanciaCentroKm(double distanciaCentroKm) {
        this.distanciaCentroKm = distanciaCentroKm;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%s,%f", idAlojamiento, nombre, distanciaCentroKm);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartamento apartamento = (Apartamento) o;
        return Objects.equals(idAlojamiento, apartamento.idAlojamiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAlojamiento);
    }
}
