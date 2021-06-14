package com.segundapractica;

public class RegistroPrestamo {
        int idCliente;
        int idPelicula;
        int diasPrestados;

        public RegistroPrestamo(int idCliente, int idPelicula, int diasPrestados){
            this.idCliente = idCliente;
            this.idPelicula = idPelicula;
            this.diasPrestados = diasPrestados;
        }
}