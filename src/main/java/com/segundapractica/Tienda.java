package com.segundapractica;

import javax.swing.plaf.synth.SynthLookAndFeel;

public class Tienda {
    private int contadorPeliculas = 0;
    private int contadorClientes = 0;
    private Cliente[] clientes = new Cliente[30];
    private Pelicula[] peliculas = new Pelicula[30];

    public void agregarPelicula(int id, String nombre, int anio, String categoria) {
                Pelicula nuevaPelicula = new Pelicula(id, nombre, anio, categoria);
                peliculas[contadorPeliculas] = nuevaPelicula;
                contadorPeliculas++;
                System.out.println("La pelicula fue agregada correctamente");
    }

    public void mostrarPeliculas(){
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i]!= null) {
                System.out.println(peliculas[i]);
            }else{
                break;
            }
        }
    }

    public boolean hayEspacioPeliculas(){
        boolean siHay;
        if (contadorClientes<30) {
            siHay = true;
        } else {
            siHay = false;
        }
        return siHay;
    }

    public int[] obtenerIdPeliculas() {
        int[] idPeliculas = new int[30];
        for (int i = 0; i < idPeliculas.length; i++) {
            if (peliculas[i] != null) {
                idPeliculas[i] = peliculas[i].getId();
            } else {
                idPeliculas[i] = 0;
            }
        }
        return idPeliculas;
    }

    public int[] obtenerIdClientes() {
        int[] idClientes = new int[30];
        for (int i = 0; i < idClientes.length; i++) {
            if (peliculas[i] != null) {
                idClientes[i] = clientes[i].getId();
            } else {
                idClientes[i] = 0;
            }
        }
        return idClientes;
    }

    public void registrarCliente(String nombre, int id, int telefono) {
        if (contadorClientes < 30) {
            if (MetodosBusqueda.busquedaSecuencialNumeros(obtenerIdClientes(), id) == false) {
                Cliente nuevoCliente = new Cliente(nombre, id, telefono);
                clientes[contadorClientes] = nuevoCliente;
            } else {
                System.out.println("Este id ya fue utilizado");
            }
        } else {
            System.out.println("Ya no puedes agregar mas clientes [MAX: 30]");
        }
    }

    public Cliente[] getClientes() {
        return this.clientes;
    }

    public Pelicula[] getPeliculas() {
        return this.peliculas;
    }
}
