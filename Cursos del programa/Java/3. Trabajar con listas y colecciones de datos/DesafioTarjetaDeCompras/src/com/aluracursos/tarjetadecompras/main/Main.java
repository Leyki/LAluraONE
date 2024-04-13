package com.aluracursos.tarjetadecompras.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.aluracursos.tarjetadecompras.modelos.*;


public class Main {
    public static void main(String[] args) {
        boolean cargando = true;
        Tarjeta tarjeta;

        var teclado = new Scanner(System.in);

        System.out.println("""
                ¡Bienvenido!
                
                Indique el límite de su tarjeta:""");
        tarjeta = new Tarjeta(teclado.nextDouble());


        int opcion;
        while (cargando) {
            System.out.println("Escriba 1 para agregar un ítem o 9 para finalizar las compras.");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Escriba el nombre del producto:");
                    String nombre = teclado.next();
                    System.out.println("Escriba el costo del producto:");
                    double costo = teclado.nextInt();
                    var item = new Item(nombre, costo);
                    tarjeta.cargar(item, true);

                    break;
                case 9:
                    System.out.println("Finalizando compras.");
                    tarjeta.finalizarCompras(true);
                    cargando = false;
                    break;
                default:
                    System.out.println("Opción no reconocida.");
            }
        }
        System.out.printf("");
    }
}

