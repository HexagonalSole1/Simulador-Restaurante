package org.example.models;

import org.example.config.Constants;
import org.example.models.actors.Comensal;
import org.example.models.actors.Mesero;
import org.example.models.actors.Recepcionista;
import org.example.models.restaurant.Cocina;
import org.example.monitores.ComidasMonitor;
import org.example.monitores.MesaMonitor;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private static final MesaMonitor mesaMonitor = new MesaMonitor(5); // 5 mesas disponibles
    private static final ComidasMonitor comidasMonitor = new ComidasMonitor();
    public static final Recepcionista recepcionista = new Recepcionista("Laura", 1, mesaMonitor);

    public static final List<Mesero> meseros = new ArrayList<>();

    public static void inicializarMeseros(int numeroMesas) {
        for (int i = 0; i < numeroMesas; i++) {
            meseros.add(new Mesero("Mesero " + (i + 1), i + 1, i, mesaMonitor, comidasMonitor));
        }
    }

    // Obtener el mesero asignado a una mesa
    public static Mesero obtenerMeseroPorMesa(int mesa) {
        return meseros.stream().filter(m -> m.getMesaAsignada() == mesa).findFirst().orElse(null);
    }
}