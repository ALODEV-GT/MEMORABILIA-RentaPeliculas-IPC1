package com.segundapractica;

import java.util.Scanner;

public class Reportes {
    Scanner entrada = new Scanner(System.in);
    Cliente[] clientes;
    Pelicula[] peliculas;
    Tienda tienda;
    Cliente clientePrestando;

    public Reportes(Tienda tienda) {
        this.tienda = tienda;
        clientes = tienda.getClientes();
        peliculas = tienda.getPeliculas();
    }

    public void menuReportes() {
        int opcion;
        boolean correcto = false;
        System.out.println("-------------- MENU --------------");
        System.out.println("1.- Cantidad de peliculas por categoria");
        System.out.println("2.- Listar peliculas por categoria");
        System.out.println("3.- Reporte de las películas y la cantidad de veces que se presta");
        System.out.println("4.- Reporte de la película más prestada");
        System.out.println("5.- Reporte de la película menos prestada");
        System.out.println("6.- Salir");
        opcion = entrada.nextInt();
        switch (opcion) {
            case 1:
                mostrarCantidadPeliculasPorCategoria();
                break;
            case 2:
                menuListarPeliculasPorCategoria();
                break;
            case 3:
                tienda.mostrarPeliculas(false);
                break;
            case 4:

                break;
            case 5:

                break;
            default:
                break;
        }
    }

    public void mostrarPeliculaMasPrestada(){
        
    }

    public void mostrarPeliculaMenosPrestada(){

    }

    public void mostrarCantidadPeliculasPorCategoria() {
        System.out.println("-------- CANTIDAD DE PELICULAS POR CATEGORIA ---------");
        System.out.println("Peliculas de accion: " + Pelicula.contadorAccion);
        System.out.println("Peliculas de comedia: " + Pelicula.contadorComedio);
        System.out.println("Peliculas de romance: " + Pelicula.contadorRomance);
        System.out.println("Peliculas de animacion: " + Pelicula.contadorAnimacion);
        System.out.println("Peliculas de terror: " + Pelicula.contadorTerror);
    }

    public void menuListarPeliculasPorCategoria() {
        int opcion;
        System.out.println("1.- Accion");
        System.out.println("2.- Comedia");
        System.out.println("3.- Romance");
        System.out.println("4.- Animacion");
        System.out.println("5.- Terror");
        System.out.println("Seleccione la categoria: ");
        opcion = entrada.nextInt();

        switch (opcion) {
            case 1:
                listarPeliculasPorCategoria("Accion");
                break;
            case 2:
                listarPeliculasPorCategoria("Comedia");
                break;
            case 3:
                listarPeliculasPorCategoria("Romance");
                break;
            case 4:
                listarPeliculasPorCategoria("Animacion");
                break;
            case 5:
                listarPeliculasPorCategoria("Terror");
                break;
            default:
                break;
        }
    }

    public void listarPeliculasPorCategoria(String categoria) {
        boolean hay = false;
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] != null) {
                if (peliculas[i].getCategoria().equalsIgnoreCase(categoria)) {
                    System.out.println(peliculas[i]);
                    hay = true;
                }
            }
        }

        if (hay == false) {
            System.out.println("No hay peliculas de esta categoria");
        }
    }

}
