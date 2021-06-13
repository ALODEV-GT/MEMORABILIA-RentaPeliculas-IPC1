package com.segundapractica;

import java.util.Scanner;

public class PrestarPelicula {

    Cliente[] clientes;
    Pelicula[] peliculas;
    Tienda tienda;
    Cliente clientePrestando;

    public PrestarPelicula(Tienda tienda) {
        this.tienda = tienda;
        clientes = tienda.getClientes();
        peliculas = tienda.getPeliculas();
    }

    public void prestarPelicula(int idCliente) {
        if (existeCliente(idCliente)) {
            if (tienePelicula(idCliente)) {
                System.out.println("Ya no puedes prestar mas peliculas, ya tienes una prestada");
            } else {
                validarPrestamoPelicula();
            }
        } else {
            System.out.println("Este id no existe");
        }
    }

    public void validarPrestamoPelicula() {
        Scanner entrada = new Scanner(System.in);
        int idPelicula;
        boolean existe = false;
        System.out.println("-----Estas son las peliculas que puedes prestar----");
        tienda.mostrarPeliculas(true);
        System.out.println("Escribe el ID de la pelicula que quieres prestar: ");

        do {
            idPelicula = entrada.nextInt();
            if (MetodosBusqueda.busquedaSecuencialNumeros(tienda.obtenerIdPeliculas(), idPelicula)) {
                existe = true;
                clientePrestando.setTienePeliculaPrestado(true);
                for (int i = 0; i < peliculas.length; i++) {
                    if (peliculas[i] != null) {
                        if (idPelicula == peliculas[i].getId()) {
                            peliculas[i].setDisponible(false);
                        }
                    } else {
                        break;
                    }                    
                }
            } else {
                System.out.println("No existe ninguna pelicula con este id, vuelve a intentarlo");
            }
        } while (!existe);
        System.out.println("Prestado correctamente... :) ");
    }

    public boolean existeCliente(int idCliente) {
        boolean existe = MetodosBusqueda.busquedaSecuencialNumeros(tienda.obtenerIdClientes(), idCliente);
        return existe;
    }

    public boolean tienePelicula(int idCliente) {
        boolean yaTiene = false;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                if (clientes[i].getId() == idCliente) {
                    if (clientes[i].getTienePeliculaPrestado() == true) {
                        clientePrestando = clientes[i];
                        yaTiene = true;
                    }else{
                        clientePrestando = clientes[i];
                    }
                }
            } else {
                break;
            }
        }
        return yaTiene;
    }
}
