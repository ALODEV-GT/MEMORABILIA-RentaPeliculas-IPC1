package com.segundapractica;

import java.util.Scanner;

public class Menu {

    Scanner entrada = new Scanner(System.in);
    Tienda tienda = new Tienda();

    public Menu() {
        mostrarMenu();
    }

    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("------- BIENVENIDO A MEMORABILIA -------");
            System.out.println("1.- Prestar pelicula");
            System.out.println("2.- Devolucion de pelicula");
            System.out.println("3.- Mostrar peliculas");
            System.out.println("4.- Ingresar pelicula");
            System.out.println("5.- Registrar cliente");
            System.out.println("6.- Mostrar clientes");
            System.out.println("7.- Ver reportes");
            System.out.println("8.- Salir");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    tienda.mostrarPeliculas();
                    break;
                case 4:
                    if (tienda.hayEspacioPeliculas()) {
                        pedirDatosPelicula();
                    } else {
                        System.out.println("Ya no hay espacio para agregar mas peliculas");
                    }
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    // Sale del menu (TERMINA EL PROGRAMA)
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }

        } while (opcion != 8);

    }

    public void pedirDatosPelicula() {
        int id;
        String nombre;
        int anio;
        String categoria;

        System.out.println("Ingrese un id: ");
        id = ingresarIDPelicula();
        entrada.nextLine();
        System.out.println("Ingrese el nombre: ");
        nombre = entrada.nextLine();
        System.out.println("Ingrese el anio: ");
        anio = entrada.nextInt();
        System.out.println("Ingrese la categoria");
        categoria = elegirCategoria();

        tienda.agregarPelicula(id, nombre, anio, categoria);
    }

    public int ingresarIDPelicula() {
        int id;
        boolean correcto = false;

        do {
            id = entrada.nextInt();
            if (MetodosBusqueda.busquedaSecuencialNumeros(tienda.obtenerIdPeliculas(), id) == false) {
                correcto = true;
            } else {
                System.out.println("Este id ya existe, vuele a intentarlo");
            }
        } while (!correcto);

        return id;
    }

    public String elegirCategoria() {
        int opcion;
        String categoria = "";
        boolean correcto = false;

        do {
            System.out.println("1.- Accion");
            System.out.println("2.- Comedia");
            System.out.println("3.- Romance");
            System.out.println("4.- Animacion");
            System.out.println("5.- Terror");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    categoria = "Accion";
                    correcto = true;
                    break;
                case 2:
                    categoria = "Comedia";
                    correcto = true;
                    break;
                case 3:
                    categoria = "Romance";
                    correcto = true;
                    break;
                case 4:
                    categoria = "Animacion";
                    correcto = true;
                    break;
                case 5:
                    categoria = "Terror";
                    correcto = true;
                    break;
                default:
                    System.out.println("La opcion elegida, no existe. Vuelva a intentarlo");
                    break;
            }
        } while (!correcto);

        return categoria;
    }

    public void registrarCliente() {

    }

    public void prestarPelicula() {

    }

    public void devolverPelicula() {

    }

    public void mostrarPeliculas() {

    }

}
