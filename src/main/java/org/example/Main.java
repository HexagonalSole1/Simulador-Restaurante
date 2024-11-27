package org.example;
import org.example.views.RestaurantView;

public class Main {
    public static void main(String[] args) {
        RestaurantView controller = new RestaurantView();
        controller.iniciarSimulacion(5, 0.5); // Simula con 5 meseros y una tasa de Poisson de 0.5
    }
}
