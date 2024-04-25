package org.example.demo.model.dao.daoApartamento;

import java.util.Objects;

public class Apartamento {
    private int id_alojamiento;
    private String nombre;
    private double Distancia_Centro_Km;

    public Apartamento(int id_alojamiento, String nombre, double distancia_Centro_Km) {
        this.id_alojamiento = id_alojamiento;
        this.nombre = nombre;
        Distancia_Centro_Km = distancia_Centro_Km;
    }

    public int getId_alojamiento() {
        return id_alojamiento;
    }

    public void setId_alojamiento(int id_alojamiento) {
        this.id_alojamiento = id_alojamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDistancia_Centro_Km() {
        return Distancia_Centro_Km;
    }

    public void setDistancia_Centro_Km(double distancia_Centro_Km) {
        Distancia_Centro_Km = distancia_Centro_Km;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%s,%f",id_alojamiento, nombre, Distancia_Centro_Km);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartamento apartamento = (Apartamento) o;
        return Objects.equals(id_alojamiento, apartamento.id_alojamiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_alojamiento);
    }
}
