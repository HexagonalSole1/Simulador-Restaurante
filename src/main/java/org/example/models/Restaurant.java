package org.example.models;

import org.example.models.actors.Comensal;
import org.example.models.actors.Mesero;
import org.example.models.actors.Recepcionista;
import org.example.models.restaurant.Cocina;
import org.example.utils.DistribucionPoisson;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {
    public static final Recepcionista recepcionista = new Recepcionista("Laura", 1, 1); // 1 mesa
    public static final Mesero meseros = new Mesero("Pedro", 2); // 1 mesero
    public static final Cocina cocina = new Cocina(1); // 1 cocinero

    public static void main(String[] args) {
        ExecutorService poolComensales = Executors.newCachedThreadPool();
        int idComensal = 1;
        int totalComensales = 2; // Límite de comensales

        for (int i = 0; i < totalComensales; i++) {
            poolComensales.submit(new Comensal("Comensal " + idComensal, idComensal++));
            try {
                Thread.sleep(DistribucionPoisson.generarIntervaloPoisson(0.5) * 1000); // Intervalo Poisson
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        poolComensales.shutdown();
        System.out.println("Simulación completada. Todos los comensales han sido atendidos.");
    }
}
