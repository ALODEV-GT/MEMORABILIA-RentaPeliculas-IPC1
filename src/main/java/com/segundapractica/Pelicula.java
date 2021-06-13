package com.segundapractica;

public class Pelicula {
    private int id;
    private String nombre;
    private int anio;
    private String categoria;
    private boolean disponible = true;

    public Pelicula(int id, String nombre, int anio, String categoria){
        this.id = id;
        this.nombre = nombre;
        this.anio = anio;
        this.categoria = categoria;
    }

    public boolean getDisponible(){
        return this.disponible;
    }

    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }
    
    public String getNombre(){
        return this.nombre;
    }

    public int getId(){
        return this.id;
    }

    @Override
    public String toString(){
        return "Nombre: " + this.nombre +
               "\nId: " + this.id+
               "\nCategoria: " + this.categoria +
               "\nAnio: " + this.anio + "\n";                
    }
}
