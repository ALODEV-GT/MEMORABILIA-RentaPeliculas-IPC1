package com.segundapractica;

public class MetodosBusqueda {
    public static boolean busquedaSecuencialNumeros(int[] arreglo, int numABuscar){
        boolean existe = false;
        for (int i = 0; i < arreglo.length; i++) {
            if (numABuscar == arreglo[i]) {
                existe = true;
                break;
            }
        }        
        return existe;   
    }

}
