package org.example.views;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import org.example.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

import static com.almasb.fxgl.dsl.FXGL.*;

public class RestaurantView extends GameApplication {
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setTitle("Simulador de Restaurante");
        settings.setWidth(1200);
        settings.setHeight(800);
    }

    @Override
    protected void initGame() {
        getGameScene().setBackgroundRepeat("fondo.png");

        // Crear recepcionista
        RecepcionistaView recepcionistaView = new RecepcionistaView();
        recepcionistaView.crearRecepcionista("Recepcionista", 100, 50);

        // Crear mesero
        MeseroView meseroView = new MeseroView();
        meseroView.crearMesero("Mesero 1", 150, 150);

        // Crear mesas
        List<MesaView> mesaViews = new ArrayList<>();
        int mesasPorFila = 3; // Número de mesas por fila
        int espacioHorizontal = 250;
        int espacioVertical = 200;

        for (int fila = 0; fila < 2; fila++) { // Dos filas de mesas
            for (int columna = 0; columna < mesasPorFila; columna++) {
                int numeroMesa = fila * mesasPorFila + columna + 1;
                MesaView mesaView = new MesaView();
                mesaView.crearMesa(numeroMesa, 300 + columna * espacioHorizontal, 200 + fila * espacioVertical);
                mesaViews.add(mesaView);
            }
        }

        // Conectar visualización con la lógica
        Restaurant.inicializarMesas(mesaViews);
        Restaurant.iniciarSimulacion();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void iniciarSimulacion(int i, double v) {
    }
}
