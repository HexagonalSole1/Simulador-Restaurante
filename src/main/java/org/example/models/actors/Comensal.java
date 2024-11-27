package org.example.models.actors;

import lombok.Getter;
import lombok.Setter;
import org.example.models.core.Persona;
import org.example.models.Restaurant;
import org.example.controllers.ComensalController;

@Getter
@Setter
public class Comensal extends Persona implements Runnable {
    private int mesaAsignada;
    private final ComensalController controlador;

    public Comensal(String nombre, int id) {
        super(nombre, id);
        this.controlador = new ComensalController(); // Instancia vacía del controlador
    }

    public void inicializarVisual(String nombre, double x, double y) {
        controlador.crearComensal(nombre, x, y); // Inicializar la posición visual del comensal
    }

    @Override
    public void realizarAccion() {
        System.out.println("Comensal " + nombre + " está esperando una mesa.");
    }

    @Override
    public void run() {
        try {
            controlador.mover(100, 100); // Mover al comensal a la recepción
            realizarAccion();
            Restaurant.recepcionista.atenderComensal(this);

            controlador.mover(200 + mesaAsignada * 100, 200); // Mover al comensal a la mesa asignada
            System.out.println("Comensal " + nombre + " está sentado y espera al mesero.");

            int meseroIndex = (id % Restaurant.meseros.size());
            Restaurant.meseros.get(meseroIndex).atenderPedido(this);

            Thread.sleep(2000); // Simula tiempo comiendo
            System.out.println("Comensal " + nombre + " terminó de comer.");

            Restaurant.meseros.get(meseroIndex).limpiarMesa(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Comensal " + nombre + " fue interrumpido.");
        }
    }
}