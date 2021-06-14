package com.segundapractica;

import java.util.Scanner;

public class DevolverPelicula{

    Scanner entrada = new Scanner(System.in);
    Cliente[] clientes;
    Pelicula[] peliculas;
    Tienda tienda;
    Cliente clientePrestando;

    public DevolverPelicula(Tienda tienda) {
        this.tienda = tienda;
        clientes = tienda.getClientes();
        peliculas = tienda.getPeliculas();
    }

    public void dovolverPelicula(){
        int idPelicula;
        System.out.println("-------- Estas son las peliculas que fueron prestadas -------- ");
        tienda.mostrarRegistroPrestamos(false);
        System.out.println("Ingresa el id de la pelicula que quieres devolver: ");
        boolean existe = false;
        do {
            idPelicula = entrada.nextInt();
            if (MetodosBusqueda.busquedaSecuencialNumeros(obtenerIDPeliculasPrestadas(), idPelicula)) {
                existe = true;
            }else{
                System.out.println("Este id no existe, vuelve a intentarlo");
            }
        } while (!existe);
        RegistroPrestamo registro = devolverRegistroPrestamo(idPelicula);
        registro.setFinalizado(true);
        registro.cliente.setTienePeliculaPrestado(false);
        registro.pelicula.setDisponible(true);
        System.out.println("La devolucion ha sido exitosa");
    }

    public RegistroPrestamo devolverRegistroPrestamo(int idPelicula){
        RegistroPrestamo[] registros = tienda.getRegistrosPrestamo();
        RegistroPrestamo registro = null;
        for (int i = 0; i < registros.length; i++) {
            if (registros[i] != null) {
                if (registros[i].getIDPelicula() == idPelicula) {
                    registro = registros[i];
                    break;
                }
            }
        }
        return registro;
    }

    public int[] obtenerIDPeliculasPrestadas(){
        RegistroPrestamo[] registros = tienda.getRegistrosPrestamo();
        int[] idRegistros = new int[60];
        int contador = 0;
        for (int i = 0; i < registros.length; i++) {
            if (registros[i] != null) {
                if (registros[i].finalizado == false) {
                    idRegistros[contador] = registros[i].getIDPelicula();
                    contador++;
                }
            }
        }

        return idRegistros;
    }

}