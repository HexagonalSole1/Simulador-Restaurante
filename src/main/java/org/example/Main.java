package org.example;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import org.example.views.RestaurantView;
import org.example.views.MeseroView;

public class Main extends GameApplication {

    private RestaurantView restaurantView;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);   // Ancho de la ventana
        settings.setHeight(600);  // Alto de la ventana
        settings.setTitle("Simulador de Restaurante"); // Título de la ventana
        settings.setVersion("1.0");
    }

    @Override
    protected void initGame() {
        // Inicializamos la vista del restaurante
        restaurantView = new RestaurantView();

        // Agregamos meseros
        restaurantView.agregarMesero(new MeseroView(200, 100));
        restaurantView.agregarMesero(new MeseroView(400, 100));

        // Creamos algunos comensales y los agregamos al restaurante
        restaurantView.agregarComensal(50, 100, 300, 200);  // Comensal en la posición (50, 100)
        restaurantView.agregarComensal(150, 100, 350, 200); // Otro comensal en (150, 100)

        // Simulamos que un mesero atiende a un comensal
        restaurantView.meseroAtiende(0, 300, 200);  // El mesero en índice 0 atiende al comensal en (300, 200)
    }

    @Override
    protected void onUpdate(double tpf) {
        // Lógica de actualización de la simulación, si es necesario
    }

    public static void main(String[] args) {
        launch(args);  // Inicia la aplicación FXGL
    }
}
