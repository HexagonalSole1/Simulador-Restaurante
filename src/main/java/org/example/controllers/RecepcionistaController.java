package org.example.controllers;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.dsl.FXGL;
import javafx.geometry.Point2D;

public class RecepcionistaController {
    private Entity recepcionistaEntity;

    // Constructor vacío para evitar inicialización temprana
    public RecepcionistaController() {}

    // Método para inicializar al recepcionista dentro del ciclo de vida de FXGL
    public void crearRecepcionista(String nombre, double x, double y) {
        this.recepcionistaEntity = FXGL.entityBuilder()
                .at(x, y)
                .viewWithBBox("recepcionista.png") // Imagen del recepcionista
                .buildAndAttach();
    }

    public void mover(double x, double y) {
        FXGL.animationBuilder()
                .duration(javafx.util.Duration.seconds(1))
                .translate(recepcionistaEntity)
                .to(new Point2D(x, y))
                .build()
                .start();
    }

}