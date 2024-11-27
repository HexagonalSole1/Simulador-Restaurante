package org.example.views;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import org.example.controllers.MesaController;
import org.example.controllers.MeseroController;
import org.example.controllers.RecepcionistaController;
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

        // Inicializar controladores gráficos
        RecepcionistaController recepcionistaController = new RecepcionistaController();
        recepcionistaController.crearRecepcionista("Recepcionista", 100, 50);

        List<MeseroController> meseroControllers = new ArrayList<>();
        MeseroController meseroController = new MeseroController();
        meseroController.crearMesero("Mesero 1", 150, 150);
        meseroControllers.add(meseroController);

        // Crear mesas distribuidas en filas y columnas
        List<MesaController> mesaControllers = new ArrayList<>();
        int mesasPorFila = 3; // Número de mesas por fila
        int espacioHorizontal = 250; // Espacio entre mesas horizontalmente
        int espacioVertical = 200; // Espacio entre mesas verticalmente

        for (int fila = 0; fila < 2; fila++) { // Dos filas
            for (int columna = 0; columna < mesasPorFila; columna++) { // Tres columnas por fila
                int numeroMesa = fila * mesasPorFila + columna + 1;
                MesaController mesaController = new MesaController();
                mesaController.crearMesa(
                        numeroMesa,
                        200 + columna * espacioHorizontal, // Posición X
                        200 + fila * espacioVertical      // Posición Y
                );
                mesaControllers.add(mesaController);
            }
        }

        // Conectar controladores con la lógica
        Restaurant.inicializarControladores(recepcionistaController, meseroControllers);
        Restaurant.inicializarMesas(mesaControllers);

        // Iniciar simulación
        Restaurant.iniciarSimulacion();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
