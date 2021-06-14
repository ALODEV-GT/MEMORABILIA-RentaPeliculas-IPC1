package com.segundapractica;

import java.util.Scanner;

public class Reportes {
    Scanner entrada = new Scanner(System.in);
    Cliente[] clientes;
    Pelicula[] peliculas;
    Tienda tienda;
    Cliente clientePrestando;
    boolean finalizado = false;

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
                mostrarPeliculaMasPrestada();
                break;
            case 5:
                mostrarPeliculaMenosPrestada();
                break;
            default:
                finalizado = true;
                break;
        }
    }

    public boolean getFinalizado(){
        return this.finalizado;
    }

    public void mostrarPeliculaMasPrestada(){
        Pelicula peliculaMasPrestada = null;
        int mayor = 0;
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] != null) {
                if (peliculas[i].getVecesPrestada() > mayor) {
                    mayor = peliculas[i].getVecesPrestada();
                    peliculaMasPrestada = peliculas[i];
                }
            }
        }

        if (mayor == 0) {
            System.out.println("Todavia no hay una pelicula que destaque");
        }else{
            System.out.println("----- PELICULA MAS PRESTADA ---------");
            System.out.println(peliculaMasPrestada);
        }
    }

    public void mostrarPeliculaMenosPrestada(){
        Pelicula peliculaMenosPrestada = null;
        int menor = 100;

        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] != null) {

                if (peliculas[i].getVecesPrestada() < menor) {
                    menor = peliculas[i].getVecesPrestada();
                    peliculaMenosPrestada = peliculas[i];
                }
            }
        }

        if (peliculaMenosPrestada == null) {
            System.out.println("Todavia no hay peliculas");
        }else{
            System.out.println("------- PELICULA MENOS PRESTADA -------- ");
            System.out.println(peliculaMenosPrestada);
        }
        
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
        System.out.println("-------------------------------------");
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
