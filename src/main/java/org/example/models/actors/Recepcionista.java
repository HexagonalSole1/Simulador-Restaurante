package org.example.models.actors;

import org.example.models.core.Persona;

public class Recepcionista extends Persona {
    private int mesasDisponibles;

    public Recepcionista(String nombre, int id, int capacidadMesas) {
        super(nombre, id);
        this.mesasDisponibles = capacidadMesas;
    }

    // Método sincronizado para asignar mesas
    public synchronized void atenderComensal(Comensal comensal) throws InterruptedException {
        realizarAccion();
        while (mesasDisponibles == 0) {
            System.out.println("Recepcionista " + getNombre() + ": No hay mesas disponibles para " + comensal.getNombre() + ". Esperando...");
            wait(); // Espera hasta que una mesa sea liberada
        }

        // Asigna una mesa
        mesasDisponibles--;
        System.out.println("Recepcionista " + getNombre() + ": Mesa asignada al comensal " + comensal.getNombre());

        // Simula tiempo de asignación
        Thread.sleep(1000);

        // Libera la mesa después de la atención
        liberarMesa(comensal);
    }

    // Método sincronizado para liberar mesas
    private synchronized void liberarMesa(Comensal comensal) {
        mesasDisponibles++;
        System.out.println("Recepcionista " + getNombre() + ": Mesa liberada por el comensal " + comensal.getNombre());
        notifyAll(); // Notifica a los comensales en espera
    }

    @Override
    public void realizarAccion() {
        System.out.println("Recepcionista " + nombre + " está verificando disponibilidad de mesas.");
    }
}
