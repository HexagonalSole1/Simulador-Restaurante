package org.example;

import org.example.models.restaurant.Cocina;
import org.example.models.actors.Comensal;
import org.example.models.actors.Mesero;
import org.example.models.actors.Recepcionista;
import org.example.utils.DistribucionPoisson;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final Recepcionista recepcionista = new Recepcionista("Laura", 1, 1); // 1 mesa
    public static final Mesero meseros = new Mesero("Pedro", 2); // 2 meseros
    public static final Cocina cocina = new Cocina(1); // 1 cocinero

    public static void main(String[] args) {
        ExecutorService poolComensales = Executors.newCachedThreadPool();
        int idComensal = 1;

        // Límite de 2 comensales
        int totalComensales = 2;

        for (int i = 0; i < totalComensales; i++) {
            // Crear y enviar un comensal al pool
            poolComensales.submit(new Comensal("Comensal " + idComensal, idComensal++));
            try {
                // Simula tiempo entre llegadas
                Thread.sleep(DistribucionPoisson.generarIntervaloPoisson(0.5) * 1000); // Intervalo Poisson (lambda = 0.5)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Cierra el pool de hilos después de completar las tareas
        poolComensales.shutdown();
        System.out.println("Simulación completada. Todos los comensales han sido atendidos.");
    }
}
