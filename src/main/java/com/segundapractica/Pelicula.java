package com.segundapractica;

public class Pelicula {
    private int id;
    private String nombre;
    private int anio;
    private String categoria;
    private boolean disponible = true;
    private int vecesPrestada = 0;
    public static int contadorAccion = 0;
    public static int contadorComedio = 0;
    public static int contadorRomance = 0;
    public static int contadorTerror = 0;
    public static int contadorAnimacion = 0;

    public Pelicula(int id, String nombre, int anio, String categoria){
        this.id = id;
        this.nombre = nombre;
        this.anio = anio;
        this.categoria = categoria;
    }

    public int getVecesPrestada(){
        return this.vecesPrestada;
    }

    public String getCategoria(){
        return this.categoria;
    }

    public boolean getDisponible(){
        return this.disponible;
    }

    public void setDisponible(boolean disponible){
        this.disponible = disponible;
        this.vecesPrestada++;
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
               "\nAnio: " + this.anio + 
               "\nVeces prestado: " + this.vecesPrestada;                
    }
}
