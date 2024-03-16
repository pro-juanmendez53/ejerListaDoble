package edu.ejercicios;

import edu.ejercicios.ListaDobleEnlace.ListaDoble;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ListaDoble listaDos= new ListaDoble();

        listaDos.agregarInicio(4);
        listaDos.agregarInicio(5);
        listaDos.agregarAlFinal(5);
        listaDos.agregarInicio(2);

        System.out.println(listaDos.mostarListaInicio());
        //System.out.println(listaDos.mostrarListaFin());

//        listaDos.eliminarInicio();
//        listaDos.eliminarAlFinal();
//        System.out.println(listaDos.mostarListaInicio());

//        listaDos.agregarEnMedio(1);
//        System.out.println(listaDos.mostarListaInicio());


//        listaDos.eliminarRepetidos();
//        System.out.println(listaDos.mostarListaInicio());

//        listaDos.eliminarEnMedio();
//        System.out.println(listaDos.mostarListaInicio());
        System.out.println("Ti lista tiene un tamaño de: " + listaDos.getCantidadDatos());

    }
}
//insertar en medio, eliminar en medio, revertir lista, tamaño de la lista, eliminar duplicados