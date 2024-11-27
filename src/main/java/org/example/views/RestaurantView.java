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
        settings.setWidth(800);
        settings.setHeight(600);
    }

    @Override
    protected void initGame() {
        getGameScene().setBackgroundRepeat("fondo.png");

        // Inicializar controladores gráficos
        RecepcionistaController recepcionistaController = new RecepcionistaController();
        recepcionistaController.crearRecepcionista("Recepcionista", 50, 50);

        List<MeseroController> meseroControllers = new ArrayList<>();
        MeseroController meseroController = new MeseroController();
        meseroController.crearMesero("Mesero 1", 100, 100);
        meseroControllers.add(meseroController);

        // Crear mesas
        List<MesaController> mesaControllers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            MesaController mesaController = new MesaController();
            mesaController.crearMesa(i + 1, 200 + i * 100, 200); // Posicionar las mesas
            mesaControllers.add(mesaController);
        }

        // Conectar controladores con la lógica
        Restaurant.inicializarControladores(recepcionistaController, meseroControllers);

        // Iniciar simulación
        Restaurant.iniciarSimulacion();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
