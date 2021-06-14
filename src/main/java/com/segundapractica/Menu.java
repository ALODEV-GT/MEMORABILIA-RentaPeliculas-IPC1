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
                    if (tienda.hayEspacioRegistros()) {
                        System.out.println("Ingresa tu id, para poder identificarte");
                        int idCliente = entrada.nextInt();
                        PrestarPelicula prestar = new PrestarPelicula(tienda);
                        prestar.prestarPelicula(idCliente);
                    } else {
                        System.out.println("Ya no se puede prestaro mas, ya no hay espacio en la tabal de registros");
                    }

                    break;
                case 2:
                    DevolverPelicula devolver = new DevolverPelicula(tienda);
                    devolver.dovolverPelicula();
                    break;
                case 3:
                    System.out.println("--------- Estas son todas las peliculas -------");
                    tienda.mostrarPeliculas(false);
                    System.out.println("[1] Ordenar peliculas   [2] Salir");
                    int eleccion = entrada.nextInt();
                    if (eleccion == 1) {
                        tienda.ordenarPeliculas();
                        tienda.mostrarPeliculas(false);
                    }

                    break;
                case 4:
                    if (tienda.hayEspacioPeliculas()) {
                        pedirDatosPelicula();
                    } else {
                        System.out.println("Ya no hay espacio para agregar mas peliculas");
                    }
                    break;
                case 5:
                    if (tienda.hayEspacioClientes()) {
                        pedirDatosCliente();
                    } else {
                        System.out.println("Ya no se pueden registrar mas clientes");
                    }
                    break;
                case 6:
                    System.out.println("--------- Estos son todos los clientes ----------");
                    tienda.mostrarClientes();
                    break;
                case 7:
                    boolean finalizado = false;
                    do {
                        Reportes reportes = new Reportes(this.tienda);
                        reportes.menuReportes();
                        finalizado = reportes.getFinalizado();
                    } while (finalizado == false);

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

    public void pedirDatosCliente() {
        String nombre;
        int id;
        int telefono;

        System.out.println("Ingrese su nombre: ");
        nombre = entrada.next();
        System.out.println("Ingrese su ID");
        id = ingresarIDCliente();
        System.out.println("Ingrese su numero de telefono");
        telefono = entrada.nextInt();

        tienda.registrarCliente(nombre, id, telefono);
    }

    public int ingresarIDCliente() {
        int id;
        boolean correcto = false;
        do {
            id = entrada.nextInt();
            if (MetodosBusqueda.busquedaSecuencialNumeros(tienda.obtenerIdClientes(), id) == false) {
                correcto = true;
            } else {
                System.out.println("Este id ya no esta disponible, vuelve a intentarlo");
            }
        } while (!correcto);
        return id;
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
                    Pelicula.contadorAccion++;
                    correcto = true;
                    break;
                case 2:
                    categoria = "Comedia";
                    Pelicula.contadorComedio++;
                    correcto = true;
                    break;
                case 3:
                    categoria = "Romance";
                    Pelicula.contadorRomance++;
                    correcto = true;
                    break;
                case 4:
                    categoria = "Animacion";
                    Pelicula.contadorAnimacion++;
                    correcto = true;
                    break;
                case 5:
                    categoria = "Terror";
                    Pelicula.contadorTerror++;
                    correcto = true;
                    break;
                default:
                    System.out.println("La opcion elegida, no existe. Vuelva a intentarlo");
                    break;
            }
        } while (!correcto);

        return categoria;
    }

    public void prestarPelicula() {

    }

    public void devolverPelicula() {

    }
}
