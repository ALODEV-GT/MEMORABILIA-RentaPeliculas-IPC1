package com.segundapractica;

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

    public void mostrarPeliculas(boolean mostrarSoloDisponibles) {
        boolean mostrarDisponibles = mostrarSoloDisponibles;

        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] != null) {
                if (mostrarDisponibles) {
                    if (peliculas[i].getDisponible()) {
                        System.out.println(peliculas[i]);
                    }
                } else {
                    System.out.println(peliculas[i]);
                }

            } else {
                break;
            }
        }
    }

    public void mostrarClientes() {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                System.out.println(clientes[i]);
            } else {
                break;
            }
        }
    }

    public boolean hayEspacioPeliculas() {
        boolean siHay;
        if (contadorPeliculas < 30) {
            siHay = true;
        } else {
            siHay = false;
        }
        return siHay;
    }

    public boolean hayEspacioClientes() {
        boolean siHay;
        if (contadorClientes < 30) {
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
            if (clientes[i] != null) {
                idClientes[i] = clientes[i].getId();
            }
        }
        return idClientes;
    }

    public void registrarCliente(String nombre, int id, int telefono) {

        Cliente nuevoCliente = new Cliente(nombre, id, telefono);
        clientes[contadorClientes] = nuevoCliente;
        contadorClientes++;
        System.out.println("Se ha registrado correctamente");
    }

    public Cliente[] getClientes() {
        return this.clientes;
    }

    public Pelicula[] getPeliculas() {
        return this.peliculas;
    }

    public void ordenarPeliculas() {
        Pelicula[] arreglo = peliculas;
        boolean continuar = true;
        int contador = 0;
        while (contador < arreglo.length - 1 && continuar) {
            int intercambios = 0;
            for (int i = 0; i < arreglo.length - 1 - contador; i++) {
                if (arreglo[i + 1] == null) {
                    continuar = false;
                    break;
                } else {
                    Pelicula parte1 = arreglo[i];
                    Pelicula parte2 = arreglo[i + 1];
                    if (parte1.getNombre().compareToIgnoreCase(parte2.getNombre()) > 0) {
                        arreglo[i] = parte2;
                        arreglo[i + 1] = parte1;
                        intercambios++;
                    }
                }
            }

            continuar = intercambios > 0;
            contador++;
        }
    }
}
