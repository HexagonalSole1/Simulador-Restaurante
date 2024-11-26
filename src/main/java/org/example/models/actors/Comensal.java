package org.example.models.actors;

import org.example.models.core.Persona;
import org.example.models.Restaurant;

public class Comensal extends Persona implements Runnable {
    public Comensal(String nombre, int id) {
        super(nombre, id);
    }

    @Override
    public void realizarAccion() {
        System.out.println("Comensal " + nombre + " está esperando una mesa.");
    }

    @Override
    public void run() {
        try {
            realizarAccion();
            Restaurant.recepcionista.atenderComensal(this); // Interactúa con el recepcionista
            Restaurant.meseros.atenderPedido(this);         // Interactúa con el mesero
            Restaurant.cocina.prepararPedido(this);         // Interactúa con la cocina
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
