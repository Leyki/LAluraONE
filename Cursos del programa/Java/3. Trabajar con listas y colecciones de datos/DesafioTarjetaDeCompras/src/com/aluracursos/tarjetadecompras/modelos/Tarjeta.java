package com.aluracursos.tarjetadecompras.modelos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Tarjeta {
    private double limite;
    private double saldo = 0;
    public ArrayList<Item> itemsCargados = new ArrayList<>();


    public Tarjeta (double limite) {
        this.limite = limite;
    }

    public boolean cargar(Item item, boolean anunciar) {
        if (item.getCosto() + getSaldo() > getLimite()) {
            if (anunciar)
                System.out.printf("Límite insuficiente para agregar %s (%.2f$).\n", item.getNombre(), limite);
            return false;
        }
        if (anunciar)
            System.out.printf("Agregado %s (%.2f$) al carrito de compras.\n", item.getNombre(), item.getCosto());
        saldo += item.getCosto();
        itemsCargados.add(item);
        return true;
    }

    public void finalizarCompras(boolean anunciar) {
        limite -= saldo;
        Collections.sort(itemsCargados);
        if (anunciar) {
            System.out.println("--Items comprados--");
            for (Item item : itemsCargados) {
                System.out.printf("%s - %.2f$\n", item.getNombre(), item.getCosto());
            }
            System.out.println("---------");
            System.out.printf("límite restante: %.2f$\n", limite);
            System.out.printf("Saldo: %.2f$\n", saldo);
            System.out.println("---------\n");
        }
        saldo = 0;
    }


    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }



}
