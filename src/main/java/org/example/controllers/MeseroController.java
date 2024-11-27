package org.example.controllers;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.dsl.FXGL;
import javafx.geometry.Point2D;

public class MeseroController {
    private Entity meseroEntity;

    // Constructor vacío para evitar inicialización temprana
    public MeseroController() {}

    // Método para inicializar al mesero dentro del ciclo de vida de FXGL
    public void crearMesero(String nombre, double x, double y) {
        this.meseroEntity = FXGL.entityBuilder()
                .at(x, y)
                .viewWithBBox("mesera.png") // Imagen del mesero
                .buildAndAttach();
    }

    // Método para mover al mesero visualmente
    public void mover(double x, double y) {
        FXGL.animationBuilder()
                .duration(javafx.util.Duration.seconds(1))
                .translate(meseroEntity)
                .to(new Point2D(x, y))
                .build()
                .start();
    }

}
