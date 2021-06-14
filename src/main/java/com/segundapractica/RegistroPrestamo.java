package com.segundapractica;

public class RegistroPrestamo {
    Cliente cliente;
    Pelicula pelicula;
    int diasPrestados;
    boolean finalizado = false;

    public RegistroPrestamo(Cliente cliente, Pelicula pelicula, int diasPrestados) {
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.diasPrestados = diasPrestados;
    }

    public int getIDPelicula(){
        return this.pelicula.getId();
    }

    public String toString() {
        return "Pelicula: " + pelicula.getNombre() +" Id pelicula: " + pelicula.getId() +" Nombre del cliente: " + cliente.getNombre();
    }

    public boolean getFinalizado() {
        return this.finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
}