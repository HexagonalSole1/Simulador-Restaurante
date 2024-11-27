package org.example.models.actors;

import lombok.Getter;
import lombok.Setter;
import org.example.models.core.Persona;
import org.example.models.Restaurant;


@Getter
@Setter
public class Comensal extends Persona implements Runnable {

    private int mesaAsignada;

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
            realizarAccion(); // Esperando una mesa
            Restaurant.recepcionista.atenderComensal(this); // El recepcionista asigna una mesa
            System.out.println("Comensal " + nombre + " está sentado y espera al mesero.");

            // Selección del mesero (round-robin)
            int meseroIndex = (id % Restaurant.meseros.size()); // Selección basada en el ID
            Mesero meseroAsignado = Restaurant.meseros.get(meseroIndex);

            meseroAsignado.atenderPedido(this); // El mesero asignado toma el pedido
            System.out.println("Comensal " + nombre + " espera su comida.");

            // Simula tiempo comiendo
            Thread.sleep(2000);
            System.out.println("Comensal " + nombre + " terminó de comer.");

            meseroAsignado.limpiarMesa(this); // El mesero asignado limpia la mesa
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Comensal " + nombre + " fue interrumpido.");
        }
    }

}