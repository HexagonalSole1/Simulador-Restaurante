package org.example.models;

import org.example.controllers.MeseroController;
import org.example.controllers.RecepcionistaController;
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

    public static final Cocina cocina = new Cocina(1); // 1 cocinero
    public static final List<Mesero> meseros = new ArrayList<>(); // Lista de meseros
    public static Recepcionista recepcionista;

    private static RecepcionistaController recepcionistaController;
    private static List<MeseroController> meseroControllers = new ArrayList<>();

    // Inicializar los controladores desde la vista
    public static void inicializarControladores(RecepcionistaController recepcionistaCtrl, List<MeseroController> meseroCtrlList) {
        recepcionistaController = recepcionistaCtrl;
        meseroControllers = meseroCtrlList;
    }

    public static void iniciarSimulacion() {
        // Inicializar meseros
        inicializarMeseros(1);

        ExecutorService poolComensales = Executors.newCachedThreadPool();
        int idComensal = 1;

        for (int i = 0; i < 5; i++) { // Número de comensales
            Comensal comensal = new Comensal("Comensal " + idComensal, idComensal++);

            // Mover visualmente al comensal a la recepción
            int finalId = idComensal - 1;
            poolComensales.submit(() -> {
                recepcionistaController.mover(50, 50); // Recepcionista asignando
                System.out.println("Recepcionista Laura está verificando disponibilidad de mesas.");

                try {
                    Thread.sleep(1000);
                    System.out.println("Recepcionista Laura asignó al comensal " + finalId);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            try {
                Thread.sleep(DistribucionPoisson.generarIntervaloPoisson(0.5) * 1000); // Intervalo Poisson
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        poolComensales.shutdown();
        System.out.println("Simulación completada. Todos los comensales han sido atendidos.");
    }

    private static void inicializarMeseros(int numeroMeseros) {
        for (int i = 1; i <= numeroMeseros; i++) {
            Mesero mesero = new Mesero("Mesero " + i, i, mesaMonitor, comidasMonitor);
            meseros.add(mesero);
        }
    }
}
