package org.example.models.actors;

import org.example.models.core.Persona;
import org.example.monitores.ComidasMonitor;
import org.example.monitores.MesaMonitor;

public class Mesero extends Persona {
    private final MesaMonitor mesaMonitor;
    private final ComidasMonitor cocinaMonitor;

    public Mesero(String nombre, int id, MesaMonitor mesaMonitor, ComidasMonitor cocinaMonitor) {
        super(nombre, id);
        this.mesaMonitor = mesaMonitor;
        this.cocinaMonitor = cocinaMonitor;
    }

    @Override
    public void realizarAccion() {
        System.out.println("Mesero " + nombre + " está atendiendo a un comensal.");
    }

    // Método para atender un pedido
    public synchronized void atenderPedido(Comensal comensal) throws InterruptedException {
        realizarAccion();
        System.out.println("Mesero " + getNombre() + " está tomando el pedido del comensal " + comensal.getNombre());

        // Enviar el pedido a la cocina
        cocinaMonitor.nuevoPedido(comensal.getMesaAsignada());
        System.out.println("Mesero " + getNombre() + " ha enviado el pedido de la mesa " + comensal.getMesaAsignada() + " a la cocina.");

        // Simula tiempo para entregar el pedido
        Thread.sleep(1000);

        // Recoger el pedido de la cocina
        recogerPedido(comensal);
    }

    // Método para recoger un pedido de la cocina
    private synchronized void recogerPedido(Comensal comensal) throws InterruptedException {
        int idMesa = cocinaMonitor.tomarPedido();
        System.out.println("Mesero " + getNombre() + " ha recogido el pedido de la mesa " + idMesa);

        // Entregar el pedido al comensal
        System.out.println("Mesero " + getNombre() + ": Pedido entregado al comensal " + comensal.getNombre());
    }

    // Método para limpiar una mesa
    public synchronized void limpiarMesa(Comensal comensal) throws InterruptedException {
        System.out.println("Mesero " + getNombre() + " está limpiando la mesa del comensal " + comensal.getNombre());
        mesaMonitor.liberarMesa(comensal.getMesaAsignada()); // Libera la mesa en el monitor
        Thread.sleep(500); // Simula tiempo de limpieza
        System.out.println("Mesero " + getNombre() + ": Mesa " + comensal.getMesaAsignada() + " ha sido limpiada.");
    }
}