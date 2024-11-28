package org.example.views;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.views.components.RecepcionistaComponent;

import java.util.ArrayList;
import java.util.List;

public class RestaurantView {

    private List<ComensalView> comensales;  // Lista de comensales
    private List<MeseroView> meseros;  // Lista de meseros
    private RecepcionistaView recepcionistaView;  // Vista del recepcionista
    private Entity backgroundEntity;  // Entidad del fondo

    public RestaurantView() {
        this.comensales = new ArrayList<>();
        this.meseros = new ArrayList<>();
        this.recepcionistaView = new RecepcionistaView(100, 200);

        // Crear la entidad de fondo
        ImageView backgroundImageView = new ImageView(new Image("assets/textures/fondo.png"));

        // Ajustar el tamaño de la imagen al tamaño de la ventana
        backgroundImageView.setFitWidth(FXGL.getAppWidth());
        backgroundImageView.setFitHeight(FXGL.getAppHeight());

        // Crear la entidad del fondo y agregarla al mundo
        this.backgroundEntity = FXGL.entityBuilder()
                .at(0, 0) // Ubicación inicial del fondo
                .view(backgroundImageView) // Asignar la imagen al fondo
                .buildAndAttach();

        // Añadir el fondo al mundo del juego
        FXGL.getGameWorld().addEntity(backgroundEntity);

        // Añadir el recepcionista al mundo
        FXGL.getGameWorld().addEntity(recepcionistaView.getEntity());
    }

    public void agregarComensal(double startX, double startY, double mesaX, double mesaY) {
        // Crear un comensal y asignar mesa
        ComensalView comensal = new ComensalView(startX, startY);
        comensal.moverAMesa(mesaX, mesaY);
        comensales.add(comensal);

        // Asignar mesa si está disponible
        if (recepcionistaView.verificarDisponibilidad()) {
            recepcionistaView.asignarMesa();
            System.out.println("Mesa asignada al comensal.");
        } else {
            System.out.println("Esperando por mesa...");
        }
    }

    public void meseroAtiende(int meseroIndex, double comensalX, double comensalY) {
        // Llamar a un mesero para que atienda a un comensal
        if (meseroIndex < meseros.size()) {
            meseros.get(meseroIndex).atenderComensal(comensalX, comensalY);
            System.out.println("Mesero " + meseroIndex + " atiende al comensal en la mesa.");
        } else {
            System.out.println("No hay mesero para atender.");
        }
    }

    public void agregarMesero(MeseroView mesero) {
        meseros.add(mesero);
    }
}
