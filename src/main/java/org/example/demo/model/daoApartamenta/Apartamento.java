package org.example.demo.model.daoApartamenta;

import org.example.demo.model.daoUsuario.Usuario;

import java.util.Objects;

public class Apartamento {
    private int id_alojamiento;
    private TipoHabitacion tipoHabitacion;
    private String nombre;
    private int numero_estrellas;

    public Apartamento(int id_alojamiento, TipoHabitacion tipoHabitacion, java.lang.String nombre, int numero_estrellas) {
        this.id_alojamiento = id_alojamiento;
        this.tipoHabitacion = tipoHabitacion;
        this.nombre = nombre;
        this.numero_estrellas = numero_estrellas;
    }

    public int getId_alojamiento() {
        return id_alojamiento;
    }

    public void setId_alojamiento(int id_alojamiento) {
        this.id_alojamiento = id_alojamiento;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero_estrellas() {
        return numero_estrellas;
    }

    public void setNumero_estrellas(int numero_estrellas) {
        this.numero_estrellas = numero_estrellas;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%s,%d",id_alojamiento, tipoHabitacion, nombre, numero_estrellas);
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
