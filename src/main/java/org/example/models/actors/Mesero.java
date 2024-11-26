package org.example.models.actors;

import org.example.models.core.Persona;
import org.example.models.Restaurant;


public class Mesero extends Persona {
    public Mesero(String nombre, int id) {
        super(nombre, id);
    }

    @Override
    public void realizarAccion() {
        System.out.println("Mesero " + nombre + " está atendiendo a un comensal.");
    }

    public synchronized void atenderPedido(Comensal comensal) throws InterruptedException {
        realizarAccion();
        System.out.println("Mesero " + getNombre() + " está atendiendo el pedido del comensal " + comensal.getNombre());
        Thread.sleep(1000); // Simula tiempo de atención
        System.out.println("Mesero " + getNombre() + ": Pedido entregado al comensal " + comensal.getNombre());
    }
}

