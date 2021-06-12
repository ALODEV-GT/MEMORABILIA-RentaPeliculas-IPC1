package com.segundapractica;
public class Cliente {
    private String nombre;
    private int id;
    private int telefono;
    private boolean tienePeliculaPrestado = false;

    public Cliente(String nombre, int id, int telefono){
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
    }

    public int getId(){
        return this.id;
    }
}
