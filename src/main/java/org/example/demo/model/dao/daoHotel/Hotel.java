package org.example.demo.model.dao.daoHotel;

import java.util.Objects;

public class Hotel {

    private int Id_Alojamiento;
    private String Tipo_habitacion;
    private String nombre;
    private int numeroEstrellas;

    public Hotel(int id_Alojamiento, String tipo_habitacion, String nombre, int numeroEstrellas) {
        Id_Alojamiento = id_Alojamiento;
        Tipo_habitacion = tipo_habitacion;
        this.nombre = nombre;
        this.numeroEstrellas = numeroEstrellas;
    }

    public int getId_Alojamiento() {
        return Id_Alojamiento;
    }

    public void setId_Alojamiento(int id_Alojamiento) {
        Id_Alojamiento = id_Alojamiento;
    }

    public String getTipo_habitacion() {
        return Tipo_habitacion;
    }

    public void setTipo_habitacion(String tipo_habitacion) {
        Tipo_habitacion = tipo_habitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroEstrellas() {
        return numeroEstrellas;
    }

    public void setNumeroEstrellas(int numeroEstrellas) {
        this.numeroEstrellas = numeroEstrellas;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %s, %d", Id_Alojamiento, Tipo_habitacion, nombre, numeroEstrellas);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(Id_Alojamiento, hotel.Id_Alojamiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id_Alojamiento);
    }
}
