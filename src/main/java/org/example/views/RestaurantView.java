package org.example.views;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import static com.almasb.fxgl.dsl.FXGL.*;

public class RestaurantView extends GameApplication {

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setTitle("Simulador de Restaurante");
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setMainMenuEnabled(false);
    }

    @Override
    protected void initGame() {
        // Configurar fondo del restaurante
        getGameScene().setBackgroundRepeat("textures/restaurante_fondo.png");

        // Crear y posicionar la recepcionista
        Humans.crearRecepcionista(50, 50); // Entrada del restaurante

        // Crear y posicionar al chef
        Humans.crearChef(600, 400); // Fondo del restaurante

        // Crear y posicionar las mesas dispersas
        Humans.crearMesa(200, 200);
        Humans.crearMesa(400, 200);
        Humans.crearMesa(300, 350);
        Humans.crearMesa(500, 350);

        // Crear clientes en fila en el lado izquierdo
        for (int i = 0; i < 5; i++) {
            Humans.crearComensal(50, 150 + i * 70, "Comensal " + (i + 1));
        }

        // Crear y posicionar meseros cerca de las mesas
        Humans.crearMesero(220, 220); // Cerca de la primera mesa
        Humans.crearMesero(420, 220); // Cerca de la segunda mesa
    }

    public static void main(String[] args) {
        launch(args);
    }
}
