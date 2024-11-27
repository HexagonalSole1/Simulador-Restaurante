package org.example.models;

import org.example.config.Constants;
import org.example.models.actors.Comensal;
import org.example.models.actors.Mesero;
import org.example.models.actors.Recepcionista;
import org.example.models.restaurant.Cocina;
import org.example.monitores.ComidasMonitor;
import org.example.monitores.MesaMonitor;
import org.example.utils.DistribucionPoisson;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private static final MesaMonitor mesaMonitor = new MesaMonitor(5); // 5 mesas disponibles
    private static final ComidasMonitor comidasMonitor = new ComidasMonitor();

    public static final Recepcionista recepcionista = new Recepcionista("Laura", 1, mesaMonitor);
    public static final Cocina cocina = new Cocina(1); // 1 cocinero

    public static final List<Mesero> meseros = new ArrayList<>(); // Lista de meseros

    public static void inicializarMeseros(int numeroMeseros) {
        for (int i = 1; i <= numeroMeseros; i++) {
            meseros.add(new Mesero("Mesero " + i, i, mesaMonitor, comidasMonitor));
        }
    }

    public static void main(String[] args) {
        // Inicializa 3 meseros (por ejemplo)
        inicializarMeseros(1);

        ExecutorService poolComensales = Executors.newCachedThreadPool();

        int idComensal = 1;
        for (int i = 0; i < Constants.NUMERO_COMENSALES; i++) {
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

