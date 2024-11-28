package org.example;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import org.example.views.RestaurantView;

public class Main extends GameApplication {

    private RestaurantView restaurantView;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(2000);   // Ancho de la ventana
        settings.setHeight(1000);  // Alto de la ventana
        settings.setTitle("Simulador de Restaurante"); // Título de la ventana
        settings.setVersion("1.0");
    }

    @Override
    protected void initGame() {
        // Iniciar la simulación
        restaurantView = new RestaurantView();
        restaurantView.iniciarSimulacion();  // Llamamos a iniciar la simulación
    }

    @Override
    protected void onUpdate(double tpf) {
        // Aquí puedes colocar la lógica de actualización si es necesario
    }

    public static void main(String[] args) {
        launch(args);  // Inicia la aplicación FXGL
    }
}
