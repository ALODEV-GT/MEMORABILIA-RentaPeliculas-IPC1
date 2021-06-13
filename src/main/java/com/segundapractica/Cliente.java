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

    @Override
    public String toString(){
        return "Nombre: " + this.nombre +
               "\nId: " + this.id +
               "\nTelefono: " + this.telefono + "\n";
    }

    public int getId(){
        return this.id;
    }

    public boolean getTienePeliculaPrestado(){
        return this.tienePeliculaPrestado;
    }

    public void setTienePeliculaPrestado(boolean prestar){
        this.tienePeliculaPrestado = prestar;
    }
}
